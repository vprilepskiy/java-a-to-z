package ru.job4j.controller.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class FileUpload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Убедитесь, что у нас есть запрос на загрузку файла
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);


        // Создание фабрики для файлов на диске.
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Конфигурирование репозитория (чтобы обеспечить безопасное временное местоположение)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Создаем новый обработчик переноса файлов
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Разбор запроса
        try {
            List<FileItem> items = upload.parseRequest(req);

            // Обработать загруженные элементы
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    processFormField(item);
                } else {
                    processUploadedFile(item);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


    private void processFormField(FileItem item) {
        // Обработать регулярное поле формы
        if (item.isFormField()) {
            String name = item.getFieldName();
            String value = item.getString();
        }
    }


    private void processUploadedFile(FileItem item) {
        // Обработка загрузки файла
        if (!item.isFormField()) {
            String fieldName = item.getFieldName();
            String fileName = item.getName();
            String contentType = item.getContentType();
            boolean isInMemory = item.isInMemory();
            long sizeInBytes = item.getSize();
        }
    }


    /**
     * Записать в файл или в поток.
     * @param item
     * @param writeToFile
     * @throws Exception
     */
    private void upload(FileItem item, Boolean writeToFile) throws Exception {
        // Обработка загрузки файла
        if (writeToFile) {
            File uploadedFile = new File ("sdf");
            item.write (uploadedFile);
        } else {
            InputStream uploadedStream = item.getInputStream ();
            uploadedStream.close ();
        }
    }


    private byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        return IOUtils.toByteArray(inputStream);
    }
}

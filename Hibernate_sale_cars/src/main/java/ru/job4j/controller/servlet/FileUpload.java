package ru.job4j.controller.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.model.entity.Item;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class FileUpload extends HttpServlet {

    /**
     * Write file in DB.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - Exception.
     * @throws IOException - Exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Item photo = this.fileUpload(req);

        HibernateORM.getInstance().updatePhoto(photo);

        resp.sendRedirect("/MyItems.html");
    }


    /**
     * Get from Request photo and item_id.
     * @param req - request.
     * @return - photo.
     */
    private Item fileUpload(HttpServletRequest req) {
        final Item photo = new Item();

        // Убедитесь, что у нас есть запрос на загрузку файла
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            throw new IllegalArgumentException();
        }

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
            List<FileItem> fileItems = upload.parseRequest(req);

            // Обработать загруженные элементы
            Iterator<FileItem> it = fileItems.iterator();
            while (it.hasNext()) {
                FileItem item = it.next();

                if (item.isFormField()) {
                    // Обработать регулярное поле формы
                    String name = item.getFieldName();
                    String value = item.getString();
                    if (name.equals("item_id")) {
                        int itemId = Integer.parseInt(value);
                        photo.setId(itemId);
                    }
                } else {
                    // Обработка загрузки файла
                    byte[] bytes = item.get();
                    photo.setPhoto(bytes);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        return photo;
    }
}



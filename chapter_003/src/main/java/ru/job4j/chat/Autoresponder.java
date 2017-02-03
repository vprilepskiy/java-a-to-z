package ru.job4j.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 22.01.2017.
 */
public class Autoresponder {

    /**
     * Команда для остановки.
     */
    private final String stop = "stop";
    /**
     * Команда для возобновления.
     */
    private final String start = "start";
    /**
     * Команда для выхода.
     */
    private final String exit = "exit";

    /**
     * Выводит в консоль случайные фразы.
     *
     * @param pathWordBook - путь к файлу со строками.
     * @param pathLog - путь к log файлу.
     */
    public void autoBot(String pathWordBook, String pathLog) {

        FileWriter logFileWriter = null;
        Scanner consoleInput = null;
        try {
            logFileWriter = new FileWriter(pathLog);
            consoleInput = new Scanner(System.in);

            boolean mode = true;
            String request = "";

            // цикл закончится когда встретит фразу "закончить".
            do {
                // ввод с консоли
                request = consoleInput.nextLine();
                // запишем в лог
                logFileWriter.write(request);
                logFileWriter.write("\n");

                if ((request.equals(this.stop)) || (request.equals(this.exit))) {
                    mode = false;
                } else if (request.equals(this.start)) {
                    mode = true;
                }

                if (mode) {
                    // получим ответ
                    String answer = getRandomWord(pathWordBook);
                    // запишем в лог
                    logFileWriter.write(answer);
                    logFileWriter.write("\n");
                    // вывод в консоль
                    System.out.println(answer);
                }
            } while (!(request.equals(this.exit)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                logFileWriter.flush();
                logFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                consoleInput.close();
            }
        }
    }



    /**
     * Вернет случайную строку из файла.
     *
     * @param pathWordBook - путь к файлу со строками.
     * @return - случайная фраза
     * @throws IOException - упадет если случится ошибка чтения файла.
     */
    public String getRandomWord(String pathWordBook) throws IOException {
        // ограничить кол-во попыток чтения файла чтобы не зависла в цикле
        final int maxCountLoop = 100;
        RandomAccessFile randomAccessFile = null;
        randomAccessFile = new RandomAccessFile(pathWordBook, "r");
        long sizeFile = new File(pathWordBook).length();
        if (sizeFile == 0) {
            throw new FileNullSizeException(pathWordBook + " size null!!!");
        }
        int countLoop = 0;
        String randomString = null;
        do {
            long randomNumber = Math.abs(new Random().nextLong() % sizeFile);
            // устанавливаем позицию
            randomAccessFile.seek(randomNumber);
            // читаем до конца строки
            randomAccessFile.readLine();
            // читаем целую строку
            randomString = randomAccessFile.readLine();
            // проверяем кол-во попыток чтения
            if (countLoop >= maxCountLoop) {
                throw new FileNullSizeException(pathWordBook + " does not contain lines more than one!!!");
            }
            countLoop++;
        } while (randomString == null);
        return randomString;
    }


}


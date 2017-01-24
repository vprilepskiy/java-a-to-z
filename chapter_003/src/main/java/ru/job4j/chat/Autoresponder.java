package ru.job4j.chat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 22.01.2017.
 */
public class Autoresponder {

    private final String stop = "stop";
    private final String start = "start";
    private final String exit = "exit";

    /**
     *
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
                /*none*/
            } finally {
                consoleInput.close();
            }
        }
    }

    /**
     * Вернет случайную строку из файла.
     *
     * @param pathWordBook
     * @return
     * @throws IOException
     */
    public String getRandomWord(String pathWordBook) throws IOException {
        RandomAccessFile randomAccessFile = null;
        randomAccessFile = new RandomAccessFile(pathWordBook, "r");
        long sizeFile;
        if ((sizeFile = new File(pathWordBook).length()) == 0) {
            throw new FileNullSizeException(pathWordBook + " size null!!!");
        }
        int countLoop = 100;
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
            if (countLoop <= 0) {
                throw new FileNullSizeException(pathWordBook + " does not contain lines more than one!!!");
            }
            countLoop--;
        } while (randomString == null);
        return randomString;
    }


}


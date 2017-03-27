package ru.job4j.manager;

/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface IActions {

    /**
     * Выйти.
     */
    void exit();

    /**
     * Отправляет в поток информацию о содержании такущего каталога.
     */
    void show();

    /**
     * Переход в каталог выше.
     * @param select - Имя папки в которую следует перейти.
     */
    void goToDirectory(String select);

    /**
     * Переход в домашний каталог.
     */
    void toHomeDir();

    /**
     * Отправит в поток запрашивемый файл.
     * @param fileName - имя файла.
     */
    void upload(String fileName);

    /**
     * Получит из потока отправляемый файл.
     * @param fileName - имя файла.
     */
    void download(String fileName);

    /**
     * Неизвестная комманда.
     */
    void unknownCommand();

    /**
     * Отпревить сообщение в поток.
     * @param message - сообщение.
     */
    void sendMessage(String message);

    /**
     * Считать сообщение из потока.
     */
    void readMessage();
}

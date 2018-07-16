package ru.cbr.ekb.prilepskiy;

import ru.cbr.ekb.prilepskiy.model.entity.Document;
import ru.cbr.ekb.prilepskiy.model.store.Repository;

import java.util.*;


/**
 * Created by VLADIMIR on 12.07.2018.
 */
public class Dispatcher implements IDispatcher {

    private volatile boolean stop;

    private final Repository repository = new Repository();

    private Thread thread;


    @Override
    public Collection<Document> stop() {
        this.stop = true;
        final List<Document> result = new LinkedList<>(this.repository.getDocumentQueue());
        this.repository.getDocumentQueue().clear();
        return result;
    }


    @Override
    public void accept(Document document) {
        this.stop = false;
        this.repository.getDocumentQueue().add(document);

        // если потока нет или остановлен, то создать новый и запустить
        if (this.thread == null || !this.thread.isAlive()) {
            this.thread = new Thread(new Printer());
            this.thread.start();
        }
    }


    @Override
    public boolean abort(Document document) {
        return this.repository.getDocumentQueue().remove(document);
    }


    @Override
    public Collection<Document> getPrintedDocuments(int sortingType) {
        List<Document> result = new ArrayList<>(this.repository.getDocumentPrinted());

        switch (sortingType) {
            case 1:
                break;

            case 2:
                Collections.sort(result, new Comparator<Document>() {
                    @Override
                    public int compare(Document o1, Document o2) {
                        return o1.getTypeName().compareTo(o2.getTypeName());
                    }
                });
                break;

            case 3:
                Collections.sort(result, new Comparator<Document>() {
                    @Override
                    public int compare(Document o1, Document o2) {
                        return new Long(o1.getPrintingTime()).compareTo(new Long(o2.getPrintingTime()));
                    }
                });

            case 4:
                Collections.sort(result, new Comparator<Document>() {
                    @Override
                    public int compare(Document o1, Document o2) {
                        return o1.getPaperSize().compareTo(o2.getPaperSize());
                    }
                });

            default:
                break;
        }
        return result;
    }


    @Override
    public long getAveragePrintTime() {
        long result = 0;

        for (Document document : this.repository.getDocumentPrinted()) {
            result += document.getPrintingTime();
        }

        if (this.repository.getDocumentPrinted().size() != 0) {
            result /= this.repository.getDocumentPrinted().size();
        }

        return result;
    }


    /**
     * Printer.
     */
    private class Printer implements Runnable {

        @Override
        public void run() {
            try {
                Document document;

                // получать и удалять документы из очереди пока очередь не опустеет.
                while ((stop == false) && ((document = repository.getDocumentQueue().poll()) != null)) {
                    // поместить документ в напечатанные
                    repository.getDocumentPrinted().add(document);
                    // эмуляция печати
                    Thread.sleep(document.getPrintingTime());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Типы сортировки.
     * 1 - по порядку печати
     * 2 - по типу документов
     * 3 - по продолжительности печати
     * 4 - по размеру бумаги
     */
    public enum OrderBy {
        PRINTING(1),
        TYPE_OF_DOCUMENT(2),
        TIME_OF_PRINTING(3),
        PAPER_SIZE(4);

        private final int index;

        OrderBy(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }
}

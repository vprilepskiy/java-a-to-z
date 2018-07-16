package ru.cbr.ekb.prilepskiy.model.store;

import ru.cbr.ekb.prilepskiy.model.entity.Document;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by VLADIMIR on 12.07.2018.
 *
 * Repository.
 */
public class Repository {

    /**
     * Queue.
     */
    private final Queue<Document> documentQueue = new ConcurrentLinkedQueue();

    /**
     * Printed.
     */
    private final Queue<Document> documentPrinted = new ConcurrentLinkedQueue();

    /**
     * Getter.
     * @return - Queue.
     */
    public Queue<Document> getDocumentQueue() {
        return this.documentQueue;
    }

    /**
     * Getter.
     * @return - Printed.
     */
    public Queue<Document> getDocumentPrinted() {
        return this.documentPrinted;
    }
}

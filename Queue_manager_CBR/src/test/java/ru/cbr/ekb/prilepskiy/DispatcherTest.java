package ru.cbr.ekb.prilepskiy;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.collections.Iterables;
import ru.cbr.ekb.prilepskiy.model.entity.Document;
import ru.cbr.ekb.prilepskiy.model.entity.PaperSize;

import javax.print.Doc;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 13.07.2018.
 */
public class DispatcherTest {

    /**
     * Data.
     */
    final Document doc1 = new Document(1000, "Doc1", new PaperSize("A4", 210, 297));
    /**
     * Data.
     */
    final Document doc2 = new Document(800, "Doc2", new PaperSize("A5", 210, 148));
    /**
     * Data.
     */
    final Document doc3 = new Document(1200, "Doc3", new PaperSize("A3", 297, 420));
    /**
     * Data.
     */
    final Document doc4 = new Document(1500, "Doc4", new PaperSize("A2", 420, 594));

    /**
     * Delay in executing machine code.
     */
    final long runningTime = 500;

    @Test
    public void whenPrintAll() throws InterruptedException {

        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // result
        final Collection<Document> resultEmptyPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.PRINTING.index());

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.PRINTING.index());
        final Collection<Document> resultNotPrintedDocuments = dispatcher.stop();

        // expect
        final List<Document> expectPrintedDocumentsBefore = new LinkedList<>();
        final List<Document> expectPrintedDocumentsAfter = new LinkedList<>();
        expectPrintedDocumentsAfter.add(doc1);
        expectPrintedDocumentsAfter.add(doc2);
        expectPrintedDocumentsAfter.add(doc3);
        expectPrintedDocumentsAfter.add(doc4);
        final Collection<Document> expectNotPrintedDocuments = new LinkedList<>();

        // asserts
        Assert.assertArrayEquals(resultEmptyPrintedDocuments.toArray(), expectPrintedDocumentsBefore.toArray());
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocumentsAfter.toArray());
        Assert.assertArrayEquals(resultNotPrintedDocuments.toArray(), expectNotPrintedDocuments.toArray());
    }


    @Test
    public void whenPrintStop() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.PRINTING.index());
        final Collection<Document> resultNotPrintedDocuments = dispatcher.stop();

        // expect
        final List<Document> expectPrintedDocuments = new LinkedList<>();
        expectPrintedDocuments.add(doc1);
        expectPrintedDocuments.add(doc2);
        expectPrintedDocuments.add(doc3);
        final Collection<Document> expectNotPrintedDocuments = new LinkedList<>();
        expectNotPrintedDocuments.add(doc4);

        // asserts
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocuments.toArray());
        Assert.assertArrayEquals(resultNotPrintedDocuments.toArray(), expectNotPrintedDocuments.toArray());
    }


    @Test
    public void whenPrintAbort() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // result
        final boolean abort = dispatcher.abort(this.doc3);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.PRINTING.index());
        final Collection<Document> resultNotPrintedDocuments = dispatcher.stop();

        // expect
        final List<Document> expectPrintedDocuments = new LinkedList<>();
        expectPrintedDocuments.add(doc1);
        expectPrintedDocuments.add(doc2);
        expectPrintedDocuments.add(doc4);
        final Collection<Document> expectNotPrintedDocuments = new LinkedList<>();

        // asserts
        Assert.assertTrue(abort);
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocuments.toArray());
        Assert.assertArrayEquals(resultNotPrintedDocuments.toArray(), expectNotPrintedDocuments.toArray());
    }


    @Test
    public void whenSortByTypeDoc() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.TYPE_OF_DOCUMENT.index());

        // expect
        final List<Document> expectPrintedDocumentsAfter = new LinkedList<>();
        expectPrintedDocumentsAfter.add(doc1);
        expectPrintedDocumentsAfter.add(doc2);
        expectPrintedDocumentsAfter.add(doc3);
        expectPrintedDocumentsAfter.add(doc4);

        // asserts
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocumentsAfter.toArray());
    }


    @Test
    public void whenSortByTimeOfPrinting() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.TIME_OF_PRINTING.index());

        // expect
        final List<Document> expectPrintedDocumentsAfter = new LinkedList<>();
        expectPrintedDocumentsAfter.add(doc2);
        expectPrintedDocumentsAfter.add(doc1);
        expectPrintedDocumentsAfter.add(doc3);
        expectPrintedDocumentsAfter.add(doc4);

        // asserts
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocumentsAfter.toArray());
    }


    @Test
    public void whenSortByPaperSize() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final Collection<Document> resultPrintedDocuments = dispatcher.getPrintedDocuments(Dispatcher.OrderBy.PAPER_SIZE.index());

        // expect
        final List<Document> expectPrintedDocumentsAfter = new LinkedList<>();
        expectPrintedDocumentsAfter.add(this.doc2);
        expectPrintedDocumentsAfter.add(this.doc1);
        expectPrintedDocumentsAfter.add(this.doc3);
        expectPrintedDocumentsAfter.add(this.doc4);

        // asserts
        Assert.assertArrayEquals(resultPrintedDocuments.toArray(), expectPrintedDocumentsAfter.toArray());
    }


    @Test
    public void getAveragePrintTime() throws Exception {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.accept(this.doc1);
        dispatcher.accept(this.doc2);
        dispatcher.accept(this.doc3);
        dispatcher.accept(this.doc4);

        // printed...
        Thread.sleep(this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime() + this.runningTime);

        // results
        final long result = dispatcher.getAveragePrintTime();

        // expect
        final long expect = (this.doc1.getPrintingTime() + this.doc2.getPrintingTime() + this.doc3.getPrintingTime() + this.doc4.getPrintingTime()) / 4;

        // asserts
        Assert.assertEquals(result, expect);
    }
}
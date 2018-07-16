package ru.cbr.ekb.prilepskiy.model.entity;

import java.util.Comparator;

/**
 * Created by VLADIMIR on 12.07.2018.
 *
 * Document.
 */
public class Document {

    /**
     * Продолжительность печати.
     */
    private final long printingTime;

    /**
     * Наименование типа документа.
     */
    private final String typeName;

    /**
     * Pазмер бумаги.
     */
    private final PaperSize paperSize;


    /**
     * Конструктор.
     * @param printingTime - Продолжительность печати.
     * @param typeName - Наименование типа документа.
     * @param paperSize - Pазмер бумаги.
     */
    public Document(long printingTime, String typeName, PaperSize paperSize) {
        if (printingTime < 0) {
            throw new IllegalArgumentException("printingTime < 0");
        }

        this.printingTime = printingTime;
        this.typeName = typeName;
        this.paperSize = paperSize;
    }


    /**
     * Getter.
     * @return - Продолжительность печати.
     */
    public long getPrintingTime() {
        return printingTime;
    }

    /**
     * Getter.
     * @return - Наименование типа документа.
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Getter.
     * @return - Pазмер бумаги.
     */
    public PaperSize getPaperSize() {
        return paperSize;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (printingTime != document.printingTime) return false;
        if (typeName != null ? !typeName.equals(document.typeName) : document.typeName != null) return false;
        return paperSize != null ? paperSize.equals(document.paperSize) : document.paperSize == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (printingTime ^ (printingTime >>> 32));
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (paperSize != null ? paperSize.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Document{" +
                "printingTime=" + printingTime +
                ", typeName='" + typeName + '\'' +
                ", paperSize=" + paperSize +
                '}';
    }
}



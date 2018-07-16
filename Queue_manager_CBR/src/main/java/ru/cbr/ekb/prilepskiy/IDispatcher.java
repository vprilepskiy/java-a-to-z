package ru.cbr.ekb.prilepskiy;

import ru.cbr.ekb.prilepskiy.model.entity.Document;

import java.util.Collection;

/**
 * Created by VLADIMIR on 12.07.2018.
 */
public interface IDispatcher {

    /**
     * Остановка диспетчера.
     * Печать документов в очереди отменяется.
     * На выходе должен быть список ненапечатанных документов.
     */
    Collection<Document> stop();

    /**
     * Принять документ на печать.
     * Метод не должен блокировать выполнение программы.
     */
    void accept(Document document);

    /**
     * Отменить печать принятого документа, если он еще не был напечатан.
     * @return - true, если отменен.
     */
    boolean abort(Document document);

    /**
     * Получить отсортированный список напечатанных документов.
     * Список может быть отсортирован на выбор:
     * - по порядку печати
     * - по типу документов
     * - по продолжительности печати
     * - по размеру бумаги.
     */
    Collection<Document> getPrintedDocuments(int sortingType);

    /**
     * Рассчитать среднюю продолжительность печати напечатанных.
     */
    long getAveragePrintTime();
}

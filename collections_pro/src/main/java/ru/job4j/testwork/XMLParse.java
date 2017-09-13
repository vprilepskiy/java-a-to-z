package ru.job4j.testwork;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VLADIMIR on 30.08.2017.
 */
public class XMLParse {

    /**
     * Constructor.
     *
     * @param file - Xml file.
     */
    public XMLParse(File file) {
        this.file = file;
    }

    /**
     * Xml file.
     */
    private final File file;


    /**
     * To parse xml.
     * Добавит/удалит ордеры в коллекцию.
     *
     * @return - orders.
     */
    public Collection<Order> read() {

        final Map<Integer, Order> orders = new HashMap();

        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLEventReader reader = null;
        try {
            // инициализируем reader и скармливаем ему xml файл
            reader = factory.createXMLEventReader(new FileInputStream(this.file));

            // проходим по всем элементам xml файла
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    this.startElement = xmlEvent.asStartElement();

                    String localPart = this.startElement.getName().getLocalPart();

                    // обработать AddOrder и DeleteOrder
                    if (localPart.equals("AddOrder")) {

                        // получаем Id и Order.
                        Integer orderId = Integer.parseInt(this.getValue("orderId"));
                        Order order = this.getOrder();

                        // добавляем
                        orders.put(orderId, order);

                    } else if (localPart.equals("DeleteOrder")) {

                        // получаем Id.
                        Integer orderId = Integer.parseInt(this.getValue("orderId"));

                        // удаляем
                        orders.remove(orderId);

                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return orders.values();
    }


    /**
     * StartElement.
     */
    private StartElement startElement;


    /**
     * Get value of attribute by name.
     *
     * @param localPart - name of attribute.
     * @return - value of attribute.
     */
    private String getValue(String localPart) {

        String value = null;

        // получаем атрибут для элемента
        Attribute attribute = this.startElement.getAttributeByName(new QName(localPart));

        if (attribute != null) {
            value = attribute.getValue();
        }
        return value;
    }


    /**
     * Get order.
     *
     * @return - order when operation: BUY then Volume: minus and when operation: SELL then Volume: plus.
     */
    private Order getOrder() {

        final String name = this.getValue("book");
        final String operation = this.getValue("operation");
        final double price = Double.parseDouble(this.getValue("price"));
        final int volume = Integer.parseInt(this.getValue("volume"));
        Persons persons = null;

        if (new Persons.Ask().getAttribute().equals(operation)) {
            persons = new Persons.Ask();
        } else if (new Persons.Bid().getAttribute().equals(operation)) {
            persons = new Persons.Bid();
        }

        int sign = persons.getSign();

        return new Order(new Book(name, price), sign * volume);
    }

}

package jdbc.xml;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;


/**
 * Created by VLADIMIR on 05.10.2017.
 */
public class XMLMagic {

    /**
     * Write XML file to HDD.
     * @param in - Entries.
     * @param out - XML file for save.
     */
    public void objectsToXMLFile(Entries in, File out) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(in, out);
//            jaxbMarshaller.marshal(in, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Transform xml file using XSLT.
     * @param inFile - XML file.
     * @param xsltFile - XSLT file.
     * @param outFile - XML file.
     */
    public void transformXSL(File inFile, File xsltFile, File outFile) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(xsltFile);
            Transformer transformer = factory.newTransformer(xslt);
            Source in = new StreamSource(inFile);
            transformer.transform(in, new StreamResult(outFile));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    /**
     * Receive a response to the query in xml with XPath.
     * @param xmlFile - XML file.
     * @param expression - XPath expression.
     * @return - value.
     */
    public String requestXPath(File xmlFile, String expression) {

        String result = "";

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            result = xPath.evaluate(expression, document);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return result;
    }
}

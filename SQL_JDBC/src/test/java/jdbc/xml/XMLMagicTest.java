package jdbc.xml;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.List;


/**
 * Created by VLADIMIR on 05.10.2017.
 */
public class XMLMagicTest {

    /**
     * Test.
     */
    @Test
    public void objectsToXMLFile() {

        // result
        final File file = new File("testXMLOut.xml");

        // data
        final Entry e0 = new Entry("Vladimir");
        final Entry e1 = new Entry("Andrey");

        final List list = Arrays.asList(e0, e1);
        final Entries entries = new Entries();
        entries.setList(list);

        final XMLMagic xmlMagic = new XMLMagic();
        xmlMagic.objectsToXMLFile(entries, file);

        // expect
        final StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        expect.append("<entries>");
        expect.append("    <entry>");
        expect.append("        <field>Vladimir</field>");
        expect.append("    </entry>");
        expect.append("    <entry>");
        expect.append("        <field>Andrey</field>");
        expect.append("    </entry>");
        expect.append("</entries>");

        // assert
        final String result = this.readFile(file);

        Assert.assertThat(expect.toString(), Is.is(result));

        file.delete();
    }


    /**
     * Test.
     */
    @Test
    public void transformXSL() {

        // data
        final File inFile = new File("in.xml");
        final File xsltFile = new File("Transform.xsl");

        final StringBuilder sbIn = new StringBuilder();
        sbIn.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sbIn.append("<entries>");
        sbIn.append("    <entry>");
        sbIn.append("        <field>Vladimir</field>");
        sbIn.append("    </entry>");
        sbIn.append("    <entry>");
        sbIn.append("        <field>Andrey</field>");
        sbIn.append("    </entry>");
        sbIn.append("</entries>");
        this.writeFile(inFile, sbIn.toString());

        final StringBuilder sbTrasform = new StringBuilder();
        sbTrasform.append("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
        sbTrasform.append("    <xsl:template match=\"/entries\">");
        sbTrasform.append("        <entries>");
        sbTrasform.append("            <xsl:apply-templates/>");
        sbTrasform.append("        </entries>");
        sbTrasform.append("    </xsl:template>");
        sbTrasform.append("    <xsl:template match=\"/entries/entry\">");
        sbTrasform.append("        <entry field = \"{field}\"/>");
        sbTrasform.append("    </xsl:template>");
        sbTrasform.append("</xsl:stylesheet>");
        this.writeFile(xsltFile, sbTrasform.toString());

        // result
        final File outFile = new File("out.xml");
        new XMLMagic().transformXSL(inFile, xsltFile, outFile);
        String result = this.readFile(outFile);

        // expect
        final StringBuilder sbOut = new StringBuilder();
        sbOut.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries>");
        sbOut.append("    <entry field=\"Vladimir\"/>");
        sbOut.append("    <entry field=\"Andrey\"/>");
        sbOut.append("</entries>");

        // assert
        Assert.assertThat(sbOut.toString(), Is.is(result));

        inFile.delete();
        xsltFile.delete();
        outFile.delete();
    }


    /**
     * Test.
     */
    @Test
    public void requestXPath() {
        // data
        final StringBuilder textXML = new StringBuilder();
        textXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries>");
        textXML.append("    <entry>testValue</entry>");
        textXML.append("</entries>");

        final File file = new File("test.xml");
        this.writeFile(file, textXML.toString());
        final String expression = "/entries/entry";

        // result
        final String result = new XMLMagic().requestXPath(file, expression);

        // expect
        final String expect = "testValue";

        // assert
        Assert.assertThat(result, Is.is(expect));

        file.delete();
    }


    /**
     * Read file.
     * @param file - file.
     * @return - text.
     */
    private String readFile(File file) {
        StringBuilder result = new StringBuilder();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }


    /**
     * Write file.
     * @param file - file.
     * @param text - text.
     */
    private void writeFile(File file, String text) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
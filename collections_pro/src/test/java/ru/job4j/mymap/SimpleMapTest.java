package ru.job4j.mymap;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 13.07.2017.
 */
public class SimpleMapTest {

    /**
     * ATest Insert and Get.
     */
    @Test
    public void whenInsertKeyValueThenGetValuesByKeys() {
        SimpleMap simpleMap = new SimpleMap();

        simpleMap.insert("key1", "val1");
        simpleMap.insert("key2", "val2");
        simpleMap.insert("key3", "val3");

        Assert.assertThat("val1", Is.is(simpleMap.get("key1")));
        Assert.assertThat("val2", Is.is(simpleMap.get("key2")));
        Assert.assertThat("val3", Is.is(simpleMap.get("key3")));


    }

    /**
     * ATest expand array.
     */
    @Test
    public void whenExpandSize() {
        SimpleMap simpleMap = new SimpleMap(1);

        simpleMap.insert("key1", "val1");
        simpleMap.insert("key2", "val2");
        simpleMap.insert("key3", "val3");

        Assert.assertThat("val1", Is.is(simpleMap.get("key1")));
        Assert.assertThat("val2", Is.is(simpleMap.get("key2")));
        Assert.assertThat("val3", Is.is(simpleMap.get("key3")));
    }

    /**
     * ATest Iterator.
     */
    @Test
    public void whenInsertKeyValueThenGetValuesByIterator() {
        SimpleMap simpleMap = new SimpleMap();

        simpleMap.insert("key1", "val1");
        simpleMap.insert("key2", "val2");
        simpleMap.insert("key3", "val3");

        Iterator iterator = simpleMap.iterator();

        Assert.assertThat(true, Is.is(iterator.hasNext()));
        Assert.assertThat("val1", Is.is(iterator.next()));
        Assert.assertThat("val2", Is.is(iterator.next()));
        Assert.assertThat("val3", Is.is(iterator.next()));
        Assert.assertThat(false, Is.is(iterator.hasNext()));
    }

    /**
     * ATest replaces value.
     */
    @Test
    public void whenInsertKeyValueThenReplacesValues() {
        SimpleMap simpleMap = new SimpleMap();

        simpleMap.insert("key1", "val1");
        simpleMap.insert("key2", "val2");
        simpleMap.insert("key3", "val3");
        simpleMap.insert("key3", "valReplaces");

        Iterator iterator = simpleMap.iterator();

        Assert.assertThat("val1", Is.is(iterator.next()));
        Assert.assertThat("val2", Is.is(iterator.next()));
        Assert.assertThat("valReplaces", Is.is(iterator.next()));
    }

    /**
     * ATest delete.
     */
    @Test
    public void whenInsertKeyValueAndDelNodeThenNullValues() {
        SimpleMap simpleMap = new SimpleMap();

        simpleMap.insert("key1", "val1");
        simpleMap.insert("key2", "val2");
        simpleMap.insert("key3", "val3");
        simpleMap.delete("key2");

        Assert.assertNull(simpleMap.get("key2"));
    }
}
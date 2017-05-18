package ru.job4j.multisorting;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by VLADIMIR on 16.05.2017.
 */
public class SorterTest {

    /**
     * Входящие аргументы.
     */
    private final String[] lines = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};

    /**
     * Тестируемый класс.
     */
    private final Sorter sorter = new Sorter(this.lines);

    /**
     * Вывод результатов в консоль.
     */
//    @Test
    public void forPrintToConsole() {
        this.printList(this.sorter.getCollection());

        this.sorter.addParentDept();
        this.printList(this.sorter.getCollection());

        this.sorter.sort(false);
        this.printList(this.sorter.getCollection());

        this.sorter.sort(true);
        this.printList(this.sorter.getCollection());
    }

    /**
     * Print.
     *
     * @param lists - list.
     */
    private void printList(Set<List<String>> lists) {
        for (List<String> list : lists) {
            for (String line : list) {
                System.out.print(line + "; ");
            }
            System.out.println();
        }
        System.out.println("***********************");
    }

    /**
     * Test.
     */
    @Test
    public void whenConvertArrayToCollection() {
        Set<List<String>> lists = this.sorter.getCollection();
        Set<List<String>> result = new HashSet<>();
        result.add(Arrays.asList("K1", "SK1"));
        result.add(Arrays.asList("K1", "SK2"));
        result.add(Arrays.asList("K1", "SK1", "SSK1"));
        result.add(Arrays.asList("K1", "SK1", "SSK2"));
        result.add(Arrays.asList("K2"));
        result.add(Arrays.asList("K2", "SK1", "SSK1"));
        result.add(Arrays.asList("K2", "SK1", "SSK2"));

        Assert.assertThat(lists, Is.is(result));
    }

    /**
     * Test AddParentDept.
     */
    @Test
    public void whenAddParentDeptInArray() {

        this.sorter.addParentDept();

        Set<List<String>> result = new HashSet<>();
        result.add(Arrays.asList("K1", "SK1"));
        result.add(Arrays.asList("K1", "SK2"));
        result.add(Arrays.asList("K1", "SK1", "SSK1"));
        result.add(Arrays.asList("K1", "SK1", "SSK2"));
        result.add(Arrays.asList("K2"));
        result.add(Arrays.asList("K2", "SK1", "SSK1"));
        result.add(Arrays.asList("K2", "SK1", "SSK2"));

        result.add(Arrays.asList("K2", "SK1"));
        result.add(Arrays.asList("K1"));

        Assert.assertThat(this.sorter.getCollection(), Is.is(result));
    }

    /**
     * Test sortCollection.
     */
    @Test
    public void whenSortCollection() {
        this.sorter.addParentDept();
        this.sorter.sort(false);
        String[] array = this.sorter.getArray();

        String[] result = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};

        Assert.assertThat(result, Is.is(array));
    }

    /**
     * Test ReverseSortCollection.
     */
    @Test
    public void whenReverseSortCollection() {
        this.sorter.addParentDept();
        this.sorter.sort(true);
        String[] array = this.sorter.getArray();

        String[] result = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};

        Assert.assertThat(result, Is.is(array));
    }

}

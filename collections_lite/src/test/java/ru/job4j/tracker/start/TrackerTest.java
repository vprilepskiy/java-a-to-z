package ru.job4j.tracker.start;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Vladimir Prilepskiy
 * @since 14.12.2016
 * @version 1
 */
 public class TrackerTest {
	/**
	 * Tracker.
	 */
	private Tracker tracker = new Tracker();
	/**
	 * Item.
	 */
	private Item item = new Item();
	/**
	 * Кол-во записей.
	 */
	private final int countRows = 5;
	/**
	 * Название.
	 */
	private String[] name = new String[countRows];
	/**
	 * Описание.
	 */
	private String[] description = new String[countRows];
	/**
	 * Дата создания.
	 */
	private long[] create = new long[countRows];
	/**
	 * Уникальный ключ.
	 */
	private String[] id = new String[countRows];

	/**
	 * Предварительная настройка.
	 */
	@Before
	public void testAdd() {
		for (int i = 0; i < countRows; i++) {
			item = tracker.add(new Item(i + " name", i + " desc", System.currentTimeMillis()));
			name[i] = item.getName();
			description[i] = item.getDescription();
			create[i] = item.getCreate();
			id[i] = item.getId();
			final String result = i + " name";
//			assertThat(item.getName(), is(result));
		}
	}

	/**
	 * Test.
	 */
	@Test
	public void testUpdate() {
		final String name = "editing name";
		final String desc = "editing desc";
		final long create = System.currentTimeMillis();
		Item newItem = new Item(name, desc, create);
		final int index = 3;
		newItem.setId(id[index]);
		tracker.update(newItem);
		assertThat(newItem.getName(), is(name));
	}

	/**
	 * Test.
	 */
	@Test
	public void testDel() {
		assertThat(tracker.del(item), is(true));
	}

	/**
	 * Test.
	 */
	@Test
	public void testFindById() {
		assertThat(tracker.findById(this.id[0]).getName(), is("0 name"));
	}

	/**
	 * Test.
	 */
	@Test
	public void testFindByName() {
		final ArrayList<Item> result = tracker.findByName(this.name[1]);
		assertThat(result.get(0).getName(), is("1 name"));
	}

	/**
	 * Test.
	 */
	@Test
	public void testFindByDescription() {
		final ArrayList<Item>  result = tracker.findByDescription(this.description[1]);
		assertThat(result.get(0).getDescription(), is("1 desc"));
	}

	/**
	 * Test.
	 */
	@Test
	public void testFindByCreate() {
		final ArrayList<Item>  result = tracker.findByCreate(this.create[1]);
		assertThat(result.get(0).getCreate(), is(this.create[1]));
	}

	/**
	 * Test.
	 */
	@Test
	public void testGetAll() {
		ArrayList<Item> items = tracker.getAll();
		boolean success = true;
		int index = 0;
		for (Item item : items) {
			if (item.getId() != id[index]) {
				success = false;
				break;
			}
			index++;
		}
		assertThat(success, is(true));
	}
}
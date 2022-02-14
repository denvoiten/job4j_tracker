package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;

public class TrackerTest {

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenTestItemSortByNameAscending() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Oliver"));
        items.add(new Item("Jack"));
        items.add(new Item("Harry"));
        items.add(new Item("Jacob"));
        items.add(new Item("Charley"));
        items.add(new Item("Oscar"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Charley"));
        expected.add(new Item("Harry"));
        expected.add(new Item("Jack"));
        expected.add(new Item("Jacob"));
        expected.add(new Item("Oliver"));
        expected.add(new Item("Oscar"));
        assertEquals(items, expected);
    }

    @Test
    public void whenTestItemSortByNameDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Oliver"));
        items.add(new Item("Jack"));
        items.add(new Item("Harry"));
        items.add(new Item("Jacob"));
        items.add(new Item("Charley"));
        items.add(new Item("Oscar"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Oscar"));
        expected.add(new Item("Oliver"));
        expected.add(new Item("Jacob"));
        expected.add(new Item("Jack"));
        expected.add(new Item("Harry"));
        expected.add(new Item("Charley"));
        assertEquals(items, expected);
    }
}
package ru.job4j.tracker;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class HbmTrackerTest {
    private final HbmTracker hbmTracker = new HbmTracker();
    private final Item first = new Item("First", "bla bla bla", Timestamp.valueOf(LocalDateTime.now()));
    private final Item second = new Item("Second", "bla bla bla", Timestamp.valueOf(LocalDateTime.now()));

    @Test
    public void whenAdd() {
        hbmTracker.add(first);
        assertEquals(first, hbmTracker.findById(1));
    }

    @Test
    public void whenReplace() {
        hbmTracker.add(first);
        assertThat(hbmTracker.findById(1).getName(), is("First"));
        hbmTracker.replace(1, second);
        assertThat(hbmTracker.findById(1).getName(), is("Second"));
    }

    @Test
    public void whenDelete() {
        hbmTracker.add(first);
        hbmTracker.add(second);
        hbmTracker.delete(1);
        assertEquals(List.of(second), hbmTracker.findAll());
    }

    @Test
    public void whenFindAll() {
        hbmTracker.add(first);
        hbmTracker.add(second);
        assertEquals(List.of(first, second), hbmTracker.findAll());
    }

    @Test
    public void whenFindByName() {
        hbmTracker.add(first);
        hbmTracker.add(second);
        assertEquals(List.of(second), hbmTracker.findByName("Second"));
    }

    @Test
    public void whenFindById() {
        hbmTracker.add(first);
        hbmTracker.add(second);
        assertEquals(second, hbmTracker.findById(2));
    }
}
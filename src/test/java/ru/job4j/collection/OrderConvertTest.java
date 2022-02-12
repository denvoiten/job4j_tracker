package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5xah", "Shirt"));
        orders.add(new Order("7nnf", "Jacket"));
        orders.add(new Order("7nnf", "JacketXL"));
        orders.add(new Order("3sfe", "DressXS"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "DressXS")));
        assertThat(map.get("5xah"), is(new Order("5xah", "Shirt")));
        assertThat(map.get("7nnf"), is(new Order("7nnf", "JacketXL")));
    }
}
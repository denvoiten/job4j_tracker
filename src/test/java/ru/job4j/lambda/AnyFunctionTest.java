package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnyFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        AnyFunction function = new AnyFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        AnyFunction function = new AnyFunction();
        List<Double> result = function.diapason(1, 5, x -> 1 * Math.pow(x, 2) + 2 * x + 3);
        List<Double> expected = Arrays.asList(6D, 11D, 18D, 27D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        AnyFunction function = new AnyFunction();
        List<Double> result = function.diapason(2, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D);
        assertThat(result, is(expected));
    }

}
package test.java;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Search;

public class SearchTests {

    private Search search = new Search();

    @Test
    public void linearSearchTest1() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, search.linearSearch(arr, 3));
    }

    @Test
    public void linearSearchTest2() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, search.linearSearch(arr, 6));
    }

    @Test
    public void binarySeachTest1() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, search.binarySearch(arr, 3));
    }

    @Test
    public void binarySeachTest2() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, search.binarySearch(arr, 6));
    }

    @Test
    public void binarySeachTest3() {
        int[] arr = {5, 1, 3, 2, 4};
        assertEquals(2, search.binarySearch(arr, 3));
        assertEquals(-1, search.binarySearch(arr, 6));
    }
}
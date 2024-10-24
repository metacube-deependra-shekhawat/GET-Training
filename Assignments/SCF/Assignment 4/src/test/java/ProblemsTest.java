package test.java;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.java.Problems;

public class ProblemsTest{
    Problems prob = new Problems();
    @Test
    public void fixXY_Test1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int x = 2;
        int y = 3;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, prob.fixXY(arr, x, y));
    }

    @Test
    public void fixXY_Test2() {
        int[] arr = {1, 2, 3, 2, 3, 4};
        int x = 2;
        int y = 3;
        int[] expected = {1, 2, 3, 2, 3, 4}; // Already valid
        assertArrayEquals(expected, prob.fixXY(arr, x, y));
    }

    @Test
    public void fixXY_Test3() {
        int[] arr = {1, 2, 3, 2, 3, 2, 3};
        int x = 2;
        int y = 3;
        int[] expected = {1, 2, 3, 2, 3, 2, 3}; // Already valid
        assertArrayEquals(expected, prob.fixXY(arr, x, y));
    }

    @Test
    public void fixXY_Test4() {
        int[] arr = {1, 2, 3, 2, 3, 2};
        int x = 2;
        int y = 3;
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            prob.fixXY(arr, x, y);
        });
        assertEquals("x cannot be at the end.", exception.getMessage());
    }

    @Test
    public void fixXY_Test5() {
        int[] arr = {1, 2, 2, 3, 4};
        int x = 2;
        int y = 3;
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            prob.fixXY(arr, x, y);
        });
        assertEquals("Two consecutive x's are not allowed.", exception.getMessage());
    }

    @Test
    public void fixXY_Test6() {
        int[] arr = {1, 2, 3, 2, 4};
        int x = 2;
        int y = 3;
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            prob.fixXY(arr, x, y);
        });
        assertEquals("The number of x's and y's must be equal", exception.getMessage());
    }

    @Test
    public void fixXY_Test7() {
        int[] arr = {};
        int x = 2;
        int y = 3;
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            prob.fixXY(arr, x, y);
        });
        assertEquals("No elements present in the array", exception.getMessage());
    }

    @Test
    public void fixXY_Test8() {
        int[] arr = {1, 4, 5, 6};
        int x = 2;
        int y = 3;
        int[] expected = {1, 4, 5, 6}; // No change
        assertArrayEquals(expected, prob.fixXY(arr, x, y));
    }

    @Test
    public void findClums_Test1() {
        int[] arr = {};
        AssertionError exception = assertThrows(AssertionError.class, () -> {
            prob.findClums(arr);
        });
        assertEquals("Array is empty", exception.getMessage());
    }

    @Test
    public void findClums_Test2() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 0;
        assertEquals(expected, prob.findClums(arr));
    }

    @Test
    public void findClums_Test3() {
        int[] arr = {1, 1, 2, 3, 4};
        int expected = 1;
        assertEquals(expected, prob.findClums(arr));
    }

    @Test
    public void findClums_Test4() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int expected = 3;
        assertEquals(expected, prob.findClums(arr));
    }

    @Test
    public void findClums_Test5() {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3};
        int expected = 3;
        assertEquals(expected, prob.findClums(arr));
    }

    @Test
    public void findClums_Test6() {
        int[] arr = {1, 1, 1, 1, 1};
        int expected = 1; // Only one group of duplicates
        assertEquals(expected, prob.findClums(arr));
    }

    @Test
    public void findClums_Test7() {
        int[] arr = {1};
        int expected = 0; // No clumps
        assertEquals(expected, prob.findClums(arr));
    }

    static Stream<Arguments> splitArrayProvider() {
        return Stream.of(
            Arguments.of(new int[]{}, "Zero elements present in the array", true),
            Arguments.of(new int[]{5}, -1, false),
            Arguments.of(new int[]{1, 1}, 1, false),
            Arguments.of(new int[]{1, 2}, -1, false),
            Arguments.of(new int[]{1, 2, 3, 4}, -1, false),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, false),
            Arguments.of(new int[]{1, 2, 3, 4, 6}, -1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("splitArrayProvider")
    public void testSplitArray(int[] arr, Object expected, boolean isException) {
        if (isException) {
            AssertionError exception = assertThrows(AssertionError.class, () -> {
                prob.splitArray(arr);
            });
            assertEquals(expected, exception.getMessage());
        } else {
            assertEquals(expected, prob.splitArray(arr));
        }
    }

    static Stream<Arguments> longestMirrorProvider() {
        return Stream.of(
            Arguments.of(new int[]{}, "Zero elements present in the array", true),
            Arguments.of(new int[]{1}, 1, false),
            Arguments.of(new int[]{1, 1}, 2, false),
            Arguments.of(new int[]{1, 2}, 1, false),
            Arguments.of(new int[]{1, 2, 3, 2, 1}, 5, false),
            Arguments.of(new int[]{1, 2, 3, 4, 3, 2, 1}, 7, false),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, false),
            Arguments.of(new int[]{1, 2, 3, 2, 1, 4, 5, 4, 3, 2, 1}, 5, false),
            Arguments.of(new int[]{-1, -2, -3, -2, -1}, 5, false),
            Arguments.of(new int[]{1, 2, 3, 4, 2, 1}, 2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("longestMirrorProvider")
    public void testLongestMirror(int[] arr, Object expected, boolean isException) {
        if (isException) {
            AssertionError exception = assertThrows(AssertionError.class, () -> {
                prob.longestMirror(arr);
            });
            assertEquals(expected, exception.getMessage());
        } else {
            assertEquals(expected, prob.longestMirror(arr));
        }
    }
}

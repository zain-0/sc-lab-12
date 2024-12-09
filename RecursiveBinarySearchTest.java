import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursiveBinarySearchTest {

    @Test
    public void testBinarySearchRecursiveInt() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};

        // Test when the target is found
        assertEquals(3, RecursiveBinarySearch.binarySearchRecursive(arr, 7));  // Target found
        
        // Test when the target is not found
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(arr, 4)); // Target not found
    }

    @Test
    public void testBinarySearchRecursiveString() {
        String[] arr = {"apple", "banana", "cherry", "date", "fig"};

        // Test when the target is found
        assertEquals(2, RecursiveBinarySearch.binarySearchRecursive(arr, "cherry"));  // Target found
        
        // Test when the target is not found
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(arr, "grape"));  // Target not found
    }

    @Test
    public void testFindAllIndices() {
        int[] arr = {1, 2, 3, 3, 3, 5, 6};

        // Test to find all indices where the target appears
        int[] indices = RecursiveBinarySearch.findAllIndices(arr, 3);
        assertArrayEquals(new int[]{2, 3, 4}, indices);  // All indices of the target value 3
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] arr = {};

        // Test that the method throws an exception for an empty array
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveBinarySearch.binarySearchRecursive(arr, 5);
        });
    }

    @Test
    public void testBinarySearchNullArray() {
        // Test that the method throws an exception for a null array
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveBinarySearch.binarySearchRecursive(null, 5);
        });
    }
}

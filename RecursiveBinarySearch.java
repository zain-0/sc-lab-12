import java.util.Arrays;

public class RecursiveBinarySearch {

    /**
     * This method implements recursive binary search to find the index of a target value in a sorted array of integers.
     * 
     * @param arr The sorted array of integers to search in.
     * @param target The target integer value to search for.
     * @return The index of the target value if found; -1 if not found.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        return binarySearchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method that performs the actual recursive binary search.
     * 
     * @param arr The sorted array of integers.
     * @param target The target integer value to search for.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return The index of the target value if found; -1 if not found.
     */
    private static int binarySearchRecursiveHelper(int[] arr, int target, int left, int right) {
        // Base case: If the search range is invalid
        if (left > right) {
            return -1;  // Target not found
        }

        // Find the middle element
        int mid = left + (right - left) / 2;

        // Base case: Target found
        if (arr[mid] == target) {
            return mid;
        }

        // Recursive case: Search the left or right half
        if (arr[mid] > target) {
            return binarySearchRecursiveHelper(arr, target, left, mid - 1);  // Search in the left half
        } else {
            return binarySearchRecursiveHelper(arr, target, mid + 1, right); // Search in the right half
        }
    }

    /**
     * This method implements recursive binary search to find the index of a target value in a sorted array of strings.
     * 
     * @param arr The sorted array of strings to search in.
     * @param target The target string value to search for.
     * @return The index of the target value if found; -1 if not found.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public static int binarySearchRecursive(String[] arr, String target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        return binarySearchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method that performs the actual recursive binary search for a sorted array of strings.
     * 
     * @param arr The sorted array of strings.
     * @param target The target string value to search for.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return The index of the target value if found; -1 if not found.
     */
    private static int binarySearchRecursiveHelper(String[] arr, String target, int left, int right) {
        // Base case: If the search range is invalid
        if (left > right) {
            return -1;  // Target not found
        }

        // Find the middle element
        int mid = left + (right - left) / 2;

        // Base case: Target found
        if (arr[mid].equals(target)) {
            return mid;
        }

        // Recursive case: Search the left or right half
        if (arr[mid].compareTo(target) > 0) {
            return binarySearchRecursiveHelper(arr, target, left, mid - 1);  // Search in the left half
        } else {
            return binarySearchRecursiveHelper(arr, target, mid + 1, right); // Search in the right half
        }
    }

    /**
     * This method returns an array of indices where the target value appears in the given sorted array.
     * 
     * @param arr The sorted array of integers.
     * @param target The target integer value to search for.
     * @return An array of indices where the target appears in the array.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public static int[] findAllIndices(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        return findAllIndicesHelper(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method that finds all occurrences of the target value in the sorted array.
     * 
     * @param arr The sorted array of integers.
     * @param target The target integer value to search for.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return An array of indices where the target appears in the array.
     */
    private static int[] findAllIndicesHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return new int[0];  // No occurrences
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            // Find all indices in the left and right halves
            int[] leftIndices = findAllIndicesHelper(arr, target, left, mid - 1);
            int[] rightIndices = findAllIndicesHelper(arr, target, mid + 1, right);
            
            // Combine results
            int[] result = new int[leftIndices.length + rightIndices.length + 1];
            System.arraycopy(leftIndices, 0, result, 0, leftIndices.length);
            result[leftIndices.length] = mid;
            System.arraycopy(rightIndices, 0, result, leftIndices.length + 1, rightIndices.length);
            return result;
        } else if (arr[mid] > target) {
            return findAllIndicesHelper(arr, target, left, mid - 1);  // Search in left half
        } else {
            return findAllIndicesHelper(arr, target, mid + 1, right); // Search in right half
        }
    }

    public static void main(String[] args) {
        // Example usage of the recursive binary search
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println(binarySearchRecursive(arr, 7));  // Output: 3
        System.out.println(binarySearchRecursive(arr, 4));  // Output: -1

        String[] strArr = {"apple", "banana", "cherry", "date", "fig"};
        System.out.println(binarySearchRecursive(strArr, "cherry"));  // Output: 2
        System.out.println(binarySearchRecursive(strArr, "grape"));   // Output: -1

        int[] arrWithDuplicates = {1, 2, 3, 3, 3, 5, 6};
        int[] indices = findAllIndices(arrWithDuplicates, 3);  // Output: [2, 3, 4]
        System.out.println(Arrays.toString(indices));
    }
}

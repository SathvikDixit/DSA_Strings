public class Sathvik {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;

        // Define the left and right pointers for binary search
        int left = 0, right = m * n - 1;

        // Perform binary search on the 2D matrix
        while (left <= right) {
            // Find the mid index in the 1D flattened matrix
            int mid = left + (right - left) / 2;

            // Convert the mid index to 2D matrix indices
            int midValue = matrix[mid / n][mid % n];

            // If the target is found, return true
            if (midValue == target) {
                return true;
            }
            // If the mid value is smaller than the target, move the left pointer
            else if (midValue < target) {
                left = mid + 1;
            }
            // If the mid value is larger than the target, move the right pointer
            else {
                right = mid - 1;
            }
        }

        // Return false if the target is not found
        return false;
    }

      // Main method for testing the searchMatrix function
      public static void main(String[] args) {
        Sathvik solution = new Sathvik();

        // Example test case
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); //output: true

        target = 13;
        result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); //output: false
    }
}

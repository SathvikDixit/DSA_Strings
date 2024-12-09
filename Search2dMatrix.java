






                        // THIS IS ARRAY PROBLEM






public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // Defining the left and right pointers for binary search
        int left = 0, right = m * n - 1;

        //binary search on the 2D matrix
        while (left <= right) {
            int mid = (left + right) / 2;    // we can write this as left + (right - left) / 2; 

            // Convert the mid index to 2D matrix indices
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            }
            else if (midValue < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }               

      // Main method for testing the searchMatrix function
      public static void main(String[] args) {
        Search2dMatrix solution = new Search2dMatrix();

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
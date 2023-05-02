package matrixOperations;

public class MatrixChallenge {
    public static int MatrixChallenge(String[] strArr) {
        int n = strArr.length; // get number of rows in the matrix   n=4
        int m = strArr[0].length(); // get number of columns in the matrix   m=5
        int[][] dp = new int[n][m]; // create a 2D array to store the dynamic programming results   dp=[4][5]

        // Fill in the first row of the dp array with 1's and 0's
        for (int j = 0; j < m; j++) {
            dp[0][j] = Character.getNumericValue(strArr[0].charAt(j));
        }

        // Fill in the rest of the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strArr[i].charAt(j) == '1') { // if the current cell contains a 1
                    dp[i][j] = dp[i-1][j] + 1; // set the value in the dp array to the sum of the value above it and 1
                }
            }
        }

        int maxArea = 0; // initialize the maximum area to 0

        // For each cell in the matrix, compute the maximum area of a submatrix containing all 1's that ends at this cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int width = Integer.MAX_VALUE; // initialize the width to infinity

                // For each cell in the current row that has a value of 1 in the dp array, compute the width of the submatrix
                for (int k = j; k < m; k++) {
                    if (dp[i][k] == 0) { // if the value in the dp array is 0, then we have reached the end of the submatrix
                        break;
                    }
                    width = Math.min(width, dp[i][k]); // update the width to the minimum value seen so far
                    int area = width * (k-j+1); // compute the area of the submatrix
                    maxArea = Math.max(maxArea, area); // update the maximum area seen so far
                }
            }
        }

        return maxArea; // return the maximum area of a submatrix containing all 1's
    }


    public static void main(String[] args) {
        String[] input1 = {"10100", "10111", "11111", "10010"};
        int output1 = MatrixChallenge(input1);
        System.out.println(output1); // should output 6

        String[] input2 = {"1011", "0011", "0111", "1111"};
        int output2 = MatrixChallenge(input2);
        System.out.println(output2); // should output 8

        String[] input3 = {"101", "111", "001"};
        int output3 = MatrixChallenge(input3);
        System.out.println(output3); // should output 3
    }
}

package chapter1.ArraysAndStrings;

public class ZeroMatrix {
    boolean[] zeroifiedRow;
    boolean[] zeroifiedCol;

    /**
     * Check if an element in MxN matrix is 0 and set entire row and column to 0
     * time: O(nm*(n+m))
     * space: O(n+m)
     *
     * Problem: to not count any 0's which where set by algorithm
     */
    public void zeroMatrix(int[][] matrix) {
        zeroifiedRow = new boolean[matrix.length]; // to keep track of set rows by algo
        zeroifiedCol = new boolean[matrix[0].length]; // keep track of set columns by algo

        for(int row = 0; row < matrix.length; row++)
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    setToZero(matrix, row, col);
                    zeroifiedRow[row] = true;
                    zeroifiedCol[col] = true;
                    break;
                }
            }
    }

    public void setToZero(int[][] matrix, int zeroRow, int zeroCol) {
        // set entire row to zero
        // Arrays.fill(matrix[zeroRow], 0); // as alternative
        for(int num = 0; num < matrix[zeroRow].length; num++)
            if(!zeroifiedCol[zeroCol]) matrix[zeroRow][num] = 0;

        // set entire colum to zero
        for(int num = 0; num < matrix.length; num++)
            if(!zeroifiedRow[zeroRow]) matrix[num][zeroCol] = 0;
    }

    /**
     * Compressed version
     */
    public void setZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // scan matrix for 0's, not changing the matrix yet
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // nullify each found row with 0
        for(int i = 0; i < matrix.length; i++)
            if(row[i]) nullifyRow(matrix, i);

        // nullify each found col with 0
        for(int j = 0; j < matrix[0].length; j++)
            if(col[j]) nullifyCol(matrix, j);
    }

    public void nullifyRow(int[][] matrix, int row) {
        for(int col = 0; col < matrix[0].length; col++)
            matrix[row][col] = 0;
    }

    public void nullifyCol(int[][] matrix, int col) {
        for(int row = 0; row < matrix.length; row++)
            matrix[row][col] = 0;
    }

    /**
     * setZero in O(1) space
     */
    public void setZeroLessSpace(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check if first row/col has any zeros
        for(int col = 0; col < matrix[0].length; col++) // col
            if(matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }

        for(int row = 0; row < matrix.length; row++)
            if(matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }

        // loop thru rest of matrix to find zero's
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) { // save zeros in first row/col
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set every zero row
        for(int i = 1; i < matrix.length; i++)
            if(matrix[i][0] == 0) nullifyRow(matrix, i);

        // set every zero column
        for(int j = 1; j < matrix[0].length; j++)
            if(matrix[0][j] == 0) nullifyCol(matrix, j);

        if(firstRowZero) nullifyRow(matrix, 0);
        if(firstColZero) nullifyCol(matrix, 0);
    }
}

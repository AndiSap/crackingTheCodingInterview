package chapter1.ArraysAndStrings;

public class RotateMatrix {

    /**
     * Rotate a matrix by 90 degrees (not in place)
     * time: O(n^2)
     * space: O(n^2)
     */
    public int[][] rotate90(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix.length];

        for(int row = matrix.length -1; row >= 0; row--)
            for(int col = 0; col < matrix[0].length; col++)
                rotated[col][matrix.length - 1 - row] = matrix[row][col];

        return rotated;
    }

    /**
     * Rotate matrix in place
     * for every layer, we perform following swap:
     *  tmp = top[i];
     *  top[i] = left[i];
     *  left[i] = bottom[i];
     *  bottom[i] = right[i];
     *  right[i] = tmp;
     */
    public void rotateInPlace(int[][] matrix) {
//        if(matrix.length == 0 || matrix.length != matrix[0].length)
//            return;

        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int top = matrix[first][i];

                //swap left to top
                matrix[first][i] = matrix[last - offset][first];

                //swap bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                // swap right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // swap top to right
                matrix[i][last] = top;
            }
        }
    }
}

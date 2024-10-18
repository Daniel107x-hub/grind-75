package week3;

import java.util.Arrays;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        int[][] results = updateMatrix(matrix);
        for (int[] row : results) {
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] results = new int[mat.length][mat[0].length];
        for(int[] row : results) Arrays.fill(row, Integer.MAX_VALUE);
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[i].length ; j++){
                checkSurroundings(mat, results, i, j);
            }
        }
        for(int i = mat.length - 1 ; i >= 0 ; i--){
            for(int j = mat[i].length - 1 ; j >= 0 ; j--){
                checkSurroundings(mat, results, i, j);
            }
        }
        return results;
    }

    private static void checkSurroundings(int[][] mat, int[][] results, int i, int j) {
        if(mat[i][j] == 0) results[i][j] = 0;
        else {
            int left = j > 0 ? results[i][j - 1] : Integer.MAX_VALUE;
            int right = j < mat[i].length - 1 ? results[i][j + 1] : Integer.MAX_VALUE;
            int top = i > 0 ? results[i - 1][j] : Integer.MAX_VALUE;
            int bottom = i < mat.length - 1 ? results[i + 1][j] : Integer.MAX_VALUE;
            int min = Math.min(left, Math.min(right, Math.min(top, bottom)));
            results[i][j] = min == Integer.MAX_VALUE ? min : min + 1;
        }
    }
}

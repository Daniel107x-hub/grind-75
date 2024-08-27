package week1;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        for(int[] row : floodFill(image, 1, 1, 2)){
            for(int e : row){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
//        withRecursion(image, sr, sc, color);
//        return image;
        return withIteration(image, sr, sc, color);
    }

    public static void withRecursion(int[][] img, int row, int col, int color){
        int original = img[row][col];
        img[row][col] = color;
        if(col > 0 && img[row][col - 1] != color && img[row][col - 1] == original) withRecursion(img, row, col - 1, color);
        if(col < img[0].length - 1 && img[row][col + 1] != color && img[row][col + 1] == original) withRecursion(img, row, col + 1, color);
        if(row > 0 && img[row - 1][col] != color && img[row - 1][col] == original) withRecursion(img, row - 1, col, color);
        if(row < img.length - 1 && img[row + 1][col] != color && img[row + 1][col] == original) withRecursion(img, row + 1, col, color);
    }

    public static int[][] withIteration(int[][] image, int row, int col, int color){
        Queue<int[]> q = new ArrayDeque<>();
        int original = image[row][col];
        q.add(new int[]{row, col});
        while(!q.isEmpty()){
            int[] point = q.poll();
            row = point[0];
            col = point[1];
            image[row][col] = color;
            if(col > 0 && image[row][col - 1] != color && image[row][col - 1] == original) q.add(new int[]{row, col - 1});
            if(col < image[0].length - 1 && image[row][col + 1] != color && image[row][col + 1] == original) q.add(new int[]{row, col + 1});
            if(row > 0 && image[row - 1][col] != color && image[row - 1][col] == original) q.add(new int[]{row - 1, col});
            if(row < image.length - 1 && image[row + 1][col] != color && image[row + 1][col] == original) q.add(new int[]{row + 1, col});
        }
        return image;
    }
}

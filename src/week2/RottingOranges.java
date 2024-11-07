package week2;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        boolean[][] path = new boolean[grid.length][grid[0].length];
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[row][col] == 2) distance[row][col] = 0;
                else if(grid[row][col] == 1) distance[row][col] = Integer.MAX_VALUE;
                else distance[row][col] = Integer.MIN_VALUE;
            }
        }
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(distance[row][col] == 0){
                    path[row][col] = true;
                    dfs(grid, distance, row - 1, col, 1, path);
                    dfs(grid, distance, row + 1, col, 1, path);
                    dfs(grid, distance, row, col - 1, 1, path);
                    dfs(grid, distance, row, col + 1, 1, path);
                    path[row][col] = false;
                }
            }
        }
        int max = 0;
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(distance[row][col] == Integer.MAX_VALUE) return -1;
                max = Math.max(distance[row][col], max);
            }
        }
        return max;
    }

    public static void dfs(int[][] grid, int[][] distance, int row, int col, int currentDistance, boolean[][] path){
        if(row < 0 || row >= grid.length) return;
        if(col < 0 || col >= grid[0].length) return;
        if(path[row][col]) return;
        if(distance[row][col] == Integer.MIN_VALUE || distance[row][col] == 0) return;
        int curr = distance[row][col];
        distance[row][col] = Math.min(curr, currentDistance);
        path[row][col] = true;
        dfs(grid, distance, row - 1, col, currentDistance + 1, path);
        dfs(grid, distance, row + 1, col, currentDistance + 1, path);
        dfs(grid, distance, row, col - 1, currentDistance + 1, path);
        dfs(grid, distance, row, col + 1, currentDistance + 1, path);
        path[row][col] = false;
    }
}

package week2;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numberOfIslands(grid));
    }

    /**
     * Method which counts how many groups of adjacent cells containing '1' as the value exist.
     * An island is a group of 1 or more adjacent cells with the value '1' on it.
     * For finding the number of islands, we will do DFS and also keep track of the already visited cells
     * @param grid
     * @return Number of islands
     */
    public static int numberOfIslands(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(visited[row][col]) continue;
                if(grid[row][col] == '0'){
                    visited[row][col] = true;
                    continue;
                }
                dfs(grid, visited, row, col);
                islands++;
            }
        }
        return islands;
    }

    public static void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if(row >= grid.length || row < 0) return;
        if(col >= grid[0].length || col < 0) return;
        if(visited[row][col]) return;
        visited[row][col] = true;
        if(grid[row][col] == '0') return;
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col - 1);
        dfs(grid, visited, row, col + 1);
    }
}

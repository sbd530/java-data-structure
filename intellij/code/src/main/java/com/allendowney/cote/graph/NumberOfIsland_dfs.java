package com.allendowney.cote.graph;

public class NumberOfIsland_dfs {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'1','1','1','0','0'},
                {'0','0','0','1','1'}};

        NumberOfIsland_dfs n = new NumberOfIsland_dfs();
        System.out.println(n.solve(grid));

    }

    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int count = 0;

    private int solve(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        // ITER
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        // escape
        if(i < 0 || i >= m || j<0 || j>=n || grid[i][j] != '1') return;

        // visited
        grid[i][j] = 'X';

        // 4 dirs
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

}

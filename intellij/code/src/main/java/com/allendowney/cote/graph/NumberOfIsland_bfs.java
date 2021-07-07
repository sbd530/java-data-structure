package com.allendowney.cote.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_bfs {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'1','1','1','0','0'},
                {'0','0','0','1','1'}};
        NumberOfIsland_bfs n = new NumberOfIsland_bfs();
        System.out.println(n.solve(grid));
    }

    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int count = 0;

    private int solve(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {

        //visited
        grid[x][y] = 'X';

        // DS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        //ITER
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == '1') {
                    grid[nextX][nextY] = 'X';
                    queue.offer(new int[]{nextX, nextY});
                }
            }

        }

    }


}

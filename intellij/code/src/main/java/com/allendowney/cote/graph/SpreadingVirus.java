package com.allendowney.cote.graph;

import java.util.*;

public class SpreadingVirus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        copiedGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2)
                    virusList.add(new Virus(i, j));
            }
        }
        // ---INPUT

        buildWall(0,0);
        System.out.println(max);
    }

    public static class Virus {
        int x,y;
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int m;
    static int n;
    static int max = 0;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] grid;
    static int[][] copiedGrid;
    static List<Virus> virusList = new ArrayList<>();

    private static void buildWall(int start, int count) {
        if (count == 3) {
            // copy initial grid
            copyGrid();

            // spread virus
            for (Virus virus : virusList) {
                spreadVirus(virus.x, virus.y);
            }

            // get the max of safe area
            max = Math.max(max, countSafeArea());

            return;
        }

        for (int i = start; i < m * n; i++) {
            int x = i / n;
            int y = i % n;
            if (grid[x][y] == 0) {
                grid[x][y] = 1;
                buildWall(i + 1, count + 1);
                grid[x][y] = 0;
            }
        }
    }

    private static void spreadVirus(int x, int y) {
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && copiedGrid[nextX][nextY] == 0) {
                copiedGrid[nextX][nextY] = 2;
                spreadVirus(nextX, nextY);
            }
        }
    }

    private static int countSafeArea() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copiedGrid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void copyGrid() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copiedGrid[i][j] = grid[i][j];
            }
        }
    }

}

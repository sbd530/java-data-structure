package com.allendowney.cote.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_bfs {

    public static void main(String[] args) {
        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start= {0,4};
        int[] dest = {4,4};
//		int[] dest = {3,2};
        Maze_bfs a= new Maze_bfs();
        System.out.println(a.hasPath(maze, start,dest ));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m ,n;

    private boolean hasPath(int[][] maze, int[] start, int[] dest) {

        m = maze.length;
        n = maze[0].length;

        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;//start point

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                while (x >= 0 && y >= 0 && x < m & y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                // 바로 앞이 3,4 -> 2,4 뒤로 빽
                x -= dir[0];
                y -= dir[1];

                if (visited[x][y]) continue;
                visited[x][y] = true;
                if (x == dest[0] && y == dest[1]) return true;

                queue.offer(new int[]{x, y});
            }
        }

        return true;

    }

}

package com.allendowney.cote.sortAndSearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthClosestPoints {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {-5,6},{0,-1}};
        int k = 2;
        points = solve(points, k);
        for (int[] point : points) {
            System.out.println(point[0] + ", " + point[1]);
        }
    }

    private static int[][] solve(int[][] points, int k) {

        // DS
        Queue<int[]> pq = new PriorityQueue<>((x, y) ->
                (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]));
        int[][] result = new int[k][2];

        // ITER
        for (int[] point : points) {
            pq.offer(point);
        }

        // poll
        int index = 0;
        while (index < k) {
            result[index++] = pq.poll();
        }
        return result;
    }
}

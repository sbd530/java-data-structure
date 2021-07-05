package com.allendowney.cote.sortAndSearch;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom {

    public static void main(String[] args) {
        MeetingRoom m = new MeetingRoom();
        int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
//        int[][] intervals = {{5, 10}, {16, 20}};
        System.out.println(m.solve(intervals));
        System.out.println(m.solve2(intervals));
    }

    private int solve2(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        // DS
        Queue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);

        // SORT
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        //ITER
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
            } else {
                if (interval[0] >= pq.peek()[1]) {
                    pq.poll();
                }
                pq.offer(interval);
            }
        }
        return pq.size();
    }

    private boolean solve(int[][] intervals) {
        if(intervals == null || intervals.length ==0)
            return false;
        // DS int[][]

        // SORT
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        // ITER
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end)
                return false;
            end = intervals[i][1];
        }

        return true;
    }
}

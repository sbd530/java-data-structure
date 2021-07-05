package com.allendowney.cote.sortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] intervals = {{1,4},{8,10},{2,6},{15,18}};
        int[][] result = mergeInterval.solve(intervals);
        for (int[] i : result) {
            System.out.println(i[0] + ", " + i[1]);
        }
    }

    private int[][] solve(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length ==0 || intervals == null)
            return result.toArray(new int[0][]);

        // DS int[][]

        // SORT
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        // ITER
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (end > interval[0]) {
                end = Math.max(end, interval[1]);
            }else{
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}

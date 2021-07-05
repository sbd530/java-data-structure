package com.allendowney.cote.sortAndSearch;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInElement {

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,6,5};
        int k = 4;

        System.out.println(solve1(nums, k));
        System.out.println(solve2(nums, k));
    }

    private static int solve1(int[] nums, int k) {

        Arrays.sort(nums);
        int size = nums.length;
        return nums[size - k];

    }

    private static int solve2(int[] nums, int k) {

        // DS
        Queue<Integer> pq = new PriorityQueue<>();

        // iter
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

}

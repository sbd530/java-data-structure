package com.allendowney.thinkdast;

public class MyArraySorter {

    static int[] array = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    static void quickSort(int[] array, int start, int end) {
        if (start >= end) { // 원소가 1개인 경우
            return;
        }

        int key = start; // key 는 첫번째 원소
        int i = start + 1; // 왼쪽 출발 지점
        int j = end; // 오른쪽 출발 지점
        int temp;

        while (i <= j) { // 엇갈릴 때까지 반복
            while (array[i] <= array[key] && i<=end) { // i값이 key 값보다 클때까지 반복
                i++;
            }
            while (array[j]>= array[key] && j > start) { // j값이 key 값보다 작을때까지 반복
                j--;
            }
            if (i > j) { // 현재 엇갈린 상태면 키값과 교체
                temp = array[j];
                array[j] = array[key];
                array[key] = temp;
            } else {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }

            quickSort(array, start, j - 1);
            quickSort(array, j + 1, end);
        }


    }

    public static void main(String[] args) {

        quickSort(array, 0, 9);
        for (int i : array) {
            System.out.println(i);
        }
    }

}

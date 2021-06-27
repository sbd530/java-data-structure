package com.allendowney.thinkdast;

import java.util.*;

public class MyListSorter<E> {

    // 선택 정렬
    public List<E> selectionSort(List<E> list, Comparator<E> comparator) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                E e_i = list.get(i);
                E e_j = list.get(j);
                if (comparator.compare(e_i, e_j) >= 0) {
                    list.set(i, e_j);
                    list.set(j, e_i);
                }
            }
        }
        return list;
    }

    // 삽입 정렬
    // 이미 정렬되어 있으면 선형
    public List<E> insertionSort(List<E> list, Comparator<E> comparator) {

        for (int i = 1; i < list.size(); i++) {
            E e_i = list.get(i);
            int j = i;
            while (j > 0) {
                E e_j = list.get(j - 1);
                if (comparator.compare(e_i, e_j) >= 0) {
                    break;
                }
                list.set(j, e_j);
                j--;
            }
            list.set(j, e_i);
        }

        return list;
    }

    // 합병 정렬
    public void mergerSort(List<E> list, Comparator<E> comparator) {
        List<E> sortedList = divideAndMerge(list, comparator);
        list.clear();
        list.addAll(sortedList);
    }

    private List<E> divideAndMerge(List<E> list, Comparator<E> comparator) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        // divide
        List<E> first = divideAndMerge(new LinkedList<E>(list.subList(0, size / 2)), comparator);
        List<E> second = divideAndMerge(new LinkedList<E>(list.subList(size / 2, size)), comparator);

        return merge(first, second, comparator);
    }

    private List<E> merge(List<E> first, List<E> second, Comparator<E> comparator) {
        List<E> result = new LinkedList<>();
        int total = first.size() + second.size();
        for (int i = 0; i < total; i++) {
            List<E> winner = pickWinner(first, second, comparator);
            result.add(winner.remove(0));
        }
        return result;
    }

    private List<E> pickWinner(List<E> first, List<E> second, Comparator<E> comparator) {
        if (first.size() == 0) {
            return second;
        }
        if (second.size() == 0) {
            return first;
        }
        int result = comparator.compare(first.get(0), second.get(0));
        if (result < 0) {
            return first;
        }
        if (result > 0) {
            return second;
        }
        return first;
    }

    public void heapSort(List<E> list, Comparator<E> comparator) {
        PriorityQueue<E> heap = new PriorityQueue<>(list.size(), comparator);
        heap.addAll(list);
        list.clear();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
    }




    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 8, 9, 1, 8, 7, 3, 4));
        MyListSorter<Integer> sorter = new MyListSorter<>();
        List<Integer> selectionSortList = sorter.selectionSort(list, Integer::compareTo);
        System.out.println(selectionSortList);
        List<Integer> insertionSortList = sorter.selectionSort(list, Integer::compareTo);
        System.out.println(insertionSortList);


        list = new ArrayList<>(Arrays.asList(5, 4, 8, 9, 1, 8, 7, 3, 4));
        sorter.mergerSort(list, Integer::compareTo);
        System.out.println(list);

        list = new ArrayList<>(Arrays.asList(5, 4, 8, 9, 1, 8, 7, 3, 4));
        sorter.heapSort(list, Integer::compareTo);
        System.out.println(list);
    }

}

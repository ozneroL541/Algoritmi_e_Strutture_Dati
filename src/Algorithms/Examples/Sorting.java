package Algorithms.Examples;

import Algorithms.Sorting.Advanced.Quicksort.Quick;

public class Sorting {
    public static void main(String[] args) {
        Integer [] arr = { 9, 6, 5, 3, 7, 8, 1, 2, 4, 10 };
        Quick.sort(arr);

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}

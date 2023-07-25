package Algorithms.Sorting.Elementary;

import Algorithms.Sorting.Sort;

public class Insertion extends Sort {
    /**
     * Insertionsort
     * It is stable.
     * It is adaptive.
     * 
     * Complexity
     * Best
     * N. Comparisons:  Theta(n)
     * N. Exchanges:    0
     * Worst
     * N. Comparisons:  Theta(n^2)
     * N. Exchanges:    Theta(n^2)
     * Average
     * N. Comparisons:  n^2 / 4
     * N. Exchanges:    n^2 / 4
     * 
     * N. Operations:   O(n^2)
     * @param a array of comparables
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        // for every element
        for( int i = 1; i < N; i++ ) {
            int j = i;
            // while j is more than zero
            // and a[j] is minor than the previous
            while( j > 0 && less( a[j], a[j - 1] ) ) {
                // Exchange j with the previous one
                exch( a, j, j - 1 );
                // Decrease j
                j--;
            }
        }
    }
}

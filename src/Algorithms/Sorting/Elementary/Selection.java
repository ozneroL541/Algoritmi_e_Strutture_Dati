package Algorithms.Sorting.Elementary;

import Algorithms.Sorting.Sort;

public class Selection extends Sort{
    /**
     * Selectionsort
     * 
     * Complexity
     * N. Comparisons:  Theta(n^2)
     * N. Exchanges:    Theta(n)
     * N. Operations:   Theta(n^2)
     * @param a array of comparables
     */
    public static void sort( Comparable[] a ){
        int N = a.length;
        // for every element of the array
        for( int i = 0; i < N; i++ ){
            // current i assigned to min
            int min = i;
            // for every following element
            for( int j = i + 1; j < N; j++ )
                // If there a minor element set it as min
                if ( less(a[j], a[min] ))
                    min = j;
            // Put the current min at the current position
            exch(a,i,min);
        }
    }
}

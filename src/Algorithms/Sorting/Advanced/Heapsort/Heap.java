package Algorithms.Sorting.Advanced.Heapsort;

import Algorithms.Sorting.Sort;

public class Heap extends Sort {
    /**
     * Sort the array using Heapsort.
     * Make a Maximum Priority Queue from the array.
     * Delete the Heap from the back and assign
     * the elements to the array.
     * 
     * Complexity
     * O(nlog(n))
     * Not stable algorithm
     * @param a array
     */
    public static void sort(Comparable[] a){
        // Create a heap
        MaxPQ cp = new MaxPQ( a.length + 1 );
        // Built it bottom up from the array
        cp.buildBU(a);
        // For every element of the array from the back
        for( int i = a.length-1; i >= 0; i-- )
            // Assign the item with maximum priority
            // to the following element of the array
            a[i] = cp.delete();
    }
}

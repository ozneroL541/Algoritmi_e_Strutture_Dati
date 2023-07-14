package Algorithms.Sorting.Advanced.Heapsort;

import Algorithms.Sorting.Sort;

public class Heap extends Sort {
    public static void sort(Comparable[] a){
        MaxPQ cp = new MaxPQ( a.length + 1 );
        cp.buildBU(a);
        for( int i = a.length-1; i >= 0; i-- )
            a[i]=cp.delete();
    }
}

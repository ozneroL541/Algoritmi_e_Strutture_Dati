package Algorithms.Sorting.Advanced;

import Algorithms.Sorting.Advanced.Partition;

public class Quick extends Partition {
    public static void sort( Comparable[] a ){
        sort( a, 0, a.length-1 );
    }
    private static void sort( Comparable[] a, int l, int r ) {
        if ( r <= l )
            return;
    int j = partition( a, l, r );
    sort( a, l, j-1 );
    sort( a, j+1, r );
    }
}

package Algorithms.Sorting.Advanced;

import Algorithms.Sorting.Sort;

public class Quick extends Sort {
    /**
     * The array is divided in elements bigger
     * and smaller than the pivot.
     * @param a array
     * @param l pivot
     * @param r last element of the array
     * @return pivot
     */
    protected static int partition( Comparable[] a, int l, int r ) {
        // Set i as the beginning and j ad the end
        int i = l, j = r + 1;
        // Copy the array in v
        Comparable v = a[l];
        // For ever 
        while ( true ){
            // Increment i and go on if a[i] is less than v
            while ( less( a[++i], v ) )
                // Stop when i reaches r
                if( i == r )
                    break;
            // Decrease j and go on if a[j] is more than v
            while ( less( v, a[--j] ) )
                // Stop when j reaches l
                if( j == l )
                    break;
            // Stop if i is more than j
            if ( i >= j ) 
                break;
            // Exchange i with j
            exch( a, i, j );
        }
        // Exchange l with j
        exch( a, l, j );
        // Return j
        return j;
    }
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

package Algorithms.Sorting.Advanced;

import Algorithms.Sorting.Sort;

public class Quick extends Sort {
    protected static int partition( Comparable[] a, int l, int r ) {
        int i = l,j = r + 1;
        Comparable v = a[l];
        while ( true ){
            while ( less( a[++i], v ) )
                if( i == r )
                    break;
        while ( less( v, a[--j] ) )
            if( j == l )
                break;;
        if ( i >= j ) 
            break;
        exch( a, i, j );
        }
        exch( a, l, j );
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

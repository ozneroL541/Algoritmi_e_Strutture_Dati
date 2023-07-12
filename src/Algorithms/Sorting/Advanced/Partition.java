package Algorithms.Sorting.Advanced;

import Algorithms.Sorting.Sort;

public class Partition extends Sort {
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
}

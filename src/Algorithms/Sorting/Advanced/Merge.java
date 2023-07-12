package Algorithms.Sorting.Advanced;

import Algorithms.Sorting.Sort;
import Data_Structures.List_Stack_Queue.List;

public class Merge extends Sort {
    /**
     * It orders an array which is made up of two ordered array chained together.
     * @param a     array
     * @param lo    first element of a
     * @param mid   middle element of a
     * @param hi    last element of a
     */
    public static void merge( Comparable[] a, int lo, int mid, int hi) {
        // merge of a[lo..mid] with a[mid+1..hi]
        // Make a new array
        Comparable[] aux = new Comparable[a.length];
        // Indexes initialization
        int i = lo, j = mid + 1;
        // Copy a in aux
        for( int k = lo; k <= hi; k++ )
            aux[k] = a[k];
        // Compares the element of the array
        for( int k = lo; k <= hi; k++ )
            // If i is bigger than middle
            if( i > mid )
                // k element of a assigned with aux[j] and increment j
                a[k] = aux[j++];
            // If j is bigger than high
            else if( j > hi )
                // k element of a assigned with aux[i] and increment i
                a[k] = aux[i++];
            // If the element j is smaller than i
            else if( less( aux[j], aux[i] ) )
                // k element of a assigned with aux[j] and increment j
                a[k] = aux[j++];
            else
                // k element of a assigned with aux[i] and increment i
                a[k] = aux[i++];
    }
    
    public static List<Comparable> mergeL( List<Comparable> a, List<Comparable> b) {
        List<Comparable> c = new List<Comparable>();
        if( a.isEmpty() )
            return b;
        if( b.isEmpty() )
            return a;
        Comparable x = a.Read(1);
        Comparable y = b.Read(1);
        while( ( x != null ) && ( y != null ) )
            if (less(x,y)) {
                c.add(x);
                a.Delete(1);
                x=a.Read(1);
            } else {
                c.add(y);
                b.Delete(1);
                y = b.Read(1);
            }
        if( x == null )
            c.Connect(b);
        else
            c.Connect(a);
        return c;
    }
    public static void mergesort(Comparable[] a,int lo,int hi) {
        if( hi <= lo )
            return;
        int mid = lo + ( hi - lo ) / 2;
        mergesort( a, lo, mid);
        mergesort( a, mid + 1, hi );
        merge( a, lo, mid, hi );
    }
}

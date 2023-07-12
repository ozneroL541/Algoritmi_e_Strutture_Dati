package Algorithms.Sorting.Advanced.Divide_et_Impera;

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
    public static void merge( Comparable[] a, int lo, int mid, int hi ) {
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
    /**
     * It merges two ordered lists making a new ordered list
     * @param a first list
     * @param b second list
     * @return merged list
     */
    public static List<Comparable> mergeL( List<Comparable> a, List<Comparable> b ) {
        // Creates a new list
        List<Comparable> c = new List<Comparable>();
        // If the first list is empty return just the second one
        if( a.isEmpty() )
            return b;
        // If the second list is empty return just the first one
        if( b.isEmpty() )
            return a;
        // Read the first item of the list
        Comparable x = a.Read(1);
        Comparable y = b.Read(1);
        // While the pointer aren't null
        while( ( x != null ) && ( y != null ) )
            // If x is lower than y
            if (less(x,y)) {
                // Add x to the list
                c.add(x);
                // Delete x from the list
                a.Delete(1);
                // Read the following number
                x = a.Read(1);
            } else {
                // Add y to the list
                c.add(y);
                // Delete y from the list
                b.Delete(1);
                // Read the following number
                y = b.Read(1);
            }
        // If x is null
        if( x == null )
            // Attach b to c
            c.Connect(b);
        else
            // Attach a to c
            c.Connect(a);
        return c;
    }
    public static void mergesort( Comparable[] a, int lo, int hi ) {
        // If high is lower than low stop
        if( hi <= lo )
            return;
        // calculate the middle
        int mid = lo + ( hi - lo ) / 2;
        // Recoursively mergesort the first part of the array
        mergesort( a, lo, mid );
        // Recoursively mergesort the second part of the array
        mergesort( a, mid + 1, hi );
        // Merge the two part of the array
        merge( a, lo, mid, hi );
    }
}

package Algorithms.Sorting.Advanced.Quicksort;

import Data_Structures.List_Stack_Queue.List;

public class QuickB extends Quick {
    /**
     * Partition on list for Bentley-Mcllroy Quicksort.
     * @param a
     * @return
     */
    public static List<Comparable>[] BPart( List<Comparable> a ){
        List<Comparable> c[] = new List[3];
        Comparable x, pivot;
        x = pivot = a.Read(1);
        c[1].Add(x);
        a.Delete(1);
        x = a.Read(1);
        while( x != null ){
        if ( less( x, pivot ) )
            c[0].Add(x);
        else if ( less( pivot, x ) )
            c[2].Add(x);
        else
            c[1].Add(x);
        a.Delete(1);
        x = a.Read(1);
        }
        return c;
    }
    /**
     * Bentley-Mcllroy Quicksort on list.
     * @param a list
     * @return
     */
    public static List<Comparable> sort( List<Comparable> a ){
        List<Comparable> c[];
        if ( a.length() == 1 )
            return a;
        c = BPart(a);
        if ( c[0] != null )
            c[0] = sort( c[0] );
        if ( c[2] != null )
            c[2] = sort( c[2] );
        c[0].Connect( c[1] );
        c[0].Connect( c[2] );
        return c[0];
    }
}

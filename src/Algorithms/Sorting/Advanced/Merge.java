package src.Algorithms.Sorting.Advanced;

import java.util.List;

import src.Algorithms.Sorting.Sort;

public class Merge extends Sort {
    public static void merge( Comparable[] a, int lo, int mid, int hi) {
        // merge of a[lo..mid] with a[mid+1..hi]
        Comparable[] aux = new Comparable[a.length];
        int i = lo, j = mid + 1;
        for( int k = lo; k <= hi; k++ )
            aux[k] = a[k];
        for( int k = lo; k <= hi; k++ )
            if( i > mid )
                a[k] = aux[j++];
            else if( j > hi )
                a[k] = aux[i++];
            else if( less( aux[j], aux[i] ) )
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }
    // TODO
    /*
    public static List<Comparable> mergeL(List<Comparable> a,List<Comparable> b) {
        List<Comparable> c;
        if( a.isEmpty() )
            return b;
        if( b.isEmpty() )
            return a;
        Comparable x = a.Read(1);
        Comparable y = b.Read(1);
        while( ( x != null ) && ( y != null ) )
            if (less(x,y)) {
                c.inserisciInCoda(x);
                a.Delete(1);
                x=a.Read(1);
            } else {
                c.inserisciInCoda(y);
                b.Delete(1);
                y = b.Read(1);
            }
        if( x == null )
            Concatena(c,b);
        else Concatena(c,a);
        return c;
    }
    */
}

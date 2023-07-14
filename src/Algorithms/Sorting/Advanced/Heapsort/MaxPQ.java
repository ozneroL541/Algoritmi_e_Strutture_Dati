package Algorithms.Sorting.Advanced.Heapsort;
import java.lang.Comparable;
import Algorithms.Sorting.Sort;

public class MaxPQ extends Sort {
    private Comparable[] pq;
    private int n = 0;
    public MaxPQ ( int dim ){
        this.pq = new Comparable[dim+1];
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    public void insert(Comparable v){
        pq[++n] = v;
        swim(n);
    }
    public Comparable read(){
        return pq[1];
    }
    public Comparable delete(){
        Comparable max = pq[1];
        exch(1,n--);
        pq[n+1] = null;
        sink(1);
        return max;
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i,int j){
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim(int k){
        while( k > 1 && less( k/2, k ) ){
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k){
        while( 2*k <= n ){
            int j = 2*k;
            if( j < n && less( j, j+1 ) )
                j++;
            if( !less( k, j ) )
                break;
            exch( k, j );
            k = j;
        }
    }
    public void buildBU( Comparable[] a){
        if( a.length < pq.length ){
            n = a.length;
            for( int i = 0; i < a.length; i++ )
                pq[i+1] = a[i];
            for( int i = n/2; i >= 1; i-- )
                sink(i);
        }
    }
}

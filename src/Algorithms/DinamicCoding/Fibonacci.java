package Algorithms.DinamicCoding;

public class Fibonacci {
    public static int Fib( int n ) {
        if ( n <= 1 )
            return 1;
        else
            return Fib( n - 1 ) + Fib( n - 2 );
    }
    public static int DFibNotOptimized( int n ) {
        int [] V = new int[n+2];
        V[0] = 0;
        V[1] = 1;
        for (int k = 2; k < n+2; k++) {
            V[k] = V[k-1] + V[k-2];
        }
        return V[n+1];
    }

    public static int DFib( int n ) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int k = 0; k < n; k++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int f = 6;
        int a = DFib(f);
        System.out.println(a);
        a = DFibNotOptimized(f);
        System.out.println(a);
        a = Fib(f);
        System.out.println(a);
    }
}

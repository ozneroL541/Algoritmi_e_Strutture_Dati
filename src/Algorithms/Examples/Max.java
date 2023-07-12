package Algorithms.Examples;

import java.util.Scanner;

public class Max {
    public void calcMax() {
        Scanner sc = new Scanner(System.in);
        int [] s = new int[3];

        s[1] = sc.nextInt();
        while ( s[1] != 0 ) {
            if ( s[1] != 0 ) {
                s[0] = s[1];
                s[2] = sc.nextInt();
                s[0] = s[0] - s[2];
            }
            if ( ! (s[0] > 0) ){
                s[0] = s[2];
                s[1] = s[0];
            }
        }
        System.out.println( "Max" + s[1] );
    }
}

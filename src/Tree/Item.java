package src.Tree;

public class Item implements Comparable {
    private int x;
    public Item( int a ) {
        this.x = a;
    }
    @Override
    public int compareTo( Object o ) {
        if ( o instanceof Item ){
            int r = this.x;
            r += - ((Item) o).getInt();
            return r;
        } else {
            return -2;
        }
    }
    
    public boolean equals( Item o ) {
        return this.x == o.getInt();
    }
    public int getInt() {
        return this.x;
    }
}

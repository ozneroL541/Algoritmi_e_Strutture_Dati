package Data_Structures.Hash;

public class Hash {
    int DIMALFA = 0;
    int DIMTAB = 128;
    public int Hash( String v ){
        int h,l,m;
        char c;
        l = v.length();
        m = 0;
        for( h = 1; h <= l; h++ ){
        c = v.charAt(h);
        m = ( DIMALFA*m + getNumericValue(c)) % DIMTAB;
        }
        return m;
    }
    private int getNumericValue(char c) {
        return 0;
    }
    public void Member( Object x ) {
        
    }
    public void Insert( Object x ) {
        
    }
    public void Delete( Object x ) {
        
    }
}

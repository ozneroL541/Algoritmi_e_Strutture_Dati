package Tree;
/**
 * An object of the <i>Binary Search Tree</i> class rapresents a tree of nodes
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class BST<Item>{
    private class Node{ 
        // Item
        public int item;
        // Left, Right and Father Nodes
        public Node sx, dx, father;
        public Node( int x) {
            item = x;
            sx = dx = father = null;
        }
        }
        
    // Root of the Tree
    private Node root;
    /**
     * It build a Binary Search Tree setting the root as null
     */
    public BST() {
        root = null;
    }
    /**
     * It searches recoursively the integer x
     * using the private mathod
     * @see #searchP( Node n, int x )
     * @param x integer
     * @return node with the item
     */
    public Node search( int x ){
        return searchP( root,x);
    }
    /**
     * Recoursively rearch the node where x is and return it
     * @param n node
     * @param x unknown
     * @return the node where x is
     */
    private Node searchP( Node n, int x ){
        // If the node does not exist or the node's item equals to x
        if ( n == null || n.item == x)
            // Aeturn the current node
            return n;
        // If the node's item is greater than x 
        if ( n.item > x)
            // Recoursively call this method with the left node
            return searchP( n.sx, x ); 
        else 
            // Recoursively call this method with the right node
            return searchP( n.dx, x ); 
    }
    /**
     * Iteratively rearch the node where x is and return it
     * @param x unknown
     * @return the node where x is
     */
    public Node searchIt(int x){
        // Initialize n with root
        Node n = root;
        // while the x is not found a and the the node is not a leaf
        while ( n != null && n.item != x )
            // If the node's item is greater than x
            if ( n.item > x )
                // Assign the n's left child to n
                n = n.sx;
            else
                // Assign the n's right child to n
                n = n.dx;
        // Return n
        return n; 
    }
    /**
     * It prints the items recoursively using private method inorderP
     * @see #inorderP(Node n)
     */
    public void inorder(){
        // Call recoursive method with root as first node
        inorderP(root);
        System.out.println(); 
    }
    /**
     * It recoursively prints all the node's items in order
     * @param n node
     */
    private void inorderP(Node n){
        // If the node is not null continue
        if( n != null ){
            // Call the same function with left node as parameter 
            inorderP(n.sx); 
            // Print the item
            System.out.print(" "+n.item+" ");
            // Call the same function with right node as parameter 
            inorderP(n.dx); 
        }
    }
    /**
     * It returns the most little number calling the recursive method minP
     * @return minor
     */
    public Node min(){
        return minP( root);
    }
    /**
     * It recoursively go to the minor and returns it
     * @param n node
     * @return minor
     */
    private Node minP(Node n){
        // If the not is null
        if( n == null )
            // return null
            return null;
        // If the left child is not null call it
        if( n.sx != null )
            // Call the left node recoursively
            return minP(n.sx); 
        // Return this node, it is the minor
        return n;
    }
    /**
     * It insert the item x calling the recoursive method insertP
     * @param x item
     * @see insertP(Node n, int x)
     */
    public void insert(int x){
        insertP( root,x);
    }
    /**
     * It recoursively
     * @param n
     * @param x
     */
    private void insertP(Node n, int x){
        // If the root does not exist create a new node
        if ( root == null)
             root = new Node(x);
        else {
            // If the node's item is greater than x
            if( n.item > x )
                // If the left child equals to null
                if ( n.sx == null ){
                    // Create the left child
                    n.sx = new Node(x);
                    // Set n as father of its left child
                    n.sx.father = n;
                } else
                    // Recoursively call this method with the left child as parameter
                    insertP(n.sx,x);
            // If the node's item is smaller than x
            if( n.item < x )
                // If the right child equals to null
                if ( n.dx == null ){
                    // Create the right child
                    n.dx = new Node(x);
                    // Set n as right of its left child
                    n.dx.father=n;
                }
            else
                // Recoursively call this method with the right child as parameter
                insertP(n.dx,x);
        }
    }
    private void replace(Node n,Node m) {
        if (n.father.sx == n)
            n.father.sx=m;
        else
            n.father.dx = m;
        if (m != null)
            m.father = n.father;
    }
    //rimuove n che ha meno di 2 figli
    private void remove(Node n) {
        if (n.sx==null && n.dx==null)
            replace(n,null);
        else {
            Node tmp;
            if (n.sx!=null)
                tmp=n.sx;
            else
                tmp=n.dx;
            if (n== root){
                 root=tmp;
                 root.father=null;
            }
            else
                replace(n,tmp);
        }
    }
    public void delete(int x){
        deleteP( root,x);
    }
    private void deleteP(Node n, int x){
        if (n != null) {
            if (n.item >x)
                deleteP(n.sx,x);
            if (n.item <x)
                deleteP(n.dx,x);
            if (n.item ==x) {
                //n ha meno di 2 figli
                if (n.sx == null || n.dx==null)
                    remove(n);
                else { //n ha 2 figli
                Node min = minP(n);
                n.item = min.item;
                remove(min);} 
            } 
        }
    }        
}

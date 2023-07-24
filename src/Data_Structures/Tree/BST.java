package Data_Structures.Tree;

import Data_Structures.List_Stack_Queue.Queue;

/**
 * An object of the <i>Binary Search Tree</i> class rapresents a tree of nodes
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class BST{
    // Node where store the items
    private class Node{ 
        // Item
        public int item;
        // Left, Right and Father Nodes
        public Node sx, dx, father;
        /**
         * Node constructor
         * @param x item
         */
        public Node( int x ) {
            // Set the item
            item = x;
            // Set the children and the father of the node
            sx = dx = father = null;
        }
        /**
         * Visit the node
         */
        public void visit() {
            System.out.print(" " + this.item + " ");
        }
    }
    // Root of the Tree
    private Node root;
    /**
     * It build a Binary Search Tree setting the root as null
     */
    public BST() {
        this.root = null;
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
     * Check if the tree has nodes
     * @return true if the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }
    /**
     * Visit the tree with different methods
     * @param i option
     */
    public void visiting( int i ) {
        // Choose the menu
        switch (i) {
            // PreOrder
            case 1:
                preOrderP(this.root);
                break;
            // InOrder
            case 2:
                inOrderP(this.root);
                break;
            // PostOrder
            case 3:
                postOrderP(this.root);
                break;
            // LevelOrder
            case 4:
                levelOrderP(this.root);
                break;
            default:
                break;
        }
    }
    /**
     * Visit the nodes recoursively using private method preOrderP.
     * Firstly visit the node than its children
     * @see #preOrderP(Node n)
     */
    public void preOrder() {
        // Call recoursive method with root as first node
        preOrderP(this.root);
        System.out.println();
    }
    /**
     * Visit the nodes in PreOrder.
     * Firstly visit the node than visit the children
     * @param r current node
     */
    private void preOrderP( Node r ) {
        // If the node is not null
        if (r != null) {
            // Visit the node
            r.visit();
            // Call the method on the left child
            preOrderP(r.sx);
            // Call the method on the right child
            postOrderP(r.dx);
        }
    }
    /**
     * Visit the nodes recoursively using private method inOrderP.
     * Visit the nodes in order.
     * @see #inOrderP(Node n)
     */
    public void inOrder(){
        // Call recoursive method with root as first node
        inOrderP(this.root);
        System.out.println(); 
    }
    /**
     * Recoursively visits nodes in order
     * @param n node
     */
    private void inOrderP(Node n){
        // If the node is not null continue
        if( n != null ){
            // Call the same function with left node as parameter 
            inOrderP(n.sx); 
            // Visit the node
            n.visit();
            // Call the same function with right node as parameter 
            inOrderP(n.dx); 
        }
    }
    /**
     * Visit the nodes recoursively using private method postOrderP.
     * Firstly visit the children than the node
     * @see #postOrderP(Node n)
     */
    public void postOrder() {
        // Call recoursive method with root as first node
        postOrderP(this.root);
        System.out.println();
    }
    /**
     * Visit the nodes in PreOrder.
     * Firstly visit the children than visit the node.
     * @param r current node
     */
    private void postOrderP( Node r ) {
        // If the node is not null
        if (r != null) {
            // Call the method on the left child
            postOrderP(r.sx);
            // Call the method on the right child
            postOrderP(r.dx);
            // Visit the node
            r.visit();
        }
    }
    /**
     * Visit the nodes recoursively using private method levelOrderP.
     * Visit every level of the tree from high to down, from left to right.
     * @see #preOrderP(Node n)
     */
    public void levelOrder() {
        // Call recoursive method with root as first node
        levelOrderP(this.root);
        System.out.println();
    }
    /**
     * Visit the nodes in levelOrder.
     * Visiti every level.
     * @param r current node
     */
    private void levelOrderP( Node r ) {
        // Support queue
        Queue<Node> q = new Queue<Node>();
        // If r is not null enqueue r
        if( r != null )
            q.enqueue(r);
        // While the queue is not empty
        while( !q.isEmpty() ) {
            // Set r as the front of the queue
            r = q.front();
            // Dequeue
            q.dequeue();
            // Visit r
            r.visit();
            // If r has got a left child
            if( r.sx != null )
                // Enqueue the left child
                q.enqueue(r.sx);
            // If r has got a right child
            if( r.dx != null )
                // Enqueue the right child
                q.enqueue(r.dx);
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
    /**
     * Raplace the node n with the node m
     * @param n to raplace
     * @param m to be raplaced
     */
    private void replace( Node n, Node m ){
        // If the left child of the father of n is n
        if (n.father.sx == n)
            // Set the left child of the father of n as m
            n.father.sx = m;
        else
            // Set the right child of the father of n as m
            n.father.dx = m;
        // If m is not null
        if (m != null)
            // Set the father of m as the father of n
            m.father = n.father;
    }
    /**
     * It removes a node which had less than 2 children
     * @param n removing
     */
    private void remove(Node n) {
        // If the node hasn't got any children
        if ( n.sx == null && n.dx == null )
            // Replace the node with null
            replace( n, null);
        else {
            // Temporary node
            Node tmp;
            // If the left child isn't null
            if ( n.sx != null )
                // Assign the temporary node with the left child
                tmp = n.sx;
            else
                // Assign the temporary node with the right child
                tmp = n.dx;
            // If the node is root
            if ( n == root ){
                // Assign the temporary node to the root
                root = tmp;
                // Assign null to the father of the root
                root.father = null;
            } else
                // Replace the node with the temporary one
                replace(n,tmp);
        }
    }
    /**
     * Delete node with item x using the recoursive method DeleteP
     * @param x to be deleted
     * @see #deleteP( Node n, int x )
     */
    public void delete( int x ){
        // Call the recoursive function deleteP
        deleteP( root, x );
    }
    /**
     * Recoursively delete the node with the x item
     * @param n node
     * @param x item
     */
    private void deleteP( Node n, int x ){
        // If n is not null
        if ( n != null ) {
            // If the item is greater than x
            if ( n.item > x )
                // Call recoursively this funtion with the left child of this node
                deleteP(n.sx,x);
            // If the item is smaller than x
            if ( n.item < x )
                // Call recoursively this funtion with the right child of this node
                deleteP(n.dx,x);
            // If the item equals to x
            if ( n.item == x ){
                // If the node has no children
                if ( n.sx == null || n.dx == null )
                    // Remove the node
                    remove(n);
                else { // The node has 2 children
                    // Find the minor
                    Node min = minP(n);
                    // Set the minor item to the node item
                    n.item = min.item;
                    // Remove the minor
                    remove(min);
                } 
            } 
        }
    }
}

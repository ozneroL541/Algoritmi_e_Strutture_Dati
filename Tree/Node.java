package Tree;
/**
 * An object of the <code>Node</code> class rapresents an <code>Item</code> and
 * a pointer to another <code>Node</code>.
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class Node<Item>{
    // Item
    public Item item;
    // Left, Right and Father Nodes
    public Node sx, dx, father;
    /**
     * Assign to the class fields item the parameter x
     * and set the left, right and father nodes to null
     * @param x item
     */
    public Node( Item x ) {
        this.item = x;
        this.sx = this.dx = this.father = null;
    }
}

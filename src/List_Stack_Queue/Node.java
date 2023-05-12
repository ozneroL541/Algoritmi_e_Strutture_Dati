package src.List_Stack_Queue;
/**
 * An object of the <code>Node</code> class rapresents an <code>Item</code> and
 * a pointer to another <code>Node</code>.
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class Node<Item> {
    // Item
    public Item item;
    // Pointer to the next node
    public Node next;
    /**
	 * Assign to the class fields null
	 */
    public Node(){
        this.item = null;
        this.next = null;
    }
    /**
	 * Assign to the class fields item the parameter and put next to null
	 * @param item item
	 */
    public Node(Item item){
        this.item = item;
        this.next = null;
    }
    /**
	 * Assign to the class fields item and next the parameters
	 * @param item item
     * @param next pointer to the next node
	 */
    public Node( Item item, Node next ) {
        this.item = item;
        this.next = next;
    }
}

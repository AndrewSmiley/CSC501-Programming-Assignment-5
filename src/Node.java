/**
 * Created by andrewsmiley on 03/08/17.
 */
public class Node {

    /**
     *This is the value of the node (using object so we can use different types of variables with our linked lists
     */
    private Integer value;

    /**
     *This field refers to the next node in the linked list
     */
    private Node next;

    /**
     * Empty constructor just in case
     */
    public Node() {
    }

    /**
     * One constructor for now, we want to create a node with a predetermined value
     * @param value the value of the node
     */
    public Node(Integer value) {

        this.value = value;
    }

    /**
     * Get the next node
     * @return the next node
     */
    public Node next() {
        return next;
    }

    /**
     * Set the next node
     * @param next the next node in the linked list
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Get the value stored in this node
     * @return the value stored in this node
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Set the value of this node
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Determine if this node has a next node or not
     * @return True if there is a next node, false otherwise
     */
    public Boolean hasNext(){
        return this.next != null;
    }


}
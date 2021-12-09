package Node;

public class Node<T> {
    protected T data;
    protected Node next = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public T getData() {
        // return data stored in this node
        return data;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public Node<T> getNext() {
        // get next node
        return next;
    }

    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}

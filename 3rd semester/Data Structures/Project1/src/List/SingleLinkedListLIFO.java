package List;

import Node.Node;

public class SingleLinkedListLIFO<T> implements SingleLinkedList {
	
	private Node<T> top;

	private int size;
	
	public SingleLinkedListLIFO(){
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return this.size==0;
		
	}
	
	//inserts a Node at the front since the SingleLinkedList is FIFO
	public void insertAtTop(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            top = n;
        } else {
            n.setNext(top);
            top = n;
        }
        this.size++;
    }
	
	//removes(if remove==true) and returns the top item of the SingleLinkedList because its LIFO
	public T removeFromTop(boolean remove){
        T data = top.getData();

        if (size()==1) {
            top = null;
        }else if(remove){
        	top = top.getNext();
        }
        return data;
    }
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node<T> current = top;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n\nHEAD -> ");

        while (current != null) {
            ret.append(current.getData().toString());

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.getNext();
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }

}
package List;

import Node.Node;

public class SingleLinkedListFIFO<T> implements SingleLinkedList{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	//constructor
	public SingleLinkedListFIFO(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	//inserts a Node at the front since the SingleLinkedList is FIFO
	public void insertAtFront(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        this.size++;
    }
	
	//removes(if remove==true) and returns the last item of the SingleLinkedList because its FIFO
	public T removeFromBack(boolean remove){

        T data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node<T> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            if(remove) {
            	iterator.setNext(null);
            }
            tail = iterator;
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

        Node<T> current = head;

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

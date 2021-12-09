package IntQueue;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import List.SingleLinkedListFIFO;

public class IntQueueImpl<T> implements IntQueue<T> {
	
	private SingleLinkedListFIFO<T> QueueItems; //the Single-Linked List that will hold the Queue Items
	
	public IntQueueImpl(){
		 SingleLinkedListFIFO<T> QueueItems = new SingleLinkedListFIFO<T>();
	}
	
	public boolean isEmpty() {
		return this.QueueItems.isEmpty();
	}
	
	public void put(T item) {
		this.QueueItems.insertAtFront(item);
	}
	
	public T get() throws NoSuchElementException{
		if(this.QueueItems.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.QueueItems.removeFromBack(true);
		
	}
	
	public T peek() throws NoSuchElementException{
		if(this.QueueItems.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.QueueItems.removeFromBack(false);
	}
	
	public void printQueue(PrintStream stream) {
		
		System.out.println(this.QueueItems.toString());
	}
	
	public int size() {
		return this.QueueItems.size();
	}


}

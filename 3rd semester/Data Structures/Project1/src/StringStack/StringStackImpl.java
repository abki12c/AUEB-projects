package StringStack;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import List.SingleLinkedListLIFO;

public class StringStackImpl<T> implements StringStack<T> {
	
	private SingleLinkedListLIFO<T> StackItems; //the Single-Linked List that will hold the Stack Items
	
	public StringStackImpl() {
		 SingleLinkedListLIFO<T> StackItems = new SingleLinkedListLIFO<T>();
	}
	
	public boolean isEmpty() {
		return this.StackItems.isEmpty();
	}

	
	public void push(T item) {
		this.StackItems.insertAtTop(item);
	}


	public T pop() throws NoSuchElementException {
		if(this.StackItems.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.StackItems.removeFromTop(true);
	}


	public T peek() throws NoSuchElementException {
		if(this.StackItems.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.StackItems.removeFromTop(false);
	}


	public void printStack(PrintStream stream) {
		System.out.println(this.StackItems.toString());
		
	}


	public int size() {
		
		return this.StackItems.size();
	}

}

package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// wasTODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// DONE: Implement this method
		LLNode<E> newNode = new LLNode<E>(element, this.tail);
		this.size ++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// DONE: Implement this method.
		LLNode<E> result = this.head;
		if (this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("list index out of bounds");
		}
		for (int i = 0; i <= index; i++) {
			result = result.next;
		}
		return result.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// DONE: Implement this method
		
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("list index out of bounds");
		}
		if (this.size == 0) {
			this.add(element);
		} else {
			LLNode<E> add_before = this.head;
			for (int i = 0; i <= index; i++) {
				add_before = add_before.next;
			}
			LLNode<E> added = new LLNode<E>(element, add_before);
			this.size ++;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// DONE: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// DONE: Implement this method
		LLNode<E> result = this.head;
		E result_data;
		if (this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("list index out of bounds");
		}
		for (int i = 0; i <= index; i++) {
			result = result.next;
		}
		result_data = result.data;
		result.prev.next = result.next;
		result.next.prev = result.prev;
		this.size --;
		return result_data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// DONE: Implement this method
		if (this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("index for element "
					+ "to set is out of bounds");
		}
		LLNode<E> result = this.head;

		for (int i = 0; i <= index; i++) {
			result = result.next;
		}
		result.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// DONE: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> next) {
		this.data = e;
		this.next = next;
		this.prev = next.prev;
		next.prev = this;
		this.prev.next = this;
	}

}

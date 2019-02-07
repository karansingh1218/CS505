//**********************************************************************
//  SortedList.java      
//  Name: Karan Singh       
//  Student ID: ks572
//  Student Section : CS 505-852
//  PROJECT 6: Sorted List
//**********************************************************************

import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends AbstractList<E> 
{
	
	public void insert (E data)
	{
		Node<E> temp = new Node<E>(data);
		
		head = insert (head, temp);
	}
	
	private Node<E> insert (Node<E> curr, Node<E> node)
	{
		if (curr == null)
		{
			return node;
		}
		else if (node.data.compareTo(curr.data) < 0)
		{
			node.next = curr;
			return node;
		}
		
		curr.next = insert(curr.next, node);
		
		return curr;		
	}
	
	 public Iterator<E> iterator() 
	 {
	        return new Iterator<E>() 
	        {
	            public boolean hasNext() 
	            {
	                return curr != null;
	            }
	            
	            public E next() 
	            {
	                E next = curr.data;
	                curr = curr.next;
	                return next;
	            }
	            
	            private Node<E> curr = head;
	            
	        };
	}

	public void remove (E key)
	{
		head = remove (head, key);
	}
	
	private Node<E> remove (Node<E> curr, E key)
	{
		if (curr == null)
		{
			return null;
		}
		
		else if (key.compareTo(curr.data) == 0)
		{
			return curr.next;
		}
		
		curr.next = remove (curr.next,key);
		
		return curr;
	}
	
	public E retrieve (int index)
	{
		return retrieve (index, head);
	}
	
	private E retrieve (int index, Node<E> curr)
	{
		int i = 0;
		
		if (i <= index)
		{
			return curr == null ? null : curr.data;
		}
		
		i = i + 1;
		
		return retrieve (index, curr.next );
	}
	
	public boolean search (E key)
	{
		return search (head, key);
	}
	
	private boolean search (Node<E> curr, E key)
	{
		if (curr == null)
		{
			return false;
		}
		else if (key.compareTo(curr.data) == 0)
		{
			return true;
		}
		
		return search (curr.next, key);
	}
	
}
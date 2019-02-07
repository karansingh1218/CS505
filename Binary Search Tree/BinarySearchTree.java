//**********************************************************************
//  BinarySearchTree.java      
//  Name: Karan Singh       
//  Student ID: ks572
//  Student Section : CS 505-852
//  PROJECT 7: Binary Search Tree
//**********************************************************************

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> 
{
	public void insert (E data) 
	{
		root = insert (root, data);
	}
	
	private Node<E> insert (Node<E> curr, E data)
	{
		int cmp;
		
		if (curr == null)
		{
			return new Node<E>(data);
		}
			
		else if ((cmp = data.compareTo(curr.data)) > 0)
		{
			curr.right = insert(curr.right, data);
			
		}
		
		else if ((cmp = data.compareTo(curr.data)) < 0)
		{
			curr.left = insert(curr.left,data);
		}
		
		return curr;
			
	}

    public Iterator<E> iterator() 
    {
        Stack<Node<E>> stack = new Stack<Node<E>>();
        
        if (root != null)
        {
        	stack.push(root);
        }
        
        return new Iterator<E>()
        		{
        	
        	private Stack<Node<E>> sks = stack;
        	
        	public boolean hasNext()
        	{
        		return !sks.isEmpty();
        	}
        	
        	public E next() {
        		
        		Node<E> curr = sks.pop();
        		
        		if (curr.left != null)
        		{
        			sks.push(curr.left);
        		}
        		else
        		{
        			Node<E> temp = sks.pop();
        			
        			while (temp.right == null)
        			{
        				if (sks.isEmpty())
        				{
        					return curr.data;
        					}	
        			}
        		}
        		return curr.data;
        		}
        	};
    }
        		
    public void remove (E key) 
    {
        root = remove (root, key);
    }
    
    private Node<E> remove (Node<E> curr, E key)
    {
    	
    	int cmp;
    	
    	if (curr == null)
    	{
    		return null;
    	}
    	    
    	else if ((cmp = key.compareTo(curr.data)) < 0)
    	{ 	
    		curr.left = remove(curr.left, key);
    		return curr;
    	}
    	
    	else if ((cmp = key.compareTo(curr.data)) > 0)
    	{
    		curr.right = remove(curr.right, key);
    		return curr;
   
    	}
    	else 
    	{
    	if (curr.left == null || curr.right == null)
    	{
    		return curr.left != null ? curr.left: curr.right;
    	}
  
    	else
    	{
    		curr.data = findIOP(curr);
    		curr.left = remove (curr.left, curr.data);
       	
    	  	
    	}
        
    	}
    	return curr;
    }
	
    private E findIOP (Node<E> curr)
	{ 		
    		for (curr = curr.left; curr.right != null; curr = curr.right);
    		
    		return curr.data;
	}
		
	public boolean search (E key) 
	{

	 	return search (root,key);
	}
 
	private boolean search(Node<E> curr, E data)
	    {
	    
	    	int cmp;
	    	
	    	if (curr == null)
	    	{
	    		return false;
	    	}
	     
	    	else if ((cmp = data.compareTo(curr.data)) < 0)
	    	{
	    		return search(curr.left, data);
	    	}
	    	
	    	else if ((cmp = data.compareTo(curr.data)) > 0)
	    	{
	    		return search(curr.right,data);
	    	}
	    	
	    	return true;
	    	
	    }
	    
	}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivethru;

import java.util.Comparator;

/**
 *
 * @author Arief Fahmi
 */
public class LinkedList {
    
   	private ListNode firstNode;
   	private ListNode lastNode;
   	private ListNode currNode; 	// use to traverse the list
   	private String name;  		//  name used for list

	public LinkedList() 		// default constructor
	{	 this( "list" ); }  
   
	public LinkedList(String s)	// normal constructor
	{   name = s;
            firstNode = lastNode = currNode = null;
	}
        
        public boolean isEmpty()
        { 
            return (firstNode == null); 
        }
        
        public void insertAtFront (Object insertItem)
        {
           if (isEmpty())
                     firstNode = lastNode = new ListNode (insertItem);
           else 
                     firstNode = new ListNode (insertItem, firstNode);
        }
        
        public void insertAtBack(Object insertItem)
        {
           if ( isEmpty() )
                     firstNode = lastNode = new ListNode(insertItem);
           else 
                     lastNode = lastNode.next = new ListNode(insertItem);
        }

        
        public Object getFirst()
        {
            if (isEmpty())
                return null;
             else
             {  currNode  =  firstNode;
                return  currNode.data; 
             }
       }

        public Object getNext()
        {
            if (currNode != lastNode)
             {	currNode = currNode.next;
                return currNode.data; 
             }
              else
                return null;
       }
        
    public Object removeFromFront()throws EmptyListException
   { 	Object removeItem = null;
        if (isEmpty())
            throw new EmptyListException(name);
        removeItem = firstNode.data;  	

        if (firstNode.equals (lastNode))
            firstNode = lastNode = null;
        else
            firstNode = firstNode.next;

        return removeItem;  
   }

    public Object removeFromBack()throws EmptyListException
   {  	Object removeItem = null;
      	if (isEmpty()) 
            throw new EmptyListException(name);
      	removeItem = lastNode.data; 	      			 
	if (firstNode.equals( lastNode ) )
            firstNode = lastNode = null;
      	else 
            {	ListNode current = firstNode;
                while ( current.next != lastNode ) 	
                    current = current.next;      		
                lastNode = current;
                current.next = null;      
	}
     	return removeItem;
   }

    public void clear(){
        firstNode = lastNode =  null;
    }

}

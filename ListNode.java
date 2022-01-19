/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivethru;

/**
 *
 * @author Arief Fahmi
 */
public class ListNode {
    
    Object data;    
    ListNode next;

    ListNode( Object obj ) 
    { this( obj, null ); }

    ListNode( Object obj, ListNode nextNode )
    {	data = obj;         	
        next = nextNode;  	
    }
    Object getObject() { return data; } 
    ListNode getNext() { return next; }  
}

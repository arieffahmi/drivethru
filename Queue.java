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
  //  Class Queue  definition
    public class Queue extends LinkedList{
	public Queue()  { }	// constructor

	public void enqueue(Object elem)
	{	insertAtBack (elem);  }

	public Object dequeue(){
            if (super.isEmpty()){return null;}
            else{return removeFromFront();}
        }
        
	public Object getFront()
	{	return getFirst(); }

	public Object getEnd()
	{	Object O = removeFromBack();
		insertAtBack(O);
		return O;		
	}
     } // end Queue	


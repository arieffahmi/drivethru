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
class EmptyListException extends RuntimeException
 {
   	public EmptyListException( String name )
  	{
      		super( "The " + name + " is empty" );
   	}
}


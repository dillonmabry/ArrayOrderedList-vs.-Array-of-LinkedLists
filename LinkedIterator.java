/* Dillon Mabry
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3itcs2214mabrydillon;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 *@author Dillon Mabry Lewis/Chase
 */
public class LinkedIterator<T> implements Iterator
    {
       private int count;  // the number of elements in the collection
       private LinearNode<T> current;  // the current position
    
       //-------------------------------------------------------------
       //  Sets up this iterator using the specified items.
       //-------------------------------------------------------------
       public LinkedIterator (LinearNode<T> collection, int size)
       {
          current = collection;
          count = size;
       }
    
       //-------------------------------------------------------------
       //  Returns true if this iterator has at least one more element
       //  to deliver in the iteraion.
       //-------------------------------------------------------------
       public boolean hasNext()
       {
          return (current!= null);
          
       }
    
       //-------------------------------------------------------------
       //  Returns the next element in the iteration. If there are no
       //  more elements in this itertion, a NoSuchElementException is
       //  thrown.
       //-------------------------------------------------------------
       public T next()
       {
          if (! hasNext())
             throw new NoSuchElementException();
    
          T result = current.getElement();
          current = current.getNext();
          return result;
       }
    
       //-------------------------------------------------------------
       //  The remove operation is not supported.
       //-------------------------------------------------------------
       public void remove() throws UnsupportedOperationException
       {
          throw new UnsupportedOperationException();
       }
    }

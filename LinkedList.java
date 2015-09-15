/* Dillon Mabry
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3itcs2214mabrydillon;

import java.util.Iterator;

/**
 *
 *@author Dillon Mabry Lewis/Chase
 */
public class LinkedList<T> implements ListADT<T>
{

   protected int count;
   protected LinearNode<T> head, tail;

   //===========================================================
   //  Creates an empty list.
   //===========================================================
   public LinkedList() 
   {
      count = 0;
      head = tail = null;
   }  // constructor List

   //===========================================================
   //  Removes the first element in the list and returns a reference
   //  to it.  Throws an EmptyListException if the list is empty.
   //===========================================================
   public T removeFirst() throws EmptyListException
   {
       if(count == 0) throw new EmptyCollectionException("In removing first element");
       T result = head.getElement();
       head = head.getNext();
       count--;
       if(count == 0)
           tail = null;
       return result;
   } // method removeFirst
   
   //===========================================================
   //  Removes the last element in the list and returns a reference
   //  to it.  Throws an EmptyListException if the list is empty.
   //===========================================================
   public T removeLast() throws EmptyCollectionException 
   {
       if(count == 0) throw new EmptyCollectionException("In removing last element");
       T result = tail.getElement();
       LinearNode<T> current = head;
       while(current.getNext() != tail)
       {
           current = current.getNext();
        }
        tail = current;
        current.setNext(null);
        count--;
        return result;

   } // method removeLast
   
   //===========================================================
   //  Removes the first instance of the specified element from the
   //  list if it is found in the list and returns a reference to it.
   //  Throws an EmptyListException if the list is empty.  Throws a
   //  NoSuchElementException if the specified element is not found
   //  on the list.
   //===========================================================
   public T remove (T targetElement) throws
   EmptyCollectionException, ElementNotFoundException 
   {

      if (count == 0)
         throw new EmptyCollectionException ("Trying to remove from an empty List");

      boolean found = false;

      LinearNode<T> previous = null;
      LinearNode<T> current = head;

      while (current != null && !found) 
         if (targetElement.equals (current.getElement()))
            found = true;
         else {
            previous = current;
            current = current.getNext();
         }

      if (!found)
         throw new ElementNotFoundException ("In removing a target element");

      if (count == 1)
         head = tail = null;
      else if (current.equals (head)) 
              head = current.getNext();
      else if (current.equals (tail)) 
        {
           tail = previous;
           tail.setNext(null);
        } 
      else 
           previous.setNext(current.getNext());

      count--;

      return current.getElement();

   }  // method remove
   
   //===========================================================
   //  Finds the first instance of the specified element from the
   //  list if it is found in the list and returns true. 
   //  Returns false otherwise                                     
   //===========================================================
   public boolean contains (T targetElement) 
   {
      boolean found = false;

     
      LinearNode<T> current = head;

      while (current != null && !found) 
         if (targetElement.equals (current.getElement()))
            found = true;
         else 
         {
          
            current = current.getNext();
         }
         
         return found;


   }  // method contains 
   
 
   //===========================================================
   //  Returns true if the list is empty and false otherwise
   //===========================================================
   public boolean isEmpty() 
   {
     return (count == 0);
   }
    

   //===========================================================
   //  Returns the number of elements in the list.
   //===========================================================
   public int size() 
   {
       return count;
    }  // method size



   //===========================================================
   //  Returns a string representation of the list.
   //===========================================================
   public String toString() 
   {
    String result = "";
    LinearNode<T> current = head;
    while(current != null)
    {
        result += current.getElement()+ "\n";
        current = current.getNext();
    }
    return result;
} // method toString

   //===========================================================
   //  Returns ... 
   //===========================================================
   public Iterator<T> iterator()
   {
      return new LinkedIterator(head,count); 


    }  // method elements

   //===========================================================
   //  Returns the first element of the list. 
   //===========================================================
   public T first() throws EmptyListException
   {
       if(count == 0) throw new EmptyListException("In first");
       return head.getElement();
   }  // method firstElement

   //===========================================================
   //  Returns the last element of the list. 
   //===========================================================
   public T last() 
   {

   if(count == 0) 
      throw new EmptyCollectionException("Trying to examine last");
  
     return tail.getElement();
   }  // class LinkedList
}

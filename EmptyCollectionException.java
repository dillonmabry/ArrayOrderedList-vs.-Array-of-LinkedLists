/* Dillon Mabry
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3itcs2214mabrydillon;

/**
 *
 *@author Dillon Mabry Lewis/Chase
 */
public class EmptyCollectionException extends RuntimeException
{
  /**
   * Sets up this exception with an appropriate message.
   * @param collection String representing the name of the collection
   */
  public EmptyCollectionException (String collection)
  {
    super ("The " + collection + " is empty.");
  }
}

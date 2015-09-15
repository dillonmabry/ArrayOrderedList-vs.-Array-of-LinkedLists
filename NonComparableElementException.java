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
public class NonComparableElementException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     * 
     * @param collection  the exception message to deliver
     */
    public NonComparableElementException (String collection)
    {
        super ("The " + collection + " requires comparable elements.");
    }
}

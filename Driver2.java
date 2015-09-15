/* Dillon Mabry
 * This driver is to test the effectiveness of the Array of Linked Lists of
 sorting a mass data text file of many words and calculate it's run-time. The array will
 contain 26 different linked lists, each for each letter of the alphabet to increase efficiency
 of sorting
 */
package assignment3itcs2214mabrydillon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.*;

/**
 *
 * @author Dillon Mabry
 */
public class Driver2 {

    /* Create an array of OrderedLinkedLists to hold 26 lists for each letter
     of the alphabet */
    public static OrderedLinkedList[] myArray = new OrderedLinkedList[26];

    /**
     * Main method
     *
     * @param args unused
     * @throws FileNotFoundException if file is not found
     * @throws IOException if input/output error occurs
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        /* Loops and creates a new linkedlist for each index in the array
         of OrderedLinkedLists for each letter to sort by */
        for (int index = 0; index < myArray.length; index++) {
            myArray[index] = new OrderedLinkedList();
        }

        readFile();
    }

    /**
     * Method to read the file that is selected, add each input word into the
     * array of OrderedLinkedLists and print them out calculating the time of
     * execution
     *
     * @throws FileNotFoundException if file is not found
     * @throws IOException if an input/output error occurs
     */
    public static void readFile() throws FileNotFoundException, IOException {
        try {
            /* User input for picking file */
            System.out.println("Pick file:");
            String filename = pickFile().toString();
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            String line = null;
            /* Calculate the start time of execution */
            long startTime = System.nanoTime();
            /* While each line is not null add the word to the array
             of OrderedLinkedLists sorted alphabetically */
            while ((line = br2.readLine()) != null && line.length() > 0) {
                int subscript = ((line.toUpperCase()).charAt(0)) - 'A';
                myArray[subscript].add(line.toUpperCase());
            }
            /* Print out the list */
            printArray();
            /* Calculate end time and merge to milliseconds */
            long endTime = System.nanoTime();
            long durationNano = ((endTime - startTime));
            double durationSecond = ((endTime - startTime) / 1000000);
            System.out.println("");
            System.out.println("The Array of LinkedLists method execution took "
                    + durationNano + " nanoseconds" + "\nor about " + durationSecond
                    + " milliseconds");
            /* Catch any file not found exception */
        } catch (FileNotFoundException e) {
            System.out.println("File is not found exiting");
            System.exit(0);
        }

    }

    /**
     * Method to print the array of OrderedLinkedLists
     */
    public static void printArray() {

        /* Uses the printList method to print each list on each index */
        for (int index = 0; index < myArray.length; index++) {
            printList(myArray[index]);
        }
    }

    /**
     * Method to print each list on each index of the array of
     * OrderedLinkedLists
     *
     * @param list the OrderedLinkedList to print
     */
    public static void printList(OrderedLinkedList list) {

        /* Uses iterator to go through each element and print
         each element one by one */
        Iterator it;
        it = list.iterator();
        String item;
        while (it.hasNext()) {
            item = (String) (it.next());
            System.out.println(item);
        }
    }

    /**
     * Method to pick a file from a given input
     *
     * @return the File to be used
     * @throws FileNotFoundException if file is not found
     */
    public static File pickFile() throws FileNotFoundException {

        /* creates new JFileChooser and approves the file through 
         scanner input */
        JFileChooser chooser1 = new JFileChooser();
        java.io.File thisFile = null;
        if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            thisFile = chooser1.getSelectedFile();
            Scanner sc1 = new Scanner(thisFile);
        } else {
            System.out.println("No file selected");
        }
        return thisFile;
    }
}

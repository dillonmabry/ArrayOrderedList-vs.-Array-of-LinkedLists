/* Dillon Mabry
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3itcs2214mabrydillon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Dillon Mabry
 */
public class Driver1 {

    /* creates an ArrayOrderedList based on String type */
    private static ArrayOrderedList<String> arrayList = new ArrayOrderedList<>();

    /**
     * Main Method
     *
     * @param args unused
     * @throws java.io.FileNotFoundException if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        readFile();

    }

    /**
     * Method to read the file that is given and add each input word to the
     * ArrayOrderedList to be printed out
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
            /* While each line is not null add the word to the list */
            while ((line = br2.readLine()) != null) {
                arrayList.add(line.toUpperCase());
            }
            /* Print out the list */
            arrayList.toString();
            /* Calculate end time and merge to milliseconds */
            long endTime = System.nanoTime();
            long durationNano = ((endTime - startTime));
            double durationSecond = ((endTime - startTime) / 1000000);
            System.out.println("");
            System.out.println("The ArrayOrderedList method execution took "
                    + durationNano + " nanoseconds" + "\nor about " + durationSecond
                    + " milliseconds");
            /* Catch any file not found exception */
        } catch (FileNotFoundException e) {
            System.out.println("File is not found exiting");
            System.exit(0);
        }

    }

    /**
     * Method to pick a file from a given input
     *
     * @return the File to be used
     * @throws FileNotFoundException if file is not found
     */
    public static File pickFile() throws FileNotFoundException {
        /* Creates new JFileChooser to be used based on user input */
        JFileChooser chooser1 = new JFileChooser();
        java.io.File thisFile = null;
        /* Approve file selection and pass through scanner */
        if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            thisFile = chooser1.getSelectedFile();
            Scanner sc1 = new Scanner(thisFile);
        } else {
            System.out.println("No file selected");
        }
        return thisFile;
    }

}

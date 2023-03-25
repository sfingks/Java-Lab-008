/**
 * @author Trevor Hartman
 * @author MK Ripley
 * @since Version 1.0
 * 3/24/2023
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       /** Scanner file = new Scanner(System.in); // read in a string from System.in,
        String input;
        System.out.println("Enter file path: ");
        input = file.nextLine();
        Path thePath = Paths.get(input);  // convert that string into A Path type using Paths class,
        getHiddenSecrets(thePath.toFile()); // and call the getHiddenSecrets method to get the file's meta-data
        System.out.println();
        */ //assignment 003 for reference



        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        Scanner s = new Scanner(System.in);
        // Create a scanner object
        boolean skipWs = false;
        File endPath = null; //the IDE made me initialize the variable like this i'm not sure why? at least my code runs now
        while(true){
            System.out.println("Please enter file name and extension (enter q to quit):");
            String input = s.nextLine();
            if (input.equalsIgnoreCase("q")){
                break;
            }
            Path thePath = Paths.get("resources", input);
            System.out.println(thePath.toAbsolutePath());
            endPath = thePath.toFile();

            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

            // Ask the user if they would like to skip whitespace

            System.out.println("Would you like to skip whitespace? (enter y for yes, n for no)");
            String wsAnswer = s.nextLine();
            if (wsAnswer.equalsIgnoreCase("y")){
                skipWs = true;
                break;
            }
            else {
                skipWs = false;
                break;
            }
        }

            // Create a variable called skipWs that stores the user's response as a boolean

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats theFile = new FileStats(endPath, skipWs);
                theFile.read();
                int lines = theFile.getNumLines();
                int words = theFile.getNumWords();
                int chars = theFile.getNumChars();
                String fileName = theFile.getFileName();

                System.out.printf("lines - %d, words - %d, chars - %d %s\n", lines, words, chars, fileName);// You will need to call the fs.read method, which you need to implement!

                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

    }
}

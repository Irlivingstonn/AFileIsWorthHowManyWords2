// Name: Isabella Livingston
// Date:
// Description:

// Importing Assets
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File new_file = writeText("asdf", "hello world");

    }
    public static File writeText(String filename, String s){

        // Tries to Create and Write to File
        try{
            // Declaring File
            File new_file = new File(filename + ".txt");

            // Checks to make sure if the file exists
            if(!new_file.exists()){
                new_file.createNewFile();
            }

            // Declaring PrintWriter
            PrintWriter printWriter = new PrintWriter(new_file);

            // Printing the String into the File
            printWriter.println(s);

        }

        // If it can't create file, then it returns an error
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return new_file;
    }




}
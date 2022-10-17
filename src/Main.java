// Name: Isabella Livingston
// Date: 16 October 2022
// Description: User Enters in the File Name and Content
//              The Program prints the name and number of words in file

// Importing Assets
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

// Main Project
public class Main {

    // Getting File Input Function
    public static String getting_file_name(String prompt, Scanner scanner){

        // Prompts User and Gets Input
        System.out.print(prompt);
        String file_name = scanner.nextLine();

        // Gets Rid of ".txt" if user inputs it
        if ((file_name).endsWith(".txt")){
            return file_name.substring(0, file_name.length() - 4);
        }
        else{
            return file_name;
        }

    }

    // Getting File Content Function
    public static String getting_file_content(String prompt, Scanner scanner){

        // Prompts User
        System.out.print(prompt);

        // Returns Input
        return scanner.nextLine();

    }

    // Write Text Function
    public static File writeText(String filename, String s){
        // Declares File
        File new_file = new File(filename + ".txt");


        // Tries to Create and Write to File
        try{
            // Declaring File
            new_file = new File(filename + ".txt");

            // Checks to make sure if the file exists
            if(!new_file.exists()){
                new_file.createNewFile();
            }

            // Declaring PrintWriter
            PrintWriter printWriter = new PrintWriter(new_file);

            // Printing the String into the File
            printWriter.println(s);

            // Stops Writing to File
            printWriter.close();


        }

        // If it can't create file, then it returns an error
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Returns File
        return new_file;
    }

    // Count Words Function
    public static int countWords(File f){
        // Declaring Word Accumulator
        Integer word_accumulator = 0;

        // Checks to see if it can read the file
        try(FileReader fileReader = new FileReader(f)){

            // Declares Buffer Reader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Declares List of Words in the Content of the File
            String[] split_string = (bufferedReader.readLine()).split("\\s+");

            // Counts amount of words in file
            for(Integer word = 0; word < split_string.length; word++){
                word_accumulator += 1;
            }

        }

        // Raises Error if something's wrong
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Returns Word Accumulator
        return word_accumulator;


    }

    // Displaying Output Function
    public static void displaying_output(File new_file, Integer words_in_file){
        System.out.println(new_file + " contains " + words_in_file + " words.");
    }

    // Main Function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // -------------- INPUT --------------
        String name_of_file = getting_file_name("What is the name of the file? ", scanner);
        String content_in_file = getting_file_content("What would you like to print to the file? ", scanner);

        // -------------- PROCESSING --------------
        File new_file = writeText(name_of_file, content_in_file);
        Integer words_in_file = countWords(new_file);

        // -------------- OUTPUT --------------
        displaying_output(new_file, words_in_file);

    }


}
/*
 *Usman Farooqi
 * Dictionary.java
 * This program takes in an argument from the user then checks if the words from the argument are correct by comparing with a dictionary text file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Dictionary {
    public static void main(String [] args) throws IOException {
        Scanner fin = new Scanner(new BufferedReader(new FileReader("dictionary.txt"))); // reading file
        Hashtable<String,Integer> dictionary = new Hashtable<>(); // hashtable with all the words
        String line = "";
        while (fin.hasNextLine()){
            line = fin.nextLine();
            dictionary.put(line,line.hashCode());
        }
        for(String let : args){ // checks for the wrds in args (given argument)
            if(dictionary.get(let)!=null){ // if the word is spelt correctly and not null
                System.out.println("True"); // return true;
            }
            else{
                System.out.println("False"); // return false
            }
        }
    }
}

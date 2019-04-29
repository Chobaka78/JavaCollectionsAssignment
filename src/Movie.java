/*
 *Usman Farooqi
 * Movie.java
 * This program takes in a file that contains a list of students (first, last name) and movie they watched
 * it then outputs a file with the movie, all the students who are watching that movie with their names
 * in alphabetical order
 */
import java.io.*;
import java.util.*;

public class Movie {
    public static void main(String[] args) throws IOException {
        HashMap<String, LinkedList<String>> hash = new HashMap<>(); // make a hashmap that will take movie name, linked list of student name
        String[] file;
        String firstname;
        String lastname;
        String movie;
        Scanner fin = new Scanner(new BufferedReader(new FileReader("picks.txt"))); // reading file
        while (fin.hasNextLine()) {
            file = fin.nextLine().split(",");
            firstname = file[0];
            lastname = file[1];
            movie = file[2];

            LinkedList<String> students; // making linked list
            students =(hash.containsKey(movie)? hash.get(movie) : new LinkedList<String>()); // tmp linked list which will be edited to order
            students.add(lastname + ", " + firstname);
            Collections.sort(students); // orderd the collection in the format of last name then first name
            hash.put(movie, students); // adds to hashmap
        }
        System.out.println(hash);

        BufferedWriter writer = new BufferedWriter(new FileWriter("Tree.txt")); // this writes to the file
        for (HashMap.Entry<String, LinkedList<String>> entry : hash.entrySet()) { // go through the hashmap
            for(String i : entry.getValue()){
                writer.append(entry.getKey() + ":" + i + "\n"); // adds the title of movie and the students who have that movie
            }
        }
        writer.close();
    }
}
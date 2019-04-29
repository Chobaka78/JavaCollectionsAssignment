/*
 *Usman Farooqi
 * Cars.java
 * This program takes in a file with number of cars followed by licence plate, offences, time date
 * it then gives options to check a certain plates offences, add an offence or exit
 * based on the choice the file is updated
 * I COULD NOT FINISH THIS QUESTION
 */
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Cars {
    public static void main(String [] args) throws IOException {
        HashMap<String , LinkedList<String>> map = new HashMap<>();
        Scanner fin = new Scanner(new BufferedReader(new FileReader("cars.txt"))); // reading file
        Scanner kb = new Scanner(System.in);
        int total_cars = Integer.parseInt(fin.nextLine()); // get num of cars
        System.out.println(total_cars);
        for(int i = 0; i < total_cars; i ++){ // check for each car
            String plate = fin.nextLine(); // gets plate nums
            String offence = fin.nextLine(); // gets offence nums
            map.put(plate,new LinkedList<String>()); //  make linked list to store offence
            map.get(plate).add(offence);
            for(int k = 0; k < Integer.parseInt(offence); k ++){ // run through offence
                map.get(plate).add(fin.nextLine() +"\n" + fin.nextLine()); // add to map
            }
        }
        System.out.println(map);
        int choice = 0;
        while (choice != 3){ // while user doenst choose exit
            System.out.println("Enter: 1. Show all offences. 2. Add offence. 3.Exit");
            choice = kb.nextInt();
            if(choice == 1){ // if first choice
                System.out.println("Enter plate #: ");
                String p = kb.nextLine(); // enter the plate num
                if(!map.containsKey(p)){ // if plate entered is not already one of the plates
                    System.out.println("Invalid plate number");
                }
                else{
                    System.out.println(map.get(p)); // if it is show all offence
                }
            }
            if(choice == 2){ // if choice is 2
                System.out.println("Enter plate #");
                String p = kb.nextLine(); // enter plate num
                if(!map.containsKey(p)){ // if plate is not in the list
                    total_cars += 1; // add new car plate
                    map.put(p, new LinkedList<String>()); // new tmp linked list
                    System.out.println("Enter Date and Time");
                    String date = kb.nextLine(); // enter date and time
                    map.get(p).add("1");
                    map.get(p).add(date); // add to list
                    System.out.println("Enter initials"); // enter initials
                    String initials = kb.nextLine();
                    map.get(p).set(1, map.get(p).get(1) + "\n" + initials); // add to map
                }
                else { // plate entered is in the list
                    int n = Integer.parseInt(map.get(p).get(0)) + 1;
                    map.get(p).set(0, "" + n);
                    System.out.println("Enter date and time");
                    String date = kb.nextLine(); // enter date time
                    map.get(p).add(date); // add to list
                    System.out.println("Enter initials"); // enter initials
                    String initials = kb.nextLine();
                    map.get(p).set(n, map.get(p).get(n) + "\n" + initials); // add to map

                }
            }
        }
        System.out.println(map);
    }
}

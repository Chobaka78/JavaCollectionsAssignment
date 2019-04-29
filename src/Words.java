/*
*Usman Farooqi
* Words.java
* This program takes a file name and outputs all the words and the percentage of each word in the file
 */

import java.util.*;
import java.io.*;

public class Words {
    public static void main(String [] args) throws IOException{
        Scanner kb = new Scanner(System.in); // ask user for file name
        System.out.println("Enter file name");
        String File = kb.next() + ".txt";
        Scanner fin = new Scanner(new BufferedReader(new FileReader(File))); // reading file
        ArrayList<String> words = new ArrayList<>(); // array list to store the words from the file
        String letters = "";
        while (fin.hasNextLine()){ // as long as there is a next line
            letters = fin.nextLine();
            String [] split = letters.split(" "); // split when ever there is a space
            for(String w : split){
                words.add(w); // add words to array list
            }
        }

        Map<String,Integer>freq = new HashMap<>(); // make a hashmap
        for(String wrd : words) { // find frequencies
            if(!freq.containsKey(wrd)) {
                freq.put(wrd, 1);
            }
            else{
                int n = freq.get(wrd);
                freq.put(wrd,n + 1);
            }
        }
        System.out.println(freq);
        TreeSet<Word> tree = new TreeSet<>(); // convert hashmap to treeset for sroting
        for ( String key : freq.keySet() ) {
            tree.add(new Word(key,freq.get(key)));
        }
        System.out.println(tree);
    }

    public static class Word implements Comparable<Word> { // compare
        String word;
        double percent;

        public Word(String word, double percent) {
            this.word = word;
            this.percent = percent;
        }

        public String toString() { // returns string of the word and its percentage
            return word + ": " + percent;
        }

        public int compareTo(Word w) {
            if (percent == w.percent) {
                return word.compareTo(w.word);
            } else {
                return (int)((w.percent - percent) * 100);
            }
        }
    }
}

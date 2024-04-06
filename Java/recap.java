import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
public class recap {
    public static void main (String[] args) {

        //ArrayList<String> strings = new ArrayList<>(List.of("Huu","Haa","Huhuu","Hohoo"));
        //ArrayList<Integer> list1 = new ArrayList<>(List.of(1,2,3));
        //ArrayList<Integer> list2 = new ArrayList<>(List.of(3,4,5,6));
        //System.out.println(doubles(list1, list2));
        letterPyramid();
    }

    public static void countPositivesNegatives(){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        while (true) {
            System.out.print("Give a number: "); // needs to be inside the loop
            int number = Integer.valueOf(input.nextLine()); // never use the input.nextInt(), doesn't work in ville
            if (number == 0) {
                break;
            }
            if (number < 0) {
                negatives.add(number);
            } else {
                positives.add(number);
            }
        }
        System.out.println("Positives: " + positives.size());
        System.out.println("Negatives: " + negatives.size());
    }
    public static void powersOfTwo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Give the upper limit: ");
        int limit = Integer.valueOf(input.nextLine());
        for (int i=0; Math.pow(2, i) < limit; i++) {
            System.out.println( (int) Math.pow(2, i) );
        }
    }
    public static int countShorter(ArrayList<String> strings, int length) {
        return (int) strings.stream().filter(str -> str.length() < length).count();
    }
    public static int doubles(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> longer = (list1.size() >= list2.size() ? list1 : list2);
        ArrayList<Integer> shorter = (list1.size() >= list2.size() ? list2 : list1);
        int counter = 0;
        for (int i : longer) {
            if (shorter.contains(i)) {
                counter++;
            }
        }
        return counter;
    }
    public static String clean(String word) {
        return word.replaceAll("[^a-zA-Z ]", "");
        //The regular expression [^a-zA-Z ] matches any character that is not a letter (either uppercase or lowercase) or a space.
    }
    public static void letterPyramid() {
        Scanner input = new Scanner(System.in);
        System.out.print("Give a lowercase letter: ");
        char letter = input.nextLine().charAt(0);
        int n = letter - 'a' + 1; //(char) a = (int) 97, b=98; finds the position in the alphabet
        //System.out.println(n);
        for (int i=0; i < n; i++) {
            // print spaces
            for (int j = 0; j < (n - i - 1); j++) { // print n-1 spaces, -i for one less for each row
                System.out.print(" ");
            }
            // Print characters in decreasing order
            for (int j = i; j >= 0; j--) {
                System.out.print((char) ('a' + j));
            }
            // Print characters in increasing order
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('a' + j));
            }
            System.out.println();
        }
    }
}


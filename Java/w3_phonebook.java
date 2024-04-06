import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class w3_phonebook {
    public static void main(String[] args) {
        start();
    }
    public static void addNumber(HashMap<String,String> numbers) {
        Scanner input = new Scanner(System.in);
        System.out.print("Name:");
        String name = input.nextLine();
        System.out.print("Number:");
        String number = input.nextLine();
        numbers.put(name,number);
    }
    public static void findNumber(HashMap<String,String> numbers) {
        Scanner input = new Scanner(System.in);
        System.out.print("Name:");
        String name = input.nextLine();
        if (!numbers.containsKey(name)) {
            System.out.println("Name not found");
        } else {
            System.out.println("Number: " + numbers.get(name));
        }
    }
    public static void listBook(HashMap<String,String> numbers) {
        ArrayList<String> sortedNames = new ArrayList<>(numbers.keySet());
        Collections.sort(sortedNames);

        for (String name : sortedNames) {
            String number = numbers.get(name);
            System.out.println("Name: " + name + ", number: " + number);
        }
    }
    public static void start() {
        HashMap<String, String> numbers = new HashMap<>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add number\n" +
                    "2. Find number\n" +
                    "3. List numbers\n" +
                    "0. Exit");
            System.out.print("Option: ");
            int selection = Integer.valueOf(input.nextLine());
            if (selection == 1) {
                addNumber(numbers);
                System.out.println();
            } else if (selection == 2) {
                findNumber(numbers);
                System.out.println();
            } else if (selection == 3) {
                listBook(numbers);
                System.out.println();
            } else if (selection == 0) {
                break;
            }
        }
    }

    public static void startChatGPT() {
        HashMap<String, String> numbers = new HashMap<>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add number\n" +
                    "2. Find number\n" +
                    "3. List numbers\n" +
                    "0. Exit");
            System.out.print("Option: ");
            int selection = input.nextInt();  // Use input.nextInt() for reading an integer
            input.nextLine();  // Consume the newline character after reading the integer

            switch (selection) {
                case 1:
                    addNumber(numbers);
                    System.out.println();
                    break;
                case 2:
                    findNumber(numbers);
                    System.out.println();
                    break;
                case 3:
                    listBook(numbers);
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please enter a valid option.\n");
            }
        }
    }
}
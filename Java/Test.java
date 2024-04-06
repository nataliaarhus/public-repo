import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
//Lists, arrays, hashmap, files, exceptions

public class Test {
    public static void main(String[] args) {
//        int result = calculate(2,3,"+");
//        System.out.println("Result: " + result);

//        giveNames();

//        ArrayList<Integer> list = createList(15,5);
//        System.out.println("List before: " + list);
//        int result = secondSmallest(list);
//        System.out.println(result);
//        System.out.println("List after: " + list);

//        int[] array = {1,2,3,4};
//        int sum = sum(array);
//        System.out.println("Sum: " + sum);

        ArrayList<Integer> list = createList(1,5);
        System.out.println(list);

//        ArrayList<String> names = new ArrayList<>();
//        ArrayList<Integer> grades = new ArrayList<>();
//        names.add("Axel");
//        names.add("Ann");
//        grades.add(9);
//        grades.add(8);
//        HashMap<String, Integer> hm = combine(names, grades);
//        System.out.println(hm);

//        ArrayList<String> list = readPlayers();
//        System.out.println(list);

    }

    public static int calculate(int num1, int num2, String operator) {
        int result=0;
        if (operator.equals("+")) {result = num1+num2;}
        else if (operator.equals("-")) {result = num1-num2;}
        else if (operator.equals("*")) {result = num1*num2;}
        else if (operator.equals("/")) {result = num1/num2;}
        return result;
    }

    public static void giveNames(){
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        while (true) {
            System.out.print("Give a name: ");
            String name = input.nextLine();
            if (name.equals("quit")) {
                break;
            }
            if (names.contains(name)) {
                System.out.println("Name has already been given");
                continue;
            }
            names.add(name);
        }
        System.out.println(names);
    }

    // The point here is that even though it doesn't return anything, it changes the underlying object which is referenced
    public static void removeNegatives(ArrayList<Integer> numbers) {
        for (int i=numbers.size()-1; i>=0; i--) {
            if (numbers.get(i)<0) {
                numbers.remove(i);
            }
        }
    }

    static int secondSmallest(ArrayList<Integer> numbers) {
    // Create a copy of the original list to avoid modifying the input list
    ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
    Collections.sort(sortedNumbers);
    int secondSmallest = sortedNumbers.get(1);
    return secondSmallest;
    }

    public static ArrayList<Integer> createList(int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        int step = (start <= end) ? 1 : -1; // Check if the list needs to be created backwards
        for (int i = start; i != end; i += step) {
            list.add(i);
        }
        return list;
    }

    public static int sum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static double[] newArray(ArrayList<Double> list) {
        double[] arr = new double[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static HashMap<String, Integer> combine(ArrayList<String> names, ArrayList<Integer> grades) {
        HashMap<String, Integer> heights = new HashMap<>();
        for (int i=0; i<names.size(); i++){
            heights.put(names.get(i), grades.get(i));
        }
        return heights;
    }

    public static String coldestCity(HashMap<String, Double> temps) {
        String coldest = temps.keySet().stream().sorted().findFirst().get();
        double lowest = temps.get(coldest);
        for (String key : temps.keySet()) {
            if (temps.get(key) < lowest) {
                lowest = temps.get(key); //update to new lowest
                coldest = key;
            }
        }
        return coldest;
    }

    public static StringBuilder square(int sideLength){
        StringBuilder str = new StringBuilder();
        for (int j=1; j<=sideLength; j++){
            for (int i=1; i<=sideLength; i++){
                str.append("*");
            }
            str.append("\n");
        }
        return str;
    }

    public static ArrayList<String> readPlayers() {
        ArrayList<String> list = new ArrayList<>();
        File file = new File("players.txt");
        try(Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("An error happened!");
        }
        return list;
    }

    public static ArrayList<Integer> allValues() {
        File file = new File("numbers.csv");
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] chunks = row.split(",");
                for (String chunk : chunks) {
                    list.add(Integer.valueOf(chunk));
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    public static void inputException(){
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            try {
                System.out.print("Give a number: ");
                int num = Integer.valueOf(reader.nextLine());
                if (num == -1) {
                    break;
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(numbers);
    }

}
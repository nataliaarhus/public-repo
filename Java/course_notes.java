import java.util.Random;
import java.util.Scanner;

public class course_notes {

    public static void main(String[] args) {

        //Printing output in Java:
//        final Random r = new Random();
//        System.out.print("Java-programming");
//        System.out.println("easy.");

        //Variables:
//        int first = 23;
//        int second = 10;
//        int multiply = first * second;
//        int sum = first + second;
//        int largeNum = (first + second) * 100;
//        System.out.println(multiply);
//        System.out.println(sum);
//        System.out.println(largeNum);

        //Reading user's input - Scanner class
//        System.out.print("Input your name:");
//        Scanner reader = new Scanner(System.in);
//        String name = reader.nextLine();
//        System.out.println("Greetings, " + name);

//        Scanner input = new Scanner(System.in);
//        System.out.print("Give the number of days:");
//        int days = Integer.valueOf(input.nextLine());
//        int minutes = days * 24 * 60;
//        System.out.println(days + " days contain " + minutes + " minutes.");

        //Conditional logic:
//        Scanner input = new Scanner(System.in);
//        System.out.print("Give a number:");
//        int num = Integer.valueOf(input.nextLine());
//        String typen = (num % 2 == 0) ? "even" : "odd";
//        System.out.println("Number " + num + " is " + typen);

//        Scanner input = new Scanner(System.in);
//        System.out.print("Workdays: ");
//        int days = Integer.valueOf(input.nextLine());
//        System.out.print("Daily salary: ");
//        double wage = Double.valueOf(input.nextLine());
//        double salary = (days > 10) ? days * wage * 1.5 : (days > 5) ? days * wage * 1.2 : days * wage;
//        System.out.println("Total salary: " + salary);

//        While loops:
//        Scanner input = new Scanner(System.in);
//        int sum = 0;
//        int maxn = 0;
//        while (true) {
//            System.out.print("Give a number: ");
//            int num = Integer.valueOf(input.nextLine());
//
//            if (num == -1) {
//                break;
//            }
//
//            sum = sum + num;
//            maxn = (num > maxn) ? num : maxn;
//        }
//        System.out.println("Sum: " + sum);
//        System.out.println("Maximum: " + maxn);

//        For loops:
//        for (int i=1; i<=10; i++) {
//            System.out.println(i);
//        }

//        To repeat a string multiple times:
//        System.out.println(str.repeat(amount));

    }

    public static void printMiddle(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        System.out.println(array[1]);
    }

    public static int middle(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        return array[1];
    }

    public static int factorial(int number) {
        int factorial = 1;
        for (; number>0 ; number-- ) {
            factorial = factorial * number;
        }
        return factorial;
    }

    public static boolean isLeapYear(int year) {
        if ( (year % 4 == 0 && year % 100 != 0) ||  (year % 4 == 0 && year % 100 == 0  && year % 400 == 0) ) {
            return true;
        } else {
            return false;
        }
    }

    public static void leapYears() {
        Scanner input = new Scanner (System.in);
        System.out.print("Give start:");
        int year_start = Integer.valueOf(input.nextLine());
        System.out.print("Give end:");
        int year_end = Integer.valueOf(input.nextLine());

        while (year_start <= year_end) {
            if (isLeapYear(year_start) == true) {
                System.out.println(year_start + " is a leap year");
            }
            year_start = year_start+1;
        }
    }

    public static char middleChar(String str) {
        if (str.length() % 2 != 0) {
            return str.charAt(str.length()/2); // division of 2 integers returns an integer (no decimals)
        } else {
            return '-';
        }
    }

    public static String endToStart(String word) {
        String reversed = "";
        for (int i=word.length()-1; i>=0; i--) {
            reversed = reversed + "" + word.charAt(i);
        }
        return reversed;
    }

    public static void triangle() {
        Scanner input = new Scanner (System.in);
        System.out.print("Give a string:");
        String str = input.nextLine();

        for (int i=0; i<=str.length()-1; i++){
            for (int j=0; j<=i; j++){
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }

    public static String fix(String rcard) {
        String[][] replacements = {{"four", "eight"},
                {"five", "nine"},
                {"six", "ten"}};
        String strOutput = rcard;
        for(String[] replacement: replacements) {
            strOutput = strOutput.replace(replacement[0], replacement[1]);
            // the result is placed back in the same var thats why it works despite being immutable
        }
        return strOutput;
    }

    public static String removeVowels(String word) {
        String[][] replacements = {{"a"}, {"e"}, {"i"}, {"o"}, {"u"}, {"y"}};
        String strOutput = word;
        for(String[] replacement: replacements) {
            if (strOutput.contains(replacement[0])) {
                strOutput = strOutput.replace(replacement[0], "");
            }
        }
        return strOutput;
    }

    //Create a list and loop
    Scanner reader = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();
    while (true) {
        System.out.print("Give a number: ");
        int num = Integer.valueOf(reader.nextLine());
        if (num == -1) {
            break;
        }
        numbers.add(num);
    }
    System.out.println(numbers);

    int positives = 0;
    int negatives = 0;
    for (int num : numbers) {
        if (num>0) {
            positives = positives+1;
        } else if (num<0) {
            negatives = negatives+1;
        }
    }
    System.out.println("Positives: " + positives);
    System.out.println("Negatives: " + negatives);

}



import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
public class exam {
    public static void main (String[] args) {
        SecretMessage message = new SecretMessage("hello everyone");
        System.out.println(message.getEncrypted());
    }
    public static void mostFrequentNumber() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, Integer> occurances = new HashMap<>();
        while (true) {
            System.out.print("Enter a number: ");
            int num = Integer.valueOf(input.nextLine());
            if (num == -1) {
                break;
            }
            numbers.add(num);
        }
        int mostFrequent = -1;
        for (int num : numbers) {
            if (occurances.get(num) == null) {
                occurances.put(num, 1);
            } else {
                occurances.put(num, occurances.get(num)+1);
                mostFrequent = num;
                //Assuming only one is entered more than once
            }
        }
        System.out.println("Most frequent: " + mostFrequent);
    }
}

class CurrencyUnit {
    private String name;
    private double amount;
    public CurrencyUnit(String name, double amount) {
        setName(name);
        setValueInEuros(amount);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setValueInEuros(double amount) {
        this.amount = amount;
    }
    public String getName() {
        return this.name;
    }
    public double getValueInEuros() {
        return this.amount;
    }
    @Override
    public String toString() {
        return name + " (" + amount + ")";
        //Pound (0.2)
    }

}
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class ExamException extends Exception {
    public ExamException(String message) {
        super(message);
    }
}
interface Encryptor {
    String getEncrypted();
}
class SecretMessage implements Encryptor {
    private String message;
    public SecretMessage(String message) {
        this.message = message;
    }
    @Override
    public String getEncrypted() {
        String str = this.message;
        char[] arr = str.toCharArray();
        for (int i=0; i < arr.length; i++) {
            if (arr[i] != 'z' && arr[i] != ' ') {
                int next = arr[i]+1 ;
                arr[i] = (char) next;
            }
        }
        String encrypted = new String(arr);
        return encrypted;
    }
}
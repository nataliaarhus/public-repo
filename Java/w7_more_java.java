import java.util.ArrayList;
import java.util.stream.Collectors;
public class w7_more_java {
    public static ArrayList<Route> routesInDirection (ArrayList<Route> routes, CardinalDirection direction) {
        //Get all a list of routes in given direction
        ArrayList<Route> selected = new ArrayList<>();
        for (Route r : routes ) {
            if (r.getDirection() == direction) {
                selected.add(r) ;
            }
        }
        return selected;
    }
    public static void printNorthRoutes(ArrayList<Route> routes) {
        routes.stream().filter(rt -> rt.getDirection() == CardinalDirection.NORTH).forEach(rt -> System.out.println(rt.toString()));
    }

    public static ArrayList<String> sentencesWithPeriod(ArrayList<String> sentences) {
        return sentences.stream()
                .filter(sentence -> sentence.endsWith("."))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}

enum CardinalDirection {
    NORTH, SOUTH, EAST, WEST
}
enum IntermediateCardinalDirection {
    NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST
}
class Route {
    private double length;
    private CardinalDirection direction;
    public Route (double length, CardinalDirection direction) {
        setLength(length);
        setDirection(direction);
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getLength() {
        return this.length;
    }
    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }
    public CardinalDirection getDirection() {
        return this.direction;
    }

}
class Duplicator<T> {
    private T element;
    public Duplicator (T element) {
        this.element = element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public T getElement() {
        return this.element;
    }
    public ArrayList<T> getMany(int amount) {
        ArrayList<T> many = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            many.add(this.element);
        }
        return many;
    }
}

// Generic type definition
class Stack<T> {
    private ArrayList<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }
    // Always add to the start of the list
    public void add(T element) {
        elements.add(0, element);
    }
    // Likewise, always remove from the end of the list
    public T remove() {
        return elements.remove(elements.size() - 1);
    }

    public boolean hasElements() {
        return !elements.isEmpty();
    }
}

// extends to be able to use methods from that class
class MinMax <T extends Comparable<T>> {
    private ArrayList<T> elements;
    public MinMax(ArrayList<T> elements) {
        this.elements = elements;
    }
    public T smallest() {
        T min = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).compareTo(min) < 0) {
                min = elements.get(i);
            }
        }
        return min;
    }
    public T largest() {
        T max = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).compareTo(max) > 0) {
                max = elements.get(i);
            }
        }
        return max;
    }
}

//Streams
public class Test {
    Scanner reader = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();
    while(true) {
        System.out.print("Enter a number: ");
        int num = Integer.valueOf(reader.nextLine());
        if (num == -1) {
            break;
        }
        numbers.add(num);
    }
    System.out.println("Sum: "+numbers.stream().mapToInt(number ->number).sum());
    System.out.println("Average: "+numbers.stream().mapToInt(number ->number).average().getAsDouble());
    System.out.println("Minimum: "+numbers.stream().mapToInt(number ->number).min().getAsInt());
    System.out.println("Maximum: "+numbers.stream().mapToInt(number ->number).max().getAsInt());
}

public class test1 {
    Scanner reader = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<>();
    while(true) {
        System.out.print("Enter a name: ");
        String name = reader.nextLine();
        if (name == "stop") {
            break;
        }
        names.add(name);
    }
    try (PrintWriter file = new PrintWriter("names.txt")) {
        names.stream().forEach(line -> file.write(line + "\n"));
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred: " + e);
    }
}
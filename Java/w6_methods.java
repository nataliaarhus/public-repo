import java.util.ArrayList;

class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getDistance() {
        return Point.distanceFromOrigin(this);
    }
    public static double distanceFromOrigin(Point point) {
        return Math.sqrt(point.getX() * point.getX() +
                point.getY() * point.getY());
    }
}

class StringHelper {
    public static int countVowelsDistinct(String string) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        int counter = 0;
        for (String v : vowels) {
            if (string.contains(v) == true) {
                counter += 1;
            }
        }
        return counter;
    }
    public static int countVowels(String string) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u'};
        char[] arr = string.toCharArray();
        int counter = 0;
        for (char letter : arr) {
            for (char v : vowels) {
                if (letter == v) {
                    counter += 1;
                    break;
                }
            }
        }
        return counter;
    }
    public static  int countOthers(String string) {
        int vowels = StringHelper.countVowels(string);
        return string.length() - vowels;
    }
}

class SecretAgent {
    private String code;
    private String name;
    public SecretAgent (String name, String code) {
        this.name = name;
        setCode(code);
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        if (SecretAgent.codeOk(code) == true) {
            this.code = code;
        } else {
            this.code = "000";
        }
    }
    public static boolean codeOk(String code) {
        if (code.length() != 3) {
            return false;
        }
        if (code.charAt(0) != '0') {
            return false;
        }
        if (code.charAt(1) != '0') {
            return false;
        }
        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }
        return true;
    }
}


interface CalculatorInterface {
    void add(int a);
    void subtract(int a);
    void multiply(int a);
    void divide(int a);
    double getResult();
}
class Calculator implements CalculatorInterface {
    private double result;
    public Calculator() {
        this.result = 0.0;
    }
    @Override
    public void add(int a) {
        result += a;
    }
    @Override
    public void subtract(int a) {
        result -= a;
    }
    @Override
    public void multiply(int a) {
        result *= a;
    }
    @Override
    public void divide(int a) {
        if (a != 0) {
            result /= a;
        } else {
            System.err.println("Cannot divide by zero.");
        }
    }
    @Override
    public double getResult() {
        return result;
    }
}

class Test {
    public static Route longestRoute(ArrayList<Route> routes) {
        ArrayList<Route> sorted = new ArrayList<>(routes); // to avoid modifying underlying obj
        Collections.sort(sorted);
        return sorted.get(sorted.size() - 1);
    }
}
class Route implements Comparable<Route>{
    private String startPoint;
    private String endPoint;
    private int distance;

    public Route(String startPoint, String endPoint, int distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }
    @Override
    public int compareTo(Route other) {
        return this.distance - other.distance;
    }
    @Override
    public String toString() {
        return startPoint + " - " + endPoint + ": " + distance + " km.";
    }
    // Conversion double to int
//    @Override
//    public int compareTo(Point anotherPoint) {
//        double x = Point.distanceFromOrigin(this) - Point.distanceFromOrigin(anotherPoint);
//        int y = (int)x;
//        return y;
//    }
}


//Class comparison .getClass() or instanceof
public static int peopleOnShips(ArrayList<Ship> ships) {
    int count = 0 ;
    for (Ship sh : ships) {
        count += sh.getCrew();
        if (sh instanceof PassengerShip) {
            count += ((PassengerShip)sh).getPassengers();
        }
        if (sh instanceof LuxuryCruiser) {
            count += ((LuxuryCruiser)sh).getServants();
        }
    }
    return count;
}
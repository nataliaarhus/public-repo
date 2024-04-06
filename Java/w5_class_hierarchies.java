class Person {
    private String name;
    private String email;

    public Person (String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
class Student extends Person {
    // new attribute that the person does not have
    private int studypoints;

    public Student(String name, String email, int studypoints) {
        super(name, email);
        this.studypoints = studypoints;
    }
    public int getStudypoints() {
        return studypoints;
    }
    public void setStudypoints(int studypoints) {
        this.studypoints = studypoints;
    }
}


public static ArrayList<VideoCall> jamesCalls (ArrayList<VideoCall> calls) {
    ArrayList<VideoCall> onlyJames = new ArrayList<>();

    for (VideoCall vc : calls) {
        if ((vc.getPerson1() == "James Bond" || vc.getPerson2() == "James Bond") && vc.isVideoCall() == true) {
            onlyJames.add(vc);
        }
    }
    return onlyJames;
}
class Call {
    private String person1;
    private String person2;
    private int duration;

    public Call(String person1, String person2, int duration) {
        this.person1 = person1;
        this.person2 = person2;
        this.duration = duration;
    }
    public String getPerson1() {
        return person1;
    }
    public String getPerson2() {
        return person2;
    }
    public int getDuration() {
        return duration;
    }
}
class VideoCall extends Call {
    private boolean isVideoCall;

    public VideoCall(String person1, String person2, int duration, boolean isVideoCall) {
        super(person1, person2, duration);
        this.isVideoCall = isVideoCall;
    }
    public boolean isVideoCall() {
        return isVideoCall;
    }
    public String toString() {
        return getPerson1() + " - " + getPerson2() + ", " + getDuration() + " min., video: " +
                (isVideoCall ? "on" : "off");
    }
}

//Visibility level protected to access attributes in a child
class Point {
    protected int x;
    protected int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Modifiablepoint extends Point {
    public Modifiablepoint(int x, int y) {
        super(x, y);
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
}

//Calling parent class methods with super.method();
class ShoppingList {
    private ArrayList<String> products;
    public ShoppingList() {
        products = new ArrayList<>();
    }
    public void addProduct(String product) {
        products.add(product);
    }
    public String getList() {
        return String.join("\n", products);
    }
}
class OrganicShoppingList extends ShoppingList {
    public OrganicShoppingList () {
    }
    public String getList() {
        ArrayList<String> organic = new ArrayList<>();
        String products_str = super.getList();
        String[] products = products_str.split("\n");

        for (String str : products) {
            if (str.contains("organic") == true) {
                organic.add(str);
            }
        }
        return String.join("\n", organic);
    }
}

// Overriding methods
class Wallet {
    protected double money;
    public Wallet(double money) {
        this.money = money;
    }
    public void addMoney(double amount) {
        money += amount;
    }
    public double getMoney() {
        return money;
    }
}
class BetterWallet extends Wallet {
    public BetterWallet(double money) {
        super(money);
    }
    public void addMoney(int euros, int cents) {
        money += Double.valueOf(euros) + Double.valueOf(cents)/100;
    }
    public void addMoney(String amount) {
        money += Double.valueOf(amount);
    }
}

// Empty parent class constructors
class Connection {
    protected int speed;
    public Connection(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
}
class EncryptedConnection extends Connection {
    private String encryption;
    private String password;
    public EncryptedConnection (int speed, String encryption, String password) {
        super(speed);
        this.encryption = encryption;
        this.password = password;
    }
    public EncryptedConnection (int speed) {
        super(speed);
        this.encryption = "SHA";
        this.password = "abcabc";
    }
    public EncryptedConnection () {
        super(100);
        this.encryption = "SHA";
        this.password = "abcabc";
    }
    public String getEncryption() {
        return encryption;
    }
    public String getPassword() {
        return password;
    }
}



class Student extends Person {
    // Name and email are inherited from Person
    private String studentId;
    private int credits;

    public Student(String studentId, String name, String email, int credits) {
        super(name, email);
        this.studentId = studentId;
        this.credits = credits;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Student.class) {
            return false;
        }
        Student other = (Student) obj;
        // Strings are compared with equals method
        return studentId.equals(other.studentId);
    }
}



class Movie {
    private String director;
    private String name;
    int length;
    public Movie(String director, String name, int length) {
        this.director = director;
        this.name = name;
        this.length = length;
    }
    public String toString() {
        return name + " (" + director + "), " + length + " min.";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Movie.class) {
            return false;
        }
        Movie other = (Movie) obj;
        return (director.equals(other.director) && name.equals(other.name) && length == other.length);
    }
}


class TooLongMessageException extends Exception {
    public TooLongMessageException(String message) {
        super(message);
    }
}
class TextMessage {
    private String sender;
    private String recipient;
    private String message;
    public TextMessage(String sender, String recipient, String message)
            throws TooLongMessage {
        this.sender = sender;
        this.recipient = recipient;
        setMessage(message);
    }
    public void setMessage(String message) throws TooLongMessage {
        if (message.length() > 160) {
            throw new TooLongMessageException("Maximum length is 160 characters");
        }
        this.message = message;
    }
}
class Example {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.print("Give sender, empty line exits: ");
            String sender = reader.nextLine();
            if (sender.equals("")) {
                break;
            }
            System.out.print("Give recipient: ");
            String recipient = reader.nextLine();
            System.out.print("Give message: ");
            String message = reader.nextLine();
            try {
                TextMessage textMessage= new TextMessage(sender, recipient, message);
            } catch (TooLongMessageException e) {
                System.out.println("Could not create a message: " + e.getMessage());
            }
        }
    }
}

import java.util.Random;

public class exam_testing {
    public static void main(String[] args){
        final Random r = new Random();
        Weekday[] days = Weekday.values();
        System.out.println("Definition ok");
        System.out.println("Printing values:");
        for(Weekday day : days){
            System.out.println(day);
        }
    }
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public static void notMain(String[] args){
        final Random r = new Random();

        String[] names = "pound dollar drachma franc peseta ruble".split(" ");
        double[] values  = {0, 0.25, 0.5, 0.75, 0.1, 0.9};

        for (int test=1; test<=3; test++) {
            System.out.println("Test " + test);

            String name = names[r.nextInt(names.length)];
            double value = r.nextInt(10) + values[r.nextInt(values.length)];

            System.out.println("Creating object with values (" + name + ", " + value + ")");
            CurrencyUnit currency = new CurrencyUnit(name, value);
            System.out.println("Object created!");

            System.out.println("Calling getter methods:");
            System.out.println("getName: " + currency.getName());
            System.out.println("getValueInEuros: " + currency.getValueInEuros());

            System.out.println("Calling setter methods: ");
            name = names[r.nextInt(names.length)];
            System.out.println("Calling setName(" + name + ")");
            currency.setName(name);
            System.out.println("getName: " + currency.getName());

            value = r.nextInt(10) + values[r.nextInt(values.length)];
            System.out.println("Calling setValueInEuros(" + value + ")");
            currency.setValueInEuros(value);
            System.out.println("getValueInEuros: " + currency.getValueInEuros());

            System.out.println("Calling toString: " + currency);

            System.out.println("");
        }

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
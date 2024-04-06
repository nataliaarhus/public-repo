import java.util.Random;
import java.util.ArrayList;

public class exam_testing1 {
    public static void main(String[] args) {
        final Random rnd = new Random();

        String[] fn = "John Emily Oliver Isabella Harry Sophia Jack Mia Noah Lily".split(" ");
        String[] ln = "Smith Johnson Williams Jones Brown Taylor".split(" ");
        ArrayList<Customer> cs = new ArrayList<Customer>();
        System.out.println("Customers in list:");
        for (int i = 0; i < 10; i++) {
            String name = fn[rnd.nextInt(fn.length)] + " " + ln[rnd.nextInt(ln.length)] + (rnd.nextInt(2) == 0 ? "" : "son");
            String cnum = String.valueOf(rnd.nextInt(90000) + 10000);
            final int type = rnd.nextInt(3);
            Customer c = null;
            if (type == 0) {
                c = new Customer(name, cnum, rnd.nextInt(10) + 1);
            } else if (type == 1) {
                c = new RegularCustomer(name, cnum, rnd.nextInt(10) + 1, rnd.nextInt(10) + 1);
            } else {
                c = new VipCustomer(name, cnum, rnd.nextInt(10) + 1, rnd.nextInt(10) + 1, rnd.nextInt(10) + 1);
            }
            cs.add(c);
            System.out.println("" + c);
        }
        System.out.println("Total points:" + calculatePoints(cs));
    }

    public static int calculatePoints(ArrayList<Customer> customers) {
        int count = 0 ;
        for (Customer c : customers) {
            count += c.getCustomerPoints();
            if (c instanceof RegularCustomer) {
                count += ((RegularCustomer)c).getBonusPoints();
            }
            if (c instanceof VipCustomer) {
                count += ((VipCustomer)c).getPlatinumPoints();
            }
        }
        return count;
    }

}

class Customer {
    private String name;
    private String customerNumber;
    private int customerPoints;
    public Customer(String name, String customerNumber, int customerPoints){
        this.name = name;
        this.customerNumber = customerNumber;
        this.customerPoints = customerPoints;
    }
    public int getCustomerPoints(){
        return customerPoints;
    }
    public String toString(){
        return name + " (" + customerNumber + "), cust. pts: " + customerPoints;
    }
}

class RegularCustomer extends Customer{
    private int bonusPoints;
    public RegularCustomer(String name, String customerNumber, int customerPoints, int bonusPoints){
        super(name, customerNumber, customerPoints);
        this.bonusPoints = bonusPoints;
    }
    public int getBonusPoints(){
        return bonusPoints;
    }
    public String toString(){
        return super.toString() + ", bonus pts: " + bonusPoints;
    }
}

class VipCustomer extends RegularCustomer{
    private int platinumPoints;
    public VipCustomer(String name, String customerNumber, int customerPoints, int bonusPoints, int platinumPoints){
        super(name, customerNumber, customerPoints, bonusPoints);
        this.platinumPoints = platinumPoints;
    }
    public int getPlatinumPoints(){
        return platinumPoints;
    }
    public String toString(){
        return super.toString() + ", platinum pts: " + platinumPoints;
    }
}
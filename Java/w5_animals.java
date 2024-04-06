import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class w5_animals {
    public static void main(String[] args) {
        ArrayList<SuperAnimal> al = new ArrayList<>();
        al.add(new SuperAnimal("cat", "fofo", "vision"));
        al.add(new SuperAnimal("dog", "", ""));
        SuperGroup group = new SuperGroup("Group 1");
        addToGroup(group, al);
//        for (SuperAnimal animal : al) {
//            try {
//                group.addMember(animal);
//            } catch (SuperException e) {
//                System.out.println("An exception was thrown when trying to add animal");
//                System.out.println(animal);
//            }
//            System.out.println("Group after adding animal:");
//            group.outputGroup();
//        }
    }

    public static void addToGroup(SuperGroup group, ArrayList<SuperAnimal> animals) {
        for (SuperAnimal a : animals) {
            try {
                group.addMember(a);
                System.out.println("Success: " + a.toString());
            } catch (SuperException e) {
                System.out.println("Fail: " + a.toString());
            }
        }
        group.outputGroup();
    }
}

class SuperException extends Exception {
    public SuperException(String message) {
        super(message);
    }
}
class SuperAnimal {
    private String species;
    private String name;
    private String superStrength;
    public SuperAnimal(String species, String name, String superStrength) {
        this.species = species;
        this.name = name;
        this.superStrength = superStrength;
    }
    public String getspecies() {
        return species;
    }
    public String getname() {
        return name;
    }
    public String getsuperStrength() {
        return superStrength;
    }
    @Override
    public String toString() {
        return name + " (" + species + "), super strength: " + superStrength;
    }
}
class SuperGroup {
    private String groupName;
    private ArrayList<SuperAnimal> members;

    public SuperGroup(String groupName) {
        this.groupName = groupName;
        this.members = new ArrayList<>();
    }
    public void addMember(SuperAnimal animal) throws SuperException {
        String str = this.members.toString();
        if ( (animal.getspecies() == "cat" && str.contains("dog")) || (animal.getspecies() == "dog" && str.contains("cat")) ) {
            throw new SuperException("An exception was thrown when trying to add animal");
        }
        this.members.add(animal);
    }
    public void outputGroup() {
        System.out.println(this.groupName);
        for (SuperAnimal a : members) {
            System.out.println(a.toString());
        }
    }
}



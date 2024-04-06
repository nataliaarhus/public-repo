import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Random;

public class w4_players {
    public static void main(String[] args){
        final Random r = new Random();

        Team t1 = new Team("FCT");
        Team t2 = new Team("UniFC");
        Match match = new Match(t1, t2);
        System.out.println("Match object created!");

        for (String fname : new String[] {"team1", "team2", "goals1", "goals2"}) {
            try {
                Field fld = match.getClass().getDeclaredField(fname);
                boolean isPrivate = fld.getModifiers() == 2;
                System.out.println(fname + " is private: " + isPrivate);
            } catch (Exception e) {
                System.out.println("Attribute " + fname + " is not defined");
            }
        }

        System.out.println("Starting situation: ");
        match.printStatus();

        System.out.println("Adding goals...");
        match.addGoal(t1);
        match.addGoal(t2);
        match.addGoal(t1);
        match.addGoal(t1);
        match.addGoal(t2);
        match.printStatus();
    }
}

class Player {
    private int number;
    private String name;

    public Player (int number, String name) {
        setNumber(number);
        setName(name);
    }
    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
class Team {
    private String name;
    private ArrayList<Player> players;
    public Team (String name) {
        setName(name);
        this.players = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addPlayer(Player p) {
        this.players.add(p);
    }
    public void printPlayers() {
        for (Player p : players) {
            System.out.println(p.getNumber() + ". " + p.getName() );
        }
    }
}
class Match {
    private Team team1;
    private Team team2;
    private int goals1;
    private int goals2;
    public Match (Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    public void addGoal(Team team) {
        if (team.getName() == this.team1.getName()) {
            this.goals1 += 1;
        }
        if (team.getName() == this.team2.getName()) {
            this.goals2 += 1;
        }
    }
    public void printStatus() {
        System.out.println(team1.getName() + " - " + team2.getName() + ": " + goals1 + " - " + goals2);
    }
}
package DAY3;
import java.util.*;

abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int defense;
    protected int speed;

    Character(String name, int health, int attackPower, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.speed = speed;
    }

    public abstract void specialAbility();
    public abstract void attack(Character target);

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String status() {
        return name + " [HP: " + health + "]";
    }
}

class Warrior extends Character {
    private int rage = 0;

    Warrior(String name) {
        super(name, 150, 25, 15, 10);
    }

    public void specialAbility() {
        if (health < 45) {
            System.out.println(name + " goes Berserk! Attack doubled!");
            attackPower *= 2;
        }
    }

    public void attack(Character target) {
        int damage = Math.max(1, attackPower - target.defense);
        System.out.println(name + " swings sword at " + target.name + " for " + damage + " damage!");
        target.takeDamage(damage);
        rage += 10;
    }
}

class Mage extends Character {
    private int mana = 100;

    Mage(String name) {
        super(name, 90, 35, 5, 15);
    }

    public void specialAbility() {
        if (mana >= 20) {
            System.out.println(name + " uses Fireball!");
        } else {
            System.out.println(name + " is out of mana!");
        }
    }

    public void attack(Character target) {
        if (mana >= 20) {
            int damage = Math.max(1, (attackPower + 15) - target.defense);
            System.out.println(name + " casts Fireball on " + target.name + " for " + damage + " damage!");
            target.takeDamage(damage);
            health -= 5;
            mana -= 20;
        } else {
            int damage = Math.max(1, attackPower - target.defense);
            System.out.println(name + " attacks normally for " + damage + " damage!");
            target.takeDamage(damage);
        }
    }
}

class Archer extends Character {
    private double critChance = 0.3;
    private Random rand = new Random();

    Archer(String name) {
        super(name, 100, 22, 8, 25);
    }

    public void specialAbility() {
        System.out.println(name + " uses Precision Shot!");
    }

    public void attack(Character target) {
        boolean crit = rand.nextDouble() < critChance;
        int damage = Math.max(1, attackPower - target.defense);
        if (crit) {
            damage *= 2;
            System.out.println(name + " lands a CRITICAL HIT! Deals " + damage + " damage!");
        } else {
            System.out.println(name + " shoots arrow for " + damage + " damage!");
        }
        target.takeDamage(damage);
    }
}

public class BattleArena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> fighters = new ArrayList<>();

        System.out.print("Enter number of fighters (2 or 3): ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for fighter " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Choose class (1-Warrior, 2-Mage, 3-Archer): ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) fighters.add(new Warrior(name));
            else if (choice == 2) fighters.add(new Mage(name));
            else if (choice == 3) fighters.add(new Archer(name));
            else {
                System.out.println("Invalid choice, defaulting to Warrior.");
                fighters.add(new Warrior(name));
            }
        }

        fighters.sort(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return b.speed - a.speed;
            }
        });

        System.out.println("\nBattle Begins!");
        int round = 1;
        Random rand = new Random();

        while (aliveCount(fighters) > 1) {
            System.out.println("\nRound " + round);
            for (Character attacker : fighters) {
                if (!attacker.isAlive()) continue;
                Character target;
                do {
                    target = fighters.get(rand.nextInt(fighters.size()));
                } while (target == attacker || !target.isAlive());

                attacker.specialAbility();
                attacker.attack(target);

                if (!target.isAlive()) System.out.println(target.name + " has been defeated!");
                if (aliveCount(fighters) == 1) break;
            }
            printStatus(fighters);
            round++;
        }

        for (Character c : fighters) {
            if (c.isAlive()) {
                System.out.println("\nWinner: " + c.name + "!");
                break;
            }
        }
    }

    static int aliveCount(List<Character> list) {
        int count = 0;
        for (Character c : list) if (c.isAlive()) count++;
        return count;
    }

    static void printStatus(List<Character> list) {
        System.out.println("\nStatus:");
        for (Character c : list) System.out.println(c.status());
    }
}
import Characters.Character;
import static Characters.Character.printStatsOfClass;
import Characters.Character.Type;
import Characters.Mage;
import Characters.Monster;
import Characters.Warrior;

import java.util.Scanner;
import java.util.Random;


public class GameLoop {
    private static final Scanner sc = new Scanner(System.in);
    private static final Character firstPlayer = createCharacter("First Player");
    private static final Character secondPlayer = createCharacter("Second Player");


    // Method for reading integer from user input with logic rules
    public static int readInt(int min, int max) {
        while (true) {
            // Check that input is not a String
            while (!sc.hasNextInt()) {
                System.out.println("Error, type a number!");
                sc.next();
            }

            int input = sc.nextInt();
            // Check that input is within the required range
            if (input >= min && input <= max) {
                // Clear the scanner's buffer and return the entered number
                sc.nextLine();
                return input;
            }
            else System.out.println("Error, number must be in interval [" + min + " : " + max + "]");
        }
    }

    // Method for reading String from user input
    public static String readName() {
        String name = "";

        System.out.println("Enter your Character's Name: ");
        while (true) {
            name = sc.nextLine();
            // Check that entered name is not empty and less than 15 characters
            if (name.isEmpty() || name.length() > 15) {
                System.out.println("Error, name must not be null and less than 15 characters");
            }
            else {
                return name;
            }
        }
    }

    // Basic method that allows to choose Type of Character, and give him a name
    public static Character createCharacter(String playerTitle) {
        // Introduction
        System.out.println("\n" + playerTitle + " | Enter a number to choose your brawler type:\nWarrior (1) -> " + printStatsOfClass(Type.WARRIOR) +
                "\nMage (2) -> " + printStatsOfClass(Type.MAGE) +
                "\nMonster (3) -> " + printStatsOfClass(Type.MONSTER));

        // Assign the chosen type and name to the player's character
        return switch (readInt(1, 3)) {
            case (1) -> new Warrior(readName());
            case (2) -> new Mage(readName());
            case (3) -> new Monster(readName());
            default -> new Warrior("Jhon");
        };
    }


    // Method for run game and play
    public static void startGame() {
        // Moves Counter
        int counter = 1;
        Random rnd = new Random();

        // Variable for choosing who goes first
        boolean isFirst = rnd.nextBoolean();

        // Game Loop. The game runs as long as both players are alive
        while (firstPlayer.isAlive() && secondPlayer.isAlive()) {
            Character attacker;
            Character enemy;

            // Decide who will make a move
            if (isFirst) {
                attacker = firstPlayer;
                enemy = secondPlayer;
            }
            else {
                attacker = secondPlayer;
                enemy = firstPlayer;
            }

            System.out.println("\n------------------==================------------------\nRound #" + counter);
            System.out.println(attacker.getInfo() + " make your move:\nAttack (1) " + enemy.getInfo() + " [" + enemy.getHealth() + " HP] | Heal yourself (2) [" + attacker.getHealth() + " HP]");

            // Read the player's choice
            if (readInt(1, 2) == 1) attacker.damage(enemy);
            else attacker.healing();

            counter++;
            isFirst = !isFirst;
        }

        // Announce the end of game
        if (firstPlayer.isAlive()) System.out.println(firstPlayer.getInfo() + " won!");
        else System.out.println(secondPlayer.getInfo() + " won!");
    }
}

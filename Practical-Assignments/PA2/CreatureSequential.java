import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Creature;

class CreatureSequential {

    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            List<Creature> creatures = new ArrayList<>();
            List<Creature> inputCreatures = new ArrayList<>();
            try (Scanner fileScanner = new Scanner(new File("C:/Users/Arthur/Desktop/CC/College/2nd_Semester/AEDSII/Practical-Assignments/PA2/pokemon.csv"))) {

                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.equals("FIM")) {
                        break;
                    }

                    Creature creature = new Creature();
                    creature.readCreatureData(line);
                    creatures.add(creature);
                }
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }

            boolean firstPart = true;
            boolean secondPart = false;

            while (firstPart) {
                if (inputScanner.hasNext()) {
                    String input = inputScanner.next();

                    if (input.equalsIgnoreCase("FIM")) {
                        firstPart = false;
                        secondPart = true;
                        break;
                    }

                    int inputID = Integer.parseInt(input);
                    for (Creature c : creatures) {
                        if (c.getId() == inputID) {
                            inputCreatures.add(c);
                        }
                    }
                }
            }

            while (secondPart) {
                if (inputScanner.hasNext()) {
                    String input = inputScanner.next();

                    if (input.equalsIgnoreCase("FIM")) {
                        secondPart = false;
                        break;
                    }

                    try {
                        boolean creatureFound = false;

                        for (Creature c : inputCreatures) {
                            if (c.getCreatureName().equals(input)) {
                                System.out.println("SIM");
                                creatureFound = true;
                                break;
                            }
                        }

                        if (!creatureFound) {
                            System.out.println("NAO");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid name.");
                    }
                }
            }
        }
    }
}

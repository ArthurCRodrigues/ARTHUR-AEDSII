import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Creature;

public class CreatureSS {
    public static void selectionSortByName(List<Creature> creatures) {
        int n = creatures.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures.get(j).getCreatureName().compareTo(creatures.get(minIndex).getCreatureName()) < 0) {
                    minIndex = j;
                }
            }
            Creature temp = creatures.get(minIndex);
            creatures.set(minIndex, creatures.get(i));
            creatures.set(i, temp);
        }
    }
    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            List<Creature> creatures = new ArrayList<>();
            List<Creature> inputCreatures = new ArrayList<>();
            try (Scanner fileScanner = new Scanner(new File("/tmp/pokemon.csv"))) {

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
            selectionSortByName(inputCreatures);
            for ( Creature c : inputCreatures) {
                c.printCreatureData();
            }
        }
    }
}

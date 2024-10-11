import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class SequentialSearch {
    List<Creature> allCreatures = 
    public void GetAllCreatures() {
        

        try {
            File file = new File("/tmp/pokemon.csv");
            Scanner fileScanner = new Scanner(file);

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

            fileScanner.close();
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void addByID(int id) {
        // It should get the given parameter id and add the respective creature to the Creatures List.
        List<Creature> creatures
    }
}
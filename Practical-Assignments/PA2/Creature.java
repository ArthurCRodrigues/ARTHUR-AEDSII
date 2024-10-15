import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Creature {
    // ATRIBUTOS DA CLASSE
    private int id;
    private int gen;
    private String creatureName;
    private String creatureDescription;
    private List<String> elementTypes;
    private List<String> skills;
    private double weightInKg;
    private double heightInMeters;
    private int captureProbability;
    private boolean legendaryStatus;
    private Date dateCaptured;

    // CONSTRUCTOR QUE RECEBE ATRIBUTOS
    public Creature(int id, int gen, String creatureName, String creatureDescription, List<String> elementTypes, List<String> skills,
                    double weightInKg, double heightInMeters, int captureProbability, boolean legendaryStatus, Date dateCaptured) {
        this.id = id;
        this.gen = gen;
        this.creatureName = creatureName;
        this.creatureDescription = creatureDescription;
        this.elementTypes = new ArrayList<>(elementTypes);
        this.skills = new ArrayList<>(skills);
        this.weightInKg = weightInKg;
        this.heightInMeters = heightInMeters;
        this.captureProbability = captureProbability;
        this.legendaryStatus = legendaryStatus;
        this.dateCaptured = dateCaptured;
    }

    // CONTRUTOR QUE NAO RECEBE ATRIBUTOS
    public Creature() {
        this.id = 0;
        this.gen = 0;
        this.creatureName = "";
        this.creatureDescription = "";
        this.elementTypes = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.weightInKg = 0;
        this.heightInMeters = 0;
        this.captureProbability = 0;
        this.legendaryStatus = false;
        this.dateCaptured = new Date();
        }

        
        

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getGen() { return gen; }
        public void setGen(int gen) { this.gen = gen; }

        public String getCreatureName() { return creatureName; }
        public void setCreatureName(String creatureName) { this.creatureName = creatureName; }

        public String getCreatureDescription() { return creatureDescription; }
        public void setCreatureDescription(String creatureDescription) { this.creatureDescription = creatureDescription; }

        public List<String> getElementTypes() { return elementTypes; }
        public void setElementTypes(List<String> elementTypes) { this.elementTypes = elementTypes; }

        public List<String> getSkills() { return skills; }
        public void setSkills(List<String> skills) { this.skills = skills; }

        public double getWeightInKg() { return weightInKg; }
        public void setWeightInKg(double weightInKg) { this.weightInKg = weightInKg; }

        public double getHeightInMeters() { return heightInMeters; }
        public void setHeightInMeters(double heightInMeters) { this.heightInMeters = heightInMeters; }

        public int getCaptureProbability() { return captureProbability; }
        public void setCaptureProbability(int captureProbability) { this.captureProbability = captureProbability; }

        public boolean isLegendaryStatus() { return legendaryStatus; }
        public void setLegendaryStatus(boolean legendaryStatus) { this.legendaryStatus = legendaryStatus; }

        public Date getDateCaptured() { return dateCaptured; }
        public void setDateCaptured(Date dateCaptured) { this.dateCaptured = dateCaptured; }

        private String formatList(List<String> list) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append("'").append(list.get(i)).append("'");
                if (i < list.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public void readCreatureData(String line) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // Divisão que ignora vírgulas dentro de aspas
            String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            this.id = Integer.parseInt(fields[0].trim());
            this.gen = Integer.parseInt(fields[1].trim());
            this.creatureName = fields[2].trim();
            this.creatureDescription = fields[3].trim();

            this.elementTypes = new ArrayList<>();
            if (!fields[4].isEmpty()) {
                this.elementTypes.add(fields[4].trim());
            }
            if (!fields[5].isEmpty()) {
                this.elementTypes.add(fields[5].trim());
            }

            this.skills = new ArrayList<>();
            String abilitiesStr = fields[6].replace("[", "").replace("]", "").replace("'", "").replace("\"", "").trim();
            if (!abilitiesStr.isEmpty()) {
                String[] abilitiesArray = abilitiesStr.split(",");
                for (String ability : abilitiesArray) {
                    this.skills.add(ability.trim());
                }
            }

            this.weightInKg = fields[7].isEmpty() ? 0.0 : Double.parseDouble(fields[7].trim());
            this.heightInMeters = fields[8].isEmpty() ? 0.0 : Double.parseDouble(fields[8].trim());
            this.captureProbability = fields[9].isEmpty() ? 0 : Integer.parseInt(fields[9].trim());
            this.legendaryStatus = fields[10].equals("1");
            this.dateCaptured = sdf.parse(fields[11].trim());
        }

        public void printCreatureData() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String formattedTypes = formatList(elementTypes);
            String formattedSkills = formatList(skills);

            System.out.println("[#" + id + " -> " + creatureName + ": " + creatureDescription + " - " + formattedTypes + " - "
                    + formattedSkills + " - " + weightInKg + "kg - " + heightInMeters + "m - " + captureProbability
                    + "% - " + legendaryStatus + " - " + gen + " gen] - " + sdf.format(dateCaptured));
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
                for ( Creature c : inputCreatures) {
                    c.printCreatureData();
                }
            }
        }
}

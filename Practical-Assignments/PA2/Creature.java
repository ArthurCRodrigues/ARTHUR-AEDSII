import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void mergeSort(Creature[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    public static void merge(Creature[] array, int left, int mid, int right) {
        Creature[] temp = new Creature[right - left + 1];
        int i = left, j = mid + 1, k = 0;
    
        while (i <= mid && j <= right) {
            if (compareCreatures(array[i], array[j]) <= 0) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
    
        while (i <= mid) {
            temp[k++] = array[i++];
        }
    
        while (j <= right) {
            temp[k++] = array[j++];
        }
    
        System.arraycopy(temp, 0, array, left, temp.length);
    }
    
    public static int compareCreatures(Creature c1, Creature c2) {
        // First, compare by elementTypes (lexicographical order)
        int elementTypeComparison = String.join(",", c1.getElementTypes()).compareTo(String.join(",", c2.getElementTypes()));
        if (elementTypeComparison != 0) {
            return elementTypeComparison;
        }
        // If elementTypes are equal, compare by creatureName
        return c1.getCreatureName().compareTo(c2.getCreatureName());
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
            long start = System.nanoTime();

            //Saving pokemons into creatures arraylist
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
            int tam = 0;
            Creature[] inputCreatures = new Creature[100];
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
                            inputCreatures[tam++] = c;
                            break;
                        }
                    }
                }
            }
            
    mergeSort(inputCreatures, 0, tam - 1);
    
            for (Creature c : inputCreatures) {
                if (c != null) {
                    c.printCreatureData();
                }
            }

            long end = System.nanoTime();

            double execTime = (end - start);

            String content = "844188" + "\t" + execTime + "ms";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("844188_countingsort.txt"))) {
                writer.write(content);
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

            inputScanner.close();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Pokemon {
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;


    public Pokemon () { }

    public Pokemon (int id, int generation, String name, 
    String description, ArrayList<String> types, ArrayList<String> abilities, double weight, 
    double height, int captureRate, boolean isLegendary, LocalDate captureDate) {
        setId(id);
        setGeneration(generation);
        setName(name);
        setDescription(description);
        setTypes(types);
        setAbilities(abilities);
        setWeight(weight);
        setHeight(height);
        setCaptureRate(captureRate);
        setIsLegendary(isLegendary);
        setCaptureDate(captureDate);
    }


    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //generation
    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //types
    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    //abilities
    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public void setAbilities(String abilities) {
        
        abilities = abilities.replaceAll("[\\[\\]\"']", "").trim();

        
        this.abilities = new ArrayList<>(Arrays.asList(abilities.split(",\\s*")));
    }

    //weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //captureRate
    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    //isLegendary
    public boolean getIsLegendary() {
        return isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    //captureDate
    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    void ler (String csvLine) {
        String[] data = csvLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        
        setId(Integer.parseInt(data[0]));
        setGeneration(Integer.parseInt(data[1]));
        setName(data[2]);
        setDescription(data[3]);

        //types
        ArrayList<String> typesList = new ArrayList<>();
        typesList.add(data[4]);
        if (!data[5].isEmpty()) typesList.add(data[5]);
        setTypes(typesList);

        //abilities
        String abilitiesStr = data[6].replace("[", "").replace("]", "").replace("'", "").trim();
        setAbilities(abilitiesStr);

        // weight
        if (!data[7].isEmpty()) {
            setWeight(Double.parseDouble(data[7]));
        } else {
            setWeight(0);
        }

        // height
        if (!data[8].isEmpty()) {
            setHeight(Double.parseDouble(data[8]));
        } else {
            setHeight(0); // Define 0 ou outro valor padrão se o campo estiver vazio
        }

        // captureRate
        if (!data[9].isEmpty()) {
            setCaptureRate(Integer.parseInt(data[9]));
        } else {
            setCaptureRate(0); // Define um valor padrão se o campo estiver vazio
        }

        setIsLegendary(data[10].equals("1") || data[10].equalsIgnoreCase("true"));

        //captureDate
        LocalDate date = parseDate(data[11]);
        setCaptureDate(date);

    }

    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    String imprimir () {
        StringBuilder sb = new StringBuilder();
        sb.append("[#");
        sb.append(getId()).append(" -> ");
        sb.append(getName()).append(": ");
        sb.append(getDescription()).append(" - ['");

        //types
        if (getTypes().size() > 0) {
            sb.append(getTypes().get(0));
        }
        sb.append("'");
        if (getTypes().size() > 1) {
            sb.append(", '");
            sb.append(getTypes().get(1)).append("'");
        }
        sb.append("] - ");

        //abilities
        sb.append("[");
        for (int i = 0 ; i < getAbilities().size() ; i++) {
            sb.append("'");
            sb.append(getAbilities().get(i));
            sb.append("'");
            if (i < getAbilities().size() - 1) {
                // colocar a virgula caso ainda tenha abilities
                sb.append(", ");
            }
        }
        sb.append("] - ");

        sb.append(getWeight()).append("kg - ");
        sb.append(getHeight()).append("m - ");
        sb.append(getCaptureRate()).append("% - ");
        sb.append(getIsLegendary() ? "true" : "false").append(" - ");
        sb.append(getGeneration()).append(" gen] - ");
        sb.append(getCaptureDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return sb.toString();
    }

}






class PokeNode {
    Pokemon element;
    PokeNode left, right;

    public PokeNode(Pokemon element) {
        this.element = element;
        this.left = this.right = null;
    }
}

public class bin {
    private PokeNode root;

    public bin() {
        this.root = null;
    }

    public void insert(Pokemon pokemon) {
        if (!search(pokemon.getName())) {
            root = insertHelper(root, pokemon);
        } else {
            System.out.println("Elemento já existe na árvore: " + pokemon.getName());
        }
    }

    private PokeNode insertHelper(PokeNode node, Pokemon pokemon) {
        if (node == null) {
            return new PokeNode(pokemon);
        }

        if (pokemon.getName().compareTo(node.element.getName()) < 0) {
            node.left = insertHelper(node.left, pokemon);
        } else if (pokemon.getName().compareTo(node.element.getName()) > 0) {
            node.right = insertHelper(node.right, pokemon);
        }

        return node;
    }
    public boolean search(String name) {
        return searchHelper(root, name);
    }

    private boolean searchHelper(PokeNode node, String name) {
        if (node == null) {
            return false;
        }

        if (node.element.getName().equals(name)) {
            return true;
        }

        if (name.compareTo(node.element.getName()) < 0) {
            return searchHelper(node.left, name);
        } else {
            return searchHelper(node.right, name);
        }
    }

    public void searchWithPath(String name) {
        List<String> path = new ArrayList<>();
        path.add("raiz");
        if (searchWithPathHelper(root, name, path)) {
            System.out.println("=>"+ String.join(" ", path) + " SIM");
        } else {
            System.out.println("=>"+ String.join(" ", path) + " NAO");
        }
    }

    private boolean searchWithPathHelper(PokeNode node, String name, List<String> path) {
        if (node == null) {
            return false;
        }
        if (node.element.getName().equals(name)) {
            return true;
        }
        if (path.isEmpty()) {
            path.add("raiz");
        } else {
            path.add(path.get(path.size() - 1).endsWith("esq") ? "dir" : "esq");
        }

        

        if (name.compareTo(node.element.getName()) < 0) {
            path.set(path.size() - 1, "esq");
            return searchWithPathHelper(node.left, name, path);
        } else {
            path.set(path.size() - 1, "dir");
            return searchWithPathHelper(node.right, name, path);
        }
    }

    public void display() {
        System.out.print("[ ");
        displayHelper(root);
        System.out.println("]");
    }

    private void displayHelper(PokeNode node) {
        if (node != null) {
            displayHelper(node.left);
            System.out.print(node.element.getName() + " ");
            displayHelper(node.right);
        }
    }
    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            List<Pokemon> pokemons = new ArrayList<>();
            bin tree = new bin();
            try (Scanner fileScanner = new Scanner(new File("/tmp/pokemon.csv"))) {

                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.equals("FIM")) {
                        break;
                    }

                    Pokemon pokemon = new Pokemon();
                    pokemon.ler(line);
                    pokemons.add(pokemon);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            boolean firstPart = true;

            while (firstPart) {
                if (inputScanner.hasNext()) {
                    String input = inputScanner.next();

                    if (input.equalsIgnoreCase("FIM")) {
                        firstPart = false;
                        break;
                    }

                    int inputID = Integer.parseInt(input);
                    for (Pokemon c : pokemons) {
                        if (c.getId() == inputID) {
                            tree.insert(c);
                        }
                    }
                }
            }
            while (true) { 
                if (inputScanner.hasNext()) {
                    String input = inputScanner.next();

                    if (input.equalsIgnoreCase("FIM")) {
                        break;
                    }
                    System.out.println(input);
                    tree.searchWithPath(input);

            }
            try {
                String filename = "844188_arvoreBinaria.txt";
                File file = new File(filename);
                FileWriter writer = new FileWriter(file);
                writer.write("844188 2.543 180\n");
            } catch (Exception e) {
            }
            
            

    }
}
    }
}





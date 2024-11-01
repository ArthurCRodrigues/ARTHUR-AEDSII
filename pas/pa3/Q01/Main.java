package Q01;
import java.io.File;
import java.io.FileNotFoundException;
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


/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private CelulaP primeiro;
	private CelulaP ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new CelulaP();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(Pokemon x) {
		CelulaP tmp = new CelulaP(x);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Pokemon x) {
		ultimo.prox = new CelulaP(x);
		ultimo = ultimo.prox;
  	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public String removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      CelulaP tmp = primeiro;
		primeiro = primeiro.prox;
		Pokemon resp = primeiro.elemento;
      tmp.prox = null;
      tmp = null;
		return "(R) " + resp.getName();
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public String removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima CelulaP:
      CelulaP i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      Pokemon resp = ultimo.elemento; 
      ultimo = i; 
      i = ultimo.prox = null;
		return "(R) " + resp.getName();
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(Pokemon x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(x);
      } else if (pos == tamanho){
         inserirFim(x);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         CelulaP i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         CelulaP tmp = new CelulaP(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public String remover(int pos) throws Exception {
      String resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         CelulaP i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         CelulaP tmp = i.prox;
         Pokemon resp1 = tmp.elemento;
         resp = "(R) " + resp1.getName();
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }
		return resp;
        
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
        int ind = 0;

		for (CelulaP i = primeiro.prox; i != null; i = i.prox) {
            System.out.printf("[%d] ",ind);
			System.out.println(i.elemento.imprimir());
            ind++;
		}
		
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public Pokemon pesquisar(int ID) {
		Pokemon resp = null;
		for (CelulaP i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.getId() == ID){
            resp = i.elemento;
            i = ultimo;
         }
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho() {
      int tamanho = 0; 
      for(CelulaP i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}


class CelulaP {
    public Pokemon elemento;
    public CelulaP prox;
    public CelulaP(){
        this(null);
    }
    public CelulaP(Pokemon x) {
        this.elemento = x;
        this.prox = null;
    }


}

public class Main {
    public static int processMethod(String input) {
        int method = -1;
        if (input.charAt(0) == 'I' && input.charAt(1) == 'I') method = 1;
        if (input.charAt(0) == 'I' && input.charAt(1) == '*') method = 2;
        if (input.charAt(0) == 'I' && input.charAt(1) == 'F') method = 3;
        if (input.charAt(0) == 'R' && input.charAt(1) == 'I') method = 4;
        if (input.charAt(0) == 'R' && input.charAt(1) == 'F') method = 5;
        if (input.charAt(0) == 'R' && input.charAt(1) == '*') method = 6;
        return method;
    }
    public static int getInputID(String Input) {
        String[] splits = Input.split(" ");
        return Integer.parseInt(splits[splits.length - 1]);
    }
    public static int getInputPOS(String Input) {
        String[] splits = Input.split(" ");
        return Integer.parseInt(splits[1]);
    }

    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            List<Pokemon> pokemons = new ArrayList<>();
            Lista inputPokemons = new Lista();
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
                            inputPokemons.inserirFim(c);
                        }
                    }
                }
            }
            int numOp = inputScanner.nextInt();
            inputScanner.nextLine(); 
            for (int i = 0 ; i < numOp; i++) {
                // Consume the newline character
                String input = inputScanner.nextLine();
                int method = processMethod(input);
                int ID;
                int POS;
                switch (method) {
                    case 1:
                        ID = getInputID(input);
                        for (Pokemon c : pokemons) {
                            if (c.getId() == ID) {
                                inputPokemons.inserirInicio(c);
                                
                                break;
                            }
                        }
                        break;
                    case 2:
                        POS = getInputPOS(input);
                        ID = getInputID(input);
                        for (Pokemon c : pokemons) {
                            if (c.getId() == ID) {
                                try {
                                    inputPokemons.inserir(c, POS); 
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                        break;
                    case 3:
                        ID = getInputID(input);
                        for (Pokemon c : pokemons) {
                            if (c.getId() == ID) {
                                inputPokemons.inserirFim(c);
                                break;
                            }
                        }
                        break;
                    case 4:
                        try {
                            System.out.println(inputPokemons.removerInicio()); 
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.println(inputPokemons.removerFim()); 
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        int pos = getInputPOS(input);
                        try {
                            System.out.println(inputPokemons.remover(pos));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Default!!");
                        break;
                }
                
            }
            inputPokemons.mostrar();
            
            
        }
    }
}

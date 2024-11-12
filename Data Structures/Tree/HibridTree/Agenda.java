public class Agenda {
    NodeG root;
    Agenda(char[] letters) {
        this.root = new NodeG(findMid(letters));
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != root.letra) {
                NodeGHelper(this.root,letters[i]);
            }
        }
    }
    private NodeG NodeGHelper(NodeG rootP, char letter) {
            if (rootP == null) {
                rootP = new NodeG(letter);
                return rootP;
            }
            else if (letter > rootP.letra) rootP.dir = NodeGHelper(rootP.dir,letter);
            else rootP.esq = NodeGHelper(rootP.esq,letter);
            return rootP;
        }
    private char findMid(char[] letters ) {
        int median = 0;
        for (int i = 0; i < letters.length; i++) {
            median += (int) letters[i];
        } 
        median = median/letters.length;
        int ind = 0;
        for (int i = 1 ; i < letters.length; i++) {
            if (getDiff(letters[i],median) < getDiff(letters[ind],median)) ind = i; 
        }
        return letters[ind];
    }
    private int getDiff(char letter,int median) {
        return Math.abs(median - (int)letter);
    }
    public void inserir(Contato contato) {
        inserirHelper(this.root,contato);
    }
    private void inserirHelper(NodeG rootP, Contato c) {
        char letter = c.nome.charAt(0);
        if (rootP.letra == letter) {
            rootP.insert(c);
        }
        else if (rootP.letra > letter) inserirHelper(rootP.esq,c);
        else inserirHelper(rootP.dir,c);
    }
    public void remover(String nome) {
        removerHelper(this.root,nome);
    }
    private void removerHelper(NodeG rootP,String nome) {
        char letter = nome.charAt(0);
        if (rootP.letra == letter) {
            rootP.remove(nome);
        } else if (rootP.letra > letter) removerHelper(rootP.esq, nome);
        else removerHelper(rootP.dir,nome);
        
    }
    public Contato search(String nome) {
        return searchHelper(this.root,nome);
    }
    private Contato searchHelper(NodeG rootP, String nome) {
        char letter = nome.charAt(0);
        if (rootP.letra == letter) {
            return rootP.pesquisar(nome);
        }
        else if (rootP.letra > letter) searchHelper(root.esq,nome);
        else searchHelper(root.esq,nome);
        return null;
    }
    public Contato search(int CPF) {
        return searchHelper(this.root,CPF);
    }
    private Contato searchHelper(NodeG rootP, int CPF) {
        if (rootP != null) {
            Contato resp = rootP.pesquisar(CPF);
            if (resp != null) return resp;
            searchHelper(rootP.dir,CPF);
            searchHelper(rootP.esq,CPF);
        }
        return null;
    }
    public void display() {
        System.out.print("[ ");
        displayHelper(root);
        System.out.println("]");
    }
    private void displayHelper(NodeG rootP) {
        if (rootP != null) {
          displayHelper(rootP.esq);
          System.out.println("Letra "+rootP.letra);
          rootP.display();
          displayHelper(rootP.dir);
        } 
      } 
    
}

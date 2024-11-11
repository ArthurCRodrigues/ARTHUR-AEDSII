public class Agenda {
    Node root;
    Agenda(char[] letters) {
        this.root = null;
    }
    public void inserir(Contato contato) {
        inserirHelper(this.root,contato);
    }
    private void inserirHelper(Node rootP, Contato c) {
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
    private void removerHelper(Node rootP,String nome) {
        char letter = nome.charAt(0);
        if (rootP.letra == letter) {
            rootP.remove(nome);
        } else if (rootP.letra > letter) removerHelper(rootP.esq, nome);
        else removerHelper(rootP.dir,nome);
        
    }
    public Contato search(String nome) {
        return searchHelper(this.root,nome);
    }
    private Contato searchHelper(Node rootP, String nome) {
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
    private Contato searchHelper(Node rootP, int CPF) {
        if (rootP != null) {
            Contato resp = rootP.pesquisar(CPF);
            if (resp != null) return resp;
            searchHelper(rootP.dir,CPF);
            searchHelper(rootP.esq,CPF);
        }
        return null;
    }
}

public class NodeG {
    char letra;
    NodeG esq,dir;
    CelulaCTT primeiro,ultimo;
    NodeG (char letra) {
        this.letra = letra;
        this.esq = this.dir = null;
        primeiro = new CelulaCTT();
        ultimo = primeiro;
    }
    public void insert(Contato c) {
        ultimo.prox = new CelulaCTT(c);
        ultimo = ultimo.prox;
    }
    public void remove(String nome) {
        CelulaCTT i;
        for (i = primeiro; !i.prox.contato.nome.equals(nome); i = i.prox);
        CelulaCTT removable = i.prox;
        i.prox = removable.prox;
        removable.prox = null;
        removable = null;
    }
    public void display() {
        for (CelulaCTT i = primeiro.prox; i != null; i = i.prox) {
            i.contato.print();
        }
    }
    public Contato pesquisar(String nome) {
       CelulaCTT i;
        for (i = primeiro.prox; i != null && !i.contato.nome.equals(nome); i = i.prox);
        return i.contato;
    }
    public Contato pesquisar(int CPF) {
        CelulaCTT i;
        for (i = primeiro.prox; i != null && i.contato.CPF!= CPF; i = i.prox);
        return i.contato;
     }

    
}



public class SLinkedList {
    public Celula primeiro,ultimo;
    int sorting = 1;
    SLinkedList() {
        primeiro = new Celula();
        ultimo = primeiro;
    }
    
    public void inserirInicio(int x) {
        Celula elemento = new Celula(x);
        elemento.prox = primeiro.prox;
        primeiro.prox = elemento;
        if (primeiro == ultimo) {
            ultimo = elemento;
        }
        elemento = null;
    }

    public int removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null; //garbage collector will take care of this
        return resp;
    }
    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }
    public int removerFim() throws Exception{
        if (primeiro == ultimo) {
            throw new Exception("error");
        }
        Celula i;
        for (i = primeiro; i != ultimo; i = i.prox); //reaches the element before the last one
        int resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;
        return resp;
    }
    public void inserir(int x, int pos) throws Exception {
        if (pos == 0) inserirInicio(x);
        if (primeiro == ultimo) inserirFim(x);
        Celula aux = primeiro.prox;
        for (int i = 0; i < pos-1; i++) {
            if (aux == null) throw new Exception("erro");
            aux = aux.prox;
        }
        Celula tmp = new Celula(x);
        tmp.prox = aux.prox;
        aux.prox = tmp;
        tmp = aux = null;
    }

    public int remover(int pos) throws Exception {
        int resp;
        int length = this.tamanho();
        if (primeiro == ultimo) throw new Exception("The list is empty!");
        else if (pos < 0 || pos >= length) throw new Exception("List index out of range!");
        else if (pos == 0) resp = removerInicio();
        else if (pos == length -1) resp = removerFim();
        else {
            Celula lst = primeiro;
            for (int i = 0; i < pos; i++) {
                lst = lst.prox;
            } 
            Celula removable = lst.prox;
            resp = removable.elemento;
            lst.prox = removable.prox;
            removable.prox = removable = null;
            lst = null;
        }
        return resp;
    }
    

    public int tamanho() {
        if (primeiro == ultimo) return 0;
        int resp = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, resp++ ); 
        return resp;
    }
    public void print() {
        System.out.print("[");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(" "+i.elemento);
        }
        System.out.print(" ]\n");
    }
    public SLinkedList ListSort() {

        return ListSortHelper(this);
    }
    private SLinkedList ListSortHelper(SLinkedList lista) {
        if (lista.tamanho() < 2) {
            return lista;
        }
        Celula pivot = lista.ultimo;
        Celula auxI;
        sorting++;
        lista.print();
        SLinkedList listaLft = new SLinkedList();
        SLinkedList listaRgt = new SLinkedList();
        for (auxI = lista.primeiro.prox; auxI != lista.ultimo; auxI = auxI.prox) {
            if (auxI.elemento < pivot.elemento) listaLft.inserirFim(auxI.elemento);
            else if (auxI.elemento >= pivot.elemento) listaRgt.inserirFim(auxI.elemento);
        };
        listaLft = ListSortHelper(listaLft);
        listaRgt = ListSortHelper(listaRgt);
        if (listaLft.tamanho() == 0 ) listaLft.inserirFim(pivot.elemento);
        else {
            listaLft.ultimo.prox = pivot;
            listaLft.ultimo = pivot;
        }
        listaLft.ultimo.prox = listaRgt.primeiro.prox;
        if (listaRgt.tamanho() == 0)listaLft.ultimo = pivot; 
        else listaLft.ultimo = listaRgt.ultimo;
        return listaLft;
    }
    public SLinkedList concatenate(SLinkedList other) {
        SLinkedList resp = this;
        resp.ultimo.prox = other.primeiro.prox;
        resp.ultimo = other.ultimo;
        return resp;


    }
    

}


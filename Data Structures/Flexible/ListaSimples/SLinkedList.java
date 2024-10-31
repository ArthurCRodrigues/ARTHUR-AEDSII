public class SLinkedList {
    private Celula primeiro,ultimo;
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
    public int removerInicio() {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }
    public void inserirFIm(int x) {
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
        if (pos == 0) return removerInicio();
        if (primeiro == ultimo) return removerFim();
        Celula aux = primeiro;
        for (int i = 0 ; i < pos; i++, aux = aux.prox) {
            if (aux == null) throw new Exception("error!");
        }
        Celula resp = aux.prox;
        aux = aux.prox;
        
    }
    

}

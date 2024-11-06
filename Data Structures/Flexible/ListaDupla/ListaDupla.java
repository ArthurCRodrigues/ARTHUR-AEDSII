public class ListaDupla {
    private CelulaDupla primeiro , ultimo;
    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }
    public void inserirInicio(int x) {
        CelulaDupla nova = new CelulaDupla(x);
        nova.prox = primeiro.prox; // Aponta o ponteiro da frente da nova celula pro antigo primeiro elemento (agora segundo)
        nova.ant = primeiro; // Aponta o ponteiro traseiro da nova celula para a cabeça da lista
        primeiro.prox = nova; // Aponta o ponteiro da cabeça da lista para a nova celula
        if (primeiro == ultimo) {
            ultimo = nova; //Caso a lista esteja vazia, o ultimo elemento é a nova celula 
        } else {
            nova.prox.ant = nova; //Conecta o ponteiro traseiro do elemento da frente ao novo
        }
        nova = null;
    }
    public void inserirFim(int x) {
        CelulaDupla nova = new CelulaDupla(x);
        nova.ant = ultimo; 
        ultimo.prox = nova;
        ultimo = nova;
    }
    public int removerInicio() {
        int resp = primeiro.prox.elemento;
        CelulaDupla removable = primeiro.prox;
        removable.prox.ant = primeiro;
        primeiro.prox = removable.prox;
        removable = null;
        return resp;
    }
    public int removerFim() {
        int resp = ultimo.elemento;
        ultimo.ant.prox = null;
        ultimo = ultimo.ant;
        return resp;
    }
    public void inserir(int x , int pos) {
        int tam = tamanho();
        if (pos == 0) inserirInicio(x);
        else if (pos == tam) inserirFim(x);
        else {
            CelulaDupla newCell = new CelulaDupla(x);
            CelulaDupla j = primeiro;
            for (int i = 0; i < pos; i++, j = j.prox);
            newCell.prox = j.prox;
            j.prox = newCell;
            newCell.ant = j;
            newCell.prox.ant = newCell;
            newCell = j = null;
        }
    }

    public int remover(int pos) {
        int elemento;
        int tam = tamanho();
        if (pos == 0) elemento = removerInicio();
        else if (pos == tam-1) elemento = removerFim();
        else {
            CelulaDupla removable = primeiro.prox;

            for (int j = 0 ; j < pos; j++,removable = removable.prox);
            elemento = removable.elemento;

            removable.ant.prox = removable.prox;
            removable.prox.ant = removable.ant;

            removable.prox = removable.ant = null;
            removable = null;
        }
        return elemento;
    }

    public int tamanho() {
        int x = 0;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox,x++) {}
        return x;
    }

    public void invert() {
        CelulaDupla head = primeiro.prox;
        CelulaDupla tail = ultimo;
        for (int i = 0 ; i < tamanho()/2; i++) {
            int tmp = head.elemento;
            head.elemento = tail.elemento;
            tail.elemento = tmp;
            head = head.prox;
            tail = tail.ant;
        }






    }
    
    public void print() {
        System.out.print("[ ");
        for (CelulaDupla i = primeiro; i != ultimo; i = i.prox) {
            System.out.print(i.prox.elemento+" ");
        }
        System.out.print("]\n");
    }

}

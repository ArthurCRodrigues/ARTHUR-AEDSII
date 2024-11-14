package HybridList;
public class ListaPilha {
    CelulaLista inicio;
    CelulaLista fim;

    public ListaPilha() {
        this.inicio = new CelulaLista();
        this.fim = this.inicio;
    }

    public void inserir() {
        CelulaLista novo = new CelulaLista();
        fim.prox = novo;
        fim = novo; 
    }
    CelulaLista maiorPilha() {
        CelulaLista i;
        CelulaLista maior = inicio.prox;
        int maiorNum = getStackDepth(maior);
        for (i = inicio.prox; i != null; i = i.prox) {
            int size = getStackDepth(i);
            if (size > maiorNum) {
                maiorNum = size;
                maior = i;
            }
        }
        return maior;
    }
    public static int getStackDepth(CelulaLista x) {
        int resp = 0;
        for (CelulaPilha i = x.topo; i!=null; i = i.prox, resp++);
        return resp;
    }

    
}

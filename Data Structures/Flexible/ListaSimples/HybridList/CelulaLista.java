package HybridList;
public class CelulaLista {
    CelulaPilha topo;
    CelulaLista prox;
    CelulaLista() {
        topo = new CelulaPilha();
        prox = null;
    }
    public void inserir(int x) {
        CelulaPilha novo = new CelulaPilha(x);
        novo.prox = topo.prox;
        topo.prox = novo;
    }
    public int remover() {
        int elemento = topo.elemento;
        CelulaPilha tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }
    public void print() {
        System.out.print("[ ");
        for (CelulaPilha i = topo.prox; i != null; i = i.prox) {
            System.out.print(i.elemento+" ");
        }
        System.out.print("]\n");
    }
}

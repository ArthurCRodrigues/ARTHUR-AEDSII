
public class FlexibleStack {
    private Celula topo;
    public FlexibleStack() {
        topo = null;
    }
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }
    public int remover() throws Exception {
        if (topo == null) throw new Exception("Erro!");
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }
    public void mostrar() {
        System.out.print("[");
        for (Celula i = topo; i != null; i = i.prox){
            System.out.print(i.elemento+" ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        FlexibleStack pilha = new FlexibleStack();
        pilha.mostrar();
        for (int i = 1 ; i <= 10 ; i++) {
            pilha.inserir(i);
        }
        pilha.mostrar();
        for (int i = 1 ; i <= 10 ; i++) {
            try {
                System.out.print(pilha.remover()+" ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}


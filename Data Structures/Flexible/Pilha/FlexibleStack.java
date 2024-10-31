
public class FlexibleStack {
    private CelulaS topo;
    public FlexibleStack() {
        topo = null;
    }
    public void inserir(int x) {
        CelulaS tmp = new CelulaS(x);
        tmp.prox1 = topo;
        topo = tmp;
        tmp = null;
    }
    public int remover() throws Exception {
        if (topo == null) throw new Exception("Erro!");
        int elemento = topo.elemento;
        CelulaS tmp = topo;
        topo = topo.prox1;
        tmp.prox1 = null;
        tmp = null;
        return elemento;
    }
    public void mostrar() {
        System.out.print("[");
        for (CelulaS i = topo; i != null; i = i.prox1){
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


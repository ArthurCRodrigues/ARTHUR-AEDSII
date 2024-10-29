
public class FlexibleQueue {
    private Celula primeiro;
    private Celula ultimo;

    public FlexibleQueue() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() throws Exception {
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

    public void mostrar() {
        System.out.print("[");
        for (Celula i = primeiro.prox; i != null ; i = i.prox) {
            System.out.print(i.elemento+" ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        FlexibleQueue Fila = new FlexibleQueue();
        for (int i = 0; i < 10; i++) {
            Fila.inserir(i);
        }
        Fila.mostrar();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Item removido! -> " + Fila.remover());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



}

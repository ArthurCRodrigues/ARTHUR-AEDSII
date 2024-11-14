package HybridList;
public class ListaPilhaMain {
    public static void main(String[] args) {
        ListaPilha listaPilha = new ListaPilha();
        listaPilha.inserir();
        listaPilha.inserir();
        listaPilha.inserir();
        listaPilha.inserir();
        for (int i = 0 ; i < 10; i++) {
            listaPilha.inicio.prox.inserir(i);
        }
        for (int i = 0 ; i < 3; i++) {
            listaPilha.inicio.prox.prox.inserir(i);
        }
        for (int i = 0 ; i < 13; i++) {
            listaPilha.inicio.prox.prox.prox.inserir(i);
        }
        for (int i = 0 ; i < 33; i++) {
            listaPilha.inicio.prox.prox.prox.prox.inserir(i);
        }
        listaPilha.maiorPilha().print();


    }
}

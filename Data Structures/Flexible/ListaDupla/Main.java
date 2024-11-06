public class Main {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        for (int i = 1 ; i <= 5; i++) {
            lista.inserirFim(i);
        }
        lista.print();
        lista.inserirInicio(10);
        lista.print();
        lista.removerInicio();
        lista.print();
        lista.removerFim();
        lista.print();
        System.out.println("Tamanho: "+lista.tamanho());
        lista.inserir(8,2);
        lista.print();
        lista.remover(2);
        lista.print();
        lista.invert();
        lista.print();
    }
}

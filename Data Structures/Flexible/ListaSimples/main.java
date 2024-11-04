public class main {
    public static void main(String[] args) {
        SLinkedList Lista = new SLinkedList(); 
        for (int i = 0 ; i < 10 ; i++) {
            Lista.inserirFim(i);
        }
        System.out.println("Tamanho -> "+ Lista.tamanho());
        Lista.print();
    }
}

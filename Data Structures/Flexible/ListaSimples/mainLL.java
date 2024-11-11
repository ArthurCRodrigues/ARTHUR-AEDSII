public class mainLL {
    public static void main(String[] args) {
        SLinkedList Lista = new SLinkedList(); 
        Lista.inserirFim(10);
        System.out.println(Lista.primeiro.prox.elemento);
    }
}

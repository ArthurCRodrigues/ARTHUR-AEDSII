public class mainLL {
    public static void main(String[] args) {
        SLinkedList Lista = new SLinkedList(); 
        Lista.inserirFim(3);
        Lista.inserirFim(1);
        Lista.inserirFim(6);
        Lista.inserirFim(5);
        Lista.inserirFim(4);
        Lista.inserirFim(2);
        

        Lista.print();
        SLinkedList SortedList = Lista.ListSort();;
        SortedList.print();

    }
}

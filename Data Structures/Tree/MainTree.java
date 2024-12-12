public class MainTree {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(4);
        tree.insert(14);
        tree.insert(2);
        tree.insert(7);
        tree.insert(17);
        tree.insert(16);
        tree.insert(15);
        Node root = tree.root;
        tree.display();
        System.out.println(tree.search(10));
        System.out.println(tree.search(2));
        System.out.println("Max element is: "+tree.findMax());
        System.out.println("Min element is: "+tree.findMin());
        System.out.println("Unbalanced nodes: "+tree.countNodes());
        tree.remove(2);
        tree.remove(6);
        tree.remove(7);
        tree.display();
    }   
}

public class MainTree {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);
        tree.insert(3);
        tree.insert(10);
        tree.insert(2);
        Node root = tree.root;
        tree.display();
        System.out.println(tree.search(10));
        System.out.println(tree.search(2));

    }   
}
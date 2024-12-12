public class MainTree {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(30);
        tree.insert(40);
        tree.insert(20);
        tree.insert(35);
        tree.insert(3);
        tree.insert(10);
        tree.insert(2);
        tree.insert(15);
        Node root = tree.root;
        tree.display();
        System.out.println(tree.search(10));
        System.out.println(tree.search(2));
        System.out.println("Max element is: "+tree.findMax());
        System.out.println("Min element is: "+tree.findMin());
        System.out.println("Height: "+ tree.getHeight());
        tree.insert(19);
        System.out.println("Height: "+ tree.getHeight());
        System.out.println("Nodes: "+ tree.Nodes());

        tree.remove(2);
        tree.remove(6);
        tree.remove(7);
        tree.display();
        
    }   
}

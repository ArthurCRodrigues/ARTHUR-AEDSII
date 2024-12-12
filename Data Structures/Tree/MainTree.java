public class MainTree {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
<<<<<<< HEAD
        tree.insert(30);
        tree.insert(40);
        tree.insert(20);
        tree.insert(35);
        tree.insert(3);
=======
>>>>>>> 3b3acb7ba0dc6b67eb7009c1a729072d60692b12
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
<<<<<<< HEAD
        System.out.println("Height: "+ tree.getHeight());
        tree.insert(19);
        System.out.println("Height: "+ tree.getHeight());
        System.out.println("Nodes: "+ tree.Nodes());

=======
        System.out.println("Unbalanced nodes: "+tree.countNodes());
>>>>>>> 3b3acb7ba0dc6b67eb7009c1a729072d60692b12
        tree.remove(2);
        tree.remove(6);
        tree.remove(7);
        tree.display();
        
    }   
}

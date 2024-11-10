public class Tree {
    public Node root;
    public void insert(Node node) {
        root = insertHelper(node, this.root);
    }
    private Node insertHelper(Node node, Node root_par) {
        int data = node.element;
        if (root_par == null) root_par  = node;
        else if (data > root_par.element) insertHelper(node,root_par.right);
        else insertHelper(node,root_par.left);
        return root_par.left;
    }

}



public class Tree {
    public Node root;
    Tree() {
        this.root = null;
    }
    public void insert(int x) {
        Node node = new Node(x);
        root = insertHelper(node, this.root);
    }
    private Node insertHelper(Node node, Node rootP) {
        int data = node.element;
        if (rootP == null) {
            rootP  = node;
            return rootP;
        }
        else if (data < rootP.element) rootP.left = insertHelper(node,rootP.left);
        else rootP.right = insertHelper(node,rootP.right);
        return rootP;
    }
    public void display() {
        System.out.println("Called Method");
        displayHelper(root);
    }
    private void displayHelper(Node rootP) {
      if (rootP != null) {
        displayHelper(rootP.left);
        System.out.println(rootP.element);
        displayHelper(rootP.right);
      } 
    } 
    public boolean  search(int element) {
        return searchHelper(this.root, element);
    }
    
    private boolean searchHelper(Node rootP,int element) {
        System.out.println("--- Root is currently "+rootP.element+" ---");
        if (rootP == null) {
            System.out.println("NULL!!");
            return false;
        }
        if (rootP.element == element) {
            System.out.println("Found!");
            return true;
        }
        else if (rootP.element > element) {
            System.out.println("Entering recursion for left element (root.element > element)");
            return searchHelper(rootP.left,element);
        } 
        else if (rootP.element < element) {
            System.out.println("Entering recursion for right element (root.element < element)");
            return searchHelper(rootP.right, element);
        }
        return false;
    } 
    public int findMax() {
        return findMaxHelper(this.root);
    }
    private int findMaxHelper(Node rootP) {
        if (rootP.right == null) return rootP.element;
        else return findMaxHelper(rootP.right);
    }
    public int findMin() {
        return findMinHelper(this.root);
    }
    private int findMinHelper(Node rootP) {
        if (rootP.left == null) return rootP.element;
        else return findMinHelper(rootP.left);
        
    }

}

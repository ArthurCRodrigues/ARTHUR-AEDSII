

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
        System.out.print("[ ");
        displayHelper(root);
        System.out.println("]");
    }
    private void displayHelper(Node rootP) {
        if (rootP != null) {
          displayHelper(rootP.left);
          System.out.print(rootP.element+" ");
          displayHelper(rootP.right);
        } 
      }  
    public boolean  search(int element) {
        return searchHelper(this.root, element);
    }
    
    private boolean searchHelper(Node rootP,int element) {
        if (rootP == null) {
            return false;
        }
        if (rootP.element == element) {
            return true;
        }
        else if (rootP.element > element) {
            return searchHelper(rootP.left,element);
        } 
        else if (rootP.element < element) {
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
    public void remove(int element) {
        if (!this.search(element)) {
            return;
        }
        removeHelper(this.root,element);
    }
    private Node removeHelper(Node rootP, int element) {
        if (rootP == null) return rootP;
        else if (element < rootP.element) rootP.left = removeHelper(rootP.left,element);
        else if (element > rootP.element) rootP.right = removeHelper(rootP.right,element);
        else {//node found
            if (rootP.left == null && rootP.right == null) { 
                rootP = null;
            }
            else if (rootP.right != null) { //find a sucessor to replace this node
                rootP.element = findMaxHelper(rootP);
                rootP.right = removeHelper(rootP.right,rootP.element);
            }
            else { //find a predecessor to replace this node
                rootP.element = findMinHelper(rootP);
                rootP.left = removeHelper(rootP.left,rootP.element);
            }
        }
        return rootP;
    }

    

}

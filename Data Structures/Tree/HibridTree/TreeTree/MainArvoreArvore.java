package TreeTree;
public class MainArvoreArvore {
    public static void main(String[] args) {
        ArvoreArvore tree = new ArvoreArvore();

        // Insert characters into the main tree
        tree.insert('b');
        tree.insert('a');
        tree.insert('c');

        // Insert words into the secondary trees
        tree.insert("bat");
        tree.insert("apple");
        tree.insert("ball");
        tree.insert("bill");
        tree.insert("bill");
        tree.insert("bill");
        tree.insert("bill");
        tree.insert("bill");
        tree.insert("cat");
        tree.insert("car");

        // Print the structure
        tree.printTree();
        System.out.println("Words like bill: "+tree.contarPalavras("cat"));
    }
}

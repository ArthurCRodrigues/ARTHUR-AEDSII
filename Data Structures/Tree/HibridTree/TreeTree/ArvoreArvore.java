package TreeTree;
public class ArvoreArvore {
    NodeTT root;
    ArvoreArvore() {
        this.root = null;
    }

    public void insert(char c) {
        this.root = insertHelper(this.root,c);
    }
    private NodeTT insertHelper(NodeTT rootP, char c) {
        if (rootP == null) {
            rootP = new NodeTT(c);
            return rootP;
        }
        else if (rootP.letra > c) rootP.esq = insertHelper(rootP.esq,c);
        else if (rootP.letra < c) rootP.dir = insertHelper(rootP.dir,c);
        return rootP;
    }
    public void insert(String palavra) { 
        char c = palavra.charAt(0);
        NodeTT insertible = search(c);
        if (insertible == null) {
            this.root = insertHelper(root, c);
            insertible = search(c);
        }
        insertible.root = insertIntoSubTree(insertible.root,palavra);
        
    }
    private NodeTT2 insertIntoSubTree(NodeTT2 rootP,String palavra) {
        if (rootP == null) {
            rootP = new NodeTT2(palavra);
            return rootP;
        }
        else if (rootP.palavra.length() > palavra.length()) rootP.esq = insertIntoSubTree(rootP.esq, palavra);
        else {
            rootP.dir = insertIntoSubTree(rootP.dir, palavra);
        }
        return rootP;
    }
    public NodeTT search(char c) {
        return searchHelper(this.root,c);
    }
    private NodeTT searchHelper(NodeTT rootP, char c) {
        if (rootP != null) {
            if (rootP.letra == c) return rootP;
            else if (rootP.letra > c) return searchHelper(rootP.esq,c);
            else if (rootP.letra < c) return searchHelper(rootP.dir,c);
            return rootP;
        }
        else {
            return null;
        }
    }

    public void printTree() {
        printTree(this.root);
    }
    private void printTree(NodeTT rootP) {
        if (rootP!=null) {
            printTree(rootP.esq);
            printTree(rootP.dir);
            System.out.println("Entering tree of char: "+rootP.letra);
            printSubTree(rootP.root);
        }
    }
    private void printSubTree(NodeTT2 rootP) {
        if (rootP!=null) {
            printSubTree(rootP.esq);
            printSubTree(rootP.dir);
            System.out.println("String: "+rootP.palavra);
        }
    }   
    public int contarPalavras(String padrao) {
        char key = padrao.charAt(0);
        NodeTT keyNode = search(key);
        int len = padrao.length();
        return contarPalavras(keyNode.root, len);
    }
    private int contarPalavras(NodeTT2 rootP, int len) {
        if (rootP == null) return 0;
        if (rootP.palavra.length() == len) return 1 + contarPalavras(rootP.dir,len) + contarPalavras(rootP.esq, len);
        else return 0 + contarPalavras(rootP.dir,len) + contarPalavras(rootP.esq, len);
    }


}
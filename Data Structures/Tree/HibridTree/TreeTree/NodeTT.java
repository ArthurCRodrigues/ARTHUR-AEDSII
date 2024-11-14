package TreeTree;
public class NodeTT {
    char letra;
    NodeTT esq,dir;
    NodeTT2 root;
    
    NodeTT(char l) {
        this.letra = l;
        this.esq = this.dir = null;
        this.root = null;
    }
}

public class Matriz {
    CelulaMatriz inicio;
    private int linha,coluna;
    public Matriz() {
        this(3,3);
    }
    public Matriz(int L, int C) {
        int aux = 0;
        inicio = new CelulaMatriz(++aux);
        this.linha = L;
        this.coluna = C;

        CelulaMatriz atual = inicio;
        for (int i = 1; i < coluna; i++) {
            atual.dir = new CelulaMatriz(aux);
            atual.dir.esq = atual; // Conecta as duas celulas entre si
            atual = atual.dir;
            aux++;
            System.out.println("Created Node on index "+i);
        }
        atual = inicio.dir;
        CelulaMatriz ant = inicio;
        for (int i = 1; i < linha; i++) {
            System.out.println("Entering outer loop "+i+"of 4");
            ant.inf = new CelulaMatriz(++aux);
            ant.inf.sup = ant;
            ant = ant.inf;
            for (int j = 1 ; j < coluna; j++) {
                System.out.println("Entering inner loop"+j);
                atual.inf = new CelulaMatriz(++aux);
                atual.inf.sup = atual;
                atual.esq = ant;
                ant.dir = atual;
                atual = atual.dir;
                ant = ant.dir;
            }
            atual = inicio.dir;
            ant = inicio;
            for (int k = 0 ; k < i; k++) {
                atual = atual.inf;
                ant = ant.inf;
                System.out.println("Atual is now element "+atual.elemento);
                System.out.println("Ant is now element "+ant.elemento);
            }

        }

    }
    public void print() {
        System.out.print("[");
        CelulaMatriz i;
        for (int j = 0 ; j < coluna; j++) {
            for ( i = inicio; i.dir != null; i = i.dir) {
                System.out.print(i.elemento+"\t");
            }
            i = inicio.inf;
            for (int k = 0 ; k < j; k++ ) {
                i = i.inf;
            }
        }
    }


}

public class Matriz {
    CelulaMatriz inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int L, int C) {
        int aux = 1;
        inicio = new CelulaMatriz(aux++);
        this.linha = L;
        this.coluna = C;

        CelulaMatriz atual = inicio;
        for (int i = 1; i < coluna; i++) {
            atual.dir = new CelulaMatriz(aux++);
            atual.dir.esq = atual; // Conecta as duas celulas entre si
            atual = atual.dir;

        }
        atual = inicio.dir;
        CelulaMatriz ant = inicio;
        System.err.println("\n");
        for (int i = 1; i < linha; i++) {
            CelulaMatriz test = inicio;
            for (int t = 0; t < i; t++) {
                for (int js = 0; js < coluna; js++) {
                    System.out.print("\t" + test.elemento);
                    test = test.dir;
                }
                test = inicio.inf;
                for (int js = 0; js < t; js++) {
                    test = test.inf;
                }
                System.out.print("\n");
            }
            ant.inf = new CelulaMatriz(aux++);
            ant.inf.sup = ant;
            ant = ant.inf;
            for (int j = 1; j < coluna; j++) {
                atual.inf = new CelulaMatriz(aux++);
                atual.inf.sup = atual;
                atual.inf.esq = ant;
                ant.dir = atual.inf;
                atual = atual.dir;
                ant = ant.dir;
            }
            atual = inicio.dir;
            ant = inicio;
            for (int k = 0; k < i; k++) {
                atual = atual.inf;
                ant = ant.inf;

            }

        }

    }

    public void print() {
        CelulaMatriz printable = inicio;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(printable.elemento + "\t");
                printable = printable.dir;
            }
            printable = inicio.inf;
            for (int k = 0; k < i; k++)
                printable = printable.inf;
            System.out.print("\n");
        }

    }

}

public class CelulaMatriz {
    int elemento;
    CelulaMatriz esq,dir,inf,sup;
    CelulaMatriz() {
        this(0);
    }
    CelulaMatriz(int x) {
        this.elemento = x;
        this.esq = this.dir = this.inf = this.sup = null;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}

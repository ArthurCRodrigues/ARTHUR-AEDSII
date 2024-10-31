
public class CelulaS {
    public int elemento;
    public CelulaS prox1;
    public CelulaS(){
        this(0);
    }
    public CelulaS(int x) {
        this.elemento = x;
        this.prox1 = null;
    }


}

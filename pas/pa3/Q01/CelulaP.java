package Q01;
    public Pokemon elemento;
    public CelulaP prox;
    public CelulaP(){
        this(null);
    }
    public CelulaP(Pokemon x) {
        this.elemento = x;
        this.prox = null;
    }


}

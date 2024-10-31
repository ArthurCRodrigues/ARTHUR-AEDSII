/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private CelulaP primeiro;
	private CelulaP ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new CelulaP();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(Pokemon x) {
		CelulaP tmp = new CelulaP(x);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Pokemon x) {
		ultimo.prox = new CelulaP(x);
		ultimo = ultimo.prox;
  	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public String removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      CelulaP tmp = primeiro;
		primeiro = primeiro.prox;
		Pokemon resp = primeiro.elemento;
      tmp.prox = null;
      tmp = null;
		return "(R) " + resp.getName();
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public String removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima CelulaP:
      CelulaP i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      Pokemon resp = ultimo.elemento; 
      ultimo = i; 
      i = ultimo.prox = null;
		return "(R) " + resp.getName();
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(Pokemon x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(x);
      } else if (pos == tamanho){
         inserirFim(x);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         CelulaP i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         CelulaP tmp = new CelulaP(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public String remover(int pos) throws Exception {
      String resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         CelulaP i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         CelulaP tmp = i.prox;
         Pokemon resp1 = tmp.elemento;
         resp = "(R) " + resp1.getName();
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }
		return resp;
        
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
        int ind = 0;

		for (CelulaP i = primeiro.prox; i != null; i = i.prox) {
            System.out.printf("[%d]",ind);
			System.out.println(i.elemento.imprimir());
            ind++;
		}
		
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public Pokemon pesquisar(int ID) {
		Pokemon resp = null;
		for (CelulaP i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.getId() == ID){
            resp = i.elemento;
            i = ultimo;
         }
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho() {
      int tamanho = 0; 
      for(CelulaP i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}
package Fila.FilaPrioridade;

class Paciente {
    String nome;
    int prioridade;
    public Paciente(String n,  int p ) {
        this.nome = n;
        this.prioridade = p;
    }
}
public class FilaPrioridade {
    private Paciente[] itens;
    private int n;
    public FilaPrioridade(int tam) {
        this.itens = new Paciente[tam];
        this.n = 0;
    }
    public void inserir(Paciente p) {
        int prioridade = p.prioridade;
        int i;
        if (n == 0) {
            this.itens[n] = p;
            n++;
        } else {
            for (i = 0; this.itens[i].prioridade >= prioridade && i < n ; i++ ) {}
            if (i < n) {
                if (n < this.itens.length) {
                    for (int j = n ; j > i; j--) this.itens[j] = this.itens[j-1];
                    this.itens[i] = p; 
                    this.n++;
                } else {
                    System.out.println("Cannot add more itens to the queue!");
                }
            } else {
                this.itens[n] = p;
                this.n++;
            }
        }
    }
    public void display() {
        System.out.print("[");
        for(int i = 0; i < n; i++) {
            System.out.print(this.itens[i].nome+", ");
        }
        System.out.print("]\n");
    }
    public Paciente remover() {
        if (n==0) {
            System.out.println("Fila Vazia!");
            return null;
        } else {
            n--;
            Paciente resp = itens[n];
            for (int i = 0 ; i < n; i++) itens[i] = itens[i+1];
            return resp;
        }
    }

    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade(10);
        fila.inserir(new Paciente("Arthur",1));
        fila.inserir(new Paciente("Gabriel",2));
        fila.inserir(new Paciente("Rafael",4));
        fila.inserir(new Paciente("Pedro",6));
        fila.inserir(new Paciente("Joao",6));
        fila.inserir(new Paciente("Ravi",3));
        fila.display();
        fila.remover();
        fila.display();
        fila.remover();
        fila.display();
    }
}
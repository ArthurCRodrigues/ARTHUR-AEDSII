import java.util.Scanner;

class Carro{
    int inicio;
    int fim;
    
    Carro(int i, int f){
        this.fim = f;
        this.inicio = i;
    }

}

class Stack {
    Carro[] arr;
    int n;

    Stack() {
        this(100);
    }
    Stack(int num) {
        arr = new Carro[num];
        n = 0;
    }
    public void inserir(Carro x) {
        arr[n] = x;
        n++;
    }
    public Carro remover() {
        return arr[--n];
    }
    public boolean cheia(){
        return (n>arr.length);
    }

}

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int carros, vagas;
        carros = scanner.nextInt();
        vagas = scanner.nextInt();
        while (carros > 0 && vagas > 0) {
            Stack pilha = new Stack(vagas);
            Carro[] cars = new Carro[carros];
            //armazena todos os carros
            for(int i =0; i<carros;i++){
                int inicio = scanner.nextInt();
                int fim = scanner.nextInt();

                Carro carro = new Carro(inicio, fim);
                cars[i] = carro;
            }
            boolean made = true;
            for(int i = 1; i<=12; i++){
                for(int j=0; j<carros; j++){

                    if(cars[j].inicio == i ){
                        if (pilha.cheia()) {
                            made = false;
                        }
                        else {
                            pilha.inserir(cars[j]);
                        }
                        
                    }
                    if (cars[j].fim == i) {
                        if (pilha.arr[pilha.n-1] != cars[j]) {
                            made = false;
                        }
                        else {
                            pilha.remover(); 
                        }
                    }
                }
            }
            
            if (made) System.out.println("Sim");
            else System.out.println("Nao");
            carros = scanner.nextInt();
            vagas = scanner.nextInt();
        }

    }
    
}

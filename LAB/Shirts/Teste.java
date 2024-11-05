import java.util.Scanner;

class Request {
    String nome;
    String cor;
    char tam;

    Request(String n, String c, char t) {
        nome = n;
        cor = c;
        tam = t;
    }

    public void print() {
        System.out.print(this.cor + " ");
        System.out.print(this.tam + " ");
        System.out.print(this.nome + "\n");

    }
}

public class Teste {
    public static void sortByColor(Request[] reqs ) {
        
        for (int i = 0 ; i <  reqs.length; i++) {
            Request minCor = reqs[i];
            int ind = i;
            
            for (int j = i ; j < reqs.length; j++) {
                Request currentColor = reqs[j];
                if (currentColor.cor.charAt(0) == minCor.cor.charAt(0)) {
                    if (currentColor.tam == minCor.tam) {
                        int aux;
                        for (aux = 0 ; aux < findMin(minCor.nome, currentColor.nome)-2;aux++) {
                            if (minCor.nome.charAt(aux) != currentColor.nome.charAt(aux)) break;
                        }
                        if (currentColor.nome.charAt(aux) < minCor.nome.charAt(aux)) {
                            minCor = currentColor;
                            ind = j;
                        }
                    }
                    else if (currentColor.tam > minCor.tam) {
                        minCor = currentColor;
                        ind = j;
                    }
                }
                else if (currentColor.cor.charAt(0) < minCor.cor.charAt(0)) {
                    minCor = currentColor;
                    ind = j;
                }
            }
                Request tmp = reqs[i];
                reqs[i] = minCor;
                reqs[ind] = tmp;
            }
        }
    
        public static int findMin(String a, String b) {
        if (a.length() > b.length())
            return b.length();
        else
            return a.length();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        while (N != 0) {
            sc.nextLine();
            Request[] requests = new Request[N];
            
            for (int i = 0; i < N; i++) {
                String nome = sc.nextLine();
                String cor_tam = sc.nextLine();
                
                String cor = cor_tam.split(" ")[0];
                char tam = cor_tam.split(" ")[1].charAt(0);
                
                Request req = new Request(nome, cor, tam);
                requests[i] = req;
            }
            sortByColor(requests);
            
            for (int i = 0; i < N; i++) {
                requests[i].print();
            }

            N = sc.nextInt();
        }
        sc.close();
    }
}

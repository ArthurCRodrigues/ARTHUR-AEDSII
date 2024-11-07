import java.util.Scanner;
public class Exercise2 {
    public static int readOperation(String input){
        String op = input.split(" ")[0];
        
        int resp = -1;
        if (op.equals("PUSH")) resp = 0;
        else if (op.equals("POP")) resp = 1;
        else if (op.equals("MIN")) resp = 2;
        return resp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOp = sc.nextInt();
        Pilha pilha = new Pilha();
        sc.nextLine();
        for (int i = 0 ; i < numOp; i++) {

            String input = sc.nextLine();
            int op = readOperation(input);
            switch (op) {
                case 0:
                    int num = Integer.parseInt(input.split(" ")[1]);
                    try {
                        pilha.add(num);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        pilha.remove();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(pilha.getMin());
                    break;
                
            }
        }
    }
}

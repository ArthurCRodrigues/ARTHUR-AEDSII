import java.util.*;
public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc)
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int dif = num2 - num1;
        for ( int i =  0; i <= dif; i++ ) {
            System.out.print(num1+i);
        }
        for (int i = 0 ; i <= dif; i++) {
            int num = num2-i;
            System.out.print(num%10);
            if (num >= 10) System.out.print(num/10);

            
        }

    }
}

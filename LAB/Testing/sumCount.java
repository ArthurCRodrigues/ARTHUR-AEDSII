package LAB.Testing;

public class sumCount {
    public static int calcula(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        int conta = 0;
        
        for (int i = 1; i <= n; i++) {
            a *= 2;
            conta++;
            for (int j = 1; j <= i; j++) {
                b *= 2;
                c *= 2;
                conta += 2;
            }
        }
        return conta;
    }
    
    public static void main(String[] args) {
        System.out.println(calcula(12));
    }
    
}

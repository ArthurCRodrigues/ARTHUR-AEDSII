import java.io.*;
import java.util.Scanner;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try (RandomAccessFile file = new RandomAccessFile("integers.txt", "rw")) {
            // Lendo o numero de inteiros a serem adicionados ao arquivo
            int n = sc.nextInt();
            
            // Adicionando os inteiros no arquivo
            for (int i = 0; i < n; i++) {
                int number = sc.nextInt();
                file.writeInt(number);
            }

            // Calcula o numero de inteiros no arquivo
            long numIntegers = file.length() / 4;

            // Lendo os inteiros em ordem reversa
            for (long i = numIntegers - 1; i >= 0; i--) {
                file.seek(i * 4);
                int number = file.readInt();
                System.out.println(number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close(); // Fecha o Scanner.
        }
    }
}

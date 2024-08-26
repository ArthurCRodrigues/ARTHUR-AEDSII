import java.util.Scanner;
public class recursivePalindrome {
    private static int isPalindromePrivate(String word,int head, int tail) {

        if (head >= tail) {
            return 0;
        } 
        if (word.charAt(head) != word.charAt(tail)) {
            return 1;
        }
        else {
            return isPalindromePrivate(word,head + 1, tail - 1);
        }

    }
    public static void isPalindrome(String word) {
        if (isPalindromePrivate(word, 0, word.length()-1) == 0) { // Pass the correct indices for the entire word
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wrd = sc.nextLine();
        while (!wrd.equals("FIM")) {
            isPalindrome(wrd);
            wrd = sc.nextLine(); 
        }

        sc.close();
    }
}

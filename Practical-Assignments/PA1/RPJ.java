import java.util.Scanner;
public class RPJ {
    private static int isPalindromePrivate(String word,int head, int tail) {
        int len = word.length();
        int cmp = len - tail;
        if (len == 1) {
            return 0;
        } 
        if (word.charAt(head) != word.charAt(cmp)) {
            return 1;
        }
        return isPalindromePrivate(word,head+1, tail -1);

    }
    public static void isPalindrome(String word) {
        if (isPalindromePrivate(word, 0, 1) == 0) {
            System.out.println("SIM");
        }
        if (isPalindromePrivate(word, 0, 0) == 1) {
            System.out.println("NAO");
        }
        else {
            System.out.println("Unknown Error");
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

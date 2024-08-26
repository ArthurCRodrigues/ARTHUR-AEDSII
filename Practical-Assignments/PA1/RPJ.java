import java.util.Scanner;
public class RPJ {
    private static int isPalindromePrivate(String word,int head, int tail) {
        int len = word.length();
        int cmp = len - tail;
        System.out.println("HEAD -> "+head);
        System.out.println("CMP -> "+cmp);

        if (head == cmp) {
            return 0;
        } 
        if (word.charAt(head) != word.charAt(cmp)) {
            return 1;
        }
        else {
            return isPalindromePrivate(word,head + 1, tail + 1);
        }

    }
    public static void isPalindrome(String word) {
        if (isPalindromePrivate(word, 0, 1) == 0) {
            System.out.println("SIM");
            return;
        }
        if (isPalindromePrivate(word, 0, 1) == 1) {
            System.out.println("NAO");
            return;
        }
        else {
            System.out.println("Unknown Error");
            return;
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

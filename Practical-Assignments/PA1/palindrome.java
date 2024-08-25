import java.util.Scanner;
public class palindrome {
    
    public static int isPalindrome(String wrd) {
        int lgt = wrd.length();
        int lst_indx = lgt - 1;
        for (int i = 0; i < lgt && i != lst_indx; i++) {
            if (wrd.charAt(i) != wrd.charAt(lst_indx)) {
                return 0;
            }
            lst_indx -= 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wrd = sc.nextLine();
        
        while (!wrd.equals("FIM")) {
            String resp = isPalindrome(wrd) == 1 ? "SIM" : "NAO";
            System.out.println(resp);
            wrd = sc.nextLine(); 
        }
        
        sc.close();
    }
}


import java.util.Scanner;

public class ParenthesisCheck {
    private static boolean isOpeningParenthesis(char ch) {
        return ch == '(' ;
    }
    private static boolean isClosingParenthesis(char ch) {
        return ch == ')' ;
    }
    public static boolean  parenthesisCheck(String expression) {
        int opening = 0;
        int closing = 0;
        for (int i = 0 ; i < expression.length(); i++) {
            if (isOpeningParenthesis(expression.charAt(i))) opening++;
            else if (isClosingParenthesis(expression.charAt(i))) {
                if (opening == 0) return false;
                else closing++;
            }
        }
        return opening == closing;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wrd = sc.nextLine();
        while (!wrd.equals("FIM")) {
            if (parenthesisCheck(wrd)) System.out.println("correto");
            else System.out.println("incorreto");
            wrd = sc.nextLine(); 
        }

        sc.close();
    }
}
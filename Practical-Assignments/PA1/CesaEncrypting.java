import java.util.Scanner;

public class CesaEncrypting {

   public static int getCode(char x) {
      return (int) x; 
   }

   public static char getChar(int x) {
      return (char) x;
   }

   public static String encrypt(String wrd) {
      String newString = "";
      for (int i = 0; i < wrd.length(); i++) {
         char x = wrd.charAt(i);

         if (x == ' ') { 
            newString += '#'; 
         } else if (x == '-') { 
            newString += '0'; 
         } else if (Character.isLetter(x) || Character.isDigit(x)) {
            int code = getCode(x);
            newString += getChar(code + 3);
         } else {
            newString += x; 
         }
      }
      return newString;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String wrd = sc.nextLine();
      while (!wrd.equals("FIM")) {
         System.out.println(encrypt(wrd));
         wrd = sc.nextLine(); 
      }
      
      sc.close();
   }
}

//recursive cesar encrypting algorithm

import java.util.Scanner;

public class RCE {
    public static int getCode(char x) {
        return (int) x; 
     }
  
     public static char getChar(int x) {
        return (char) x;
     }

     private static String encrypt(String wrd, String newString,int index) {
        
        if (newString.length() == wrd.length()) {
            return newString;
        }
        char x = wrd.charAt(index);
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
         return encrypt(wrd, newString, index+1);
     }
     public static String encrypt(String wrd) {
        String retString = "";
        return encrypt(wrd, retString, 0);
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


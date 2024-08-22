import java.util.*;
public class randomSwitch {
    public static String Switch(String wrd) {
        Random gerador = new Random();
        gerador.setSeed(4);
        char char1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char char2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        System.out.println(char1);
        System.out.println(char2);

        String newstring = "";
        for (int i = 0 ; i < wrd.length() ; i++) {
            if (wrd.charAt(i) == char1) {
                newstring += char2;
            }
            else {
                newstring += wrd.charAt(i);
            }
        }
        return newstring;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wrd = sc.nextLine();
        while (!wrd.equals("FIM")) {
            System.out.println(Switch(wrd));
            wrd = sc.nextLine(); 
        }
        
        sc.close();
    }
}

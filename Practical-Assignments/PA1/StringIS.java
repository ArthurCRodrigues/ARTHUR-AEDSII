public class StringIS {
    public static String vowels(String input) {
        for (int i = 0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            c = Character.toLowerCase(c);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return "NAO ";
            }
        } 
        return "SIM ";
    }
    public static String conso(String input) {
        for (int i = 0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            c = Character.toLowerCase(c);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "NAO ";
            }
            if (c >= '0' && c <= '9') {
                return "NAO ";
            }
        }
        return "SIM "; 
    }
    public static String integers(String input) {
        for (int i = 0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return "NAO ";
            }
        }
        return "SIM ";
    }
    public static String realNum(String input) {
        for (int i = 0; i< input.length(); i++) {
            char c = input.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                if (c != '.') {
                    return "NAO\n";
                } 
            }
        }
        return "SIM\n";
    }
    public static void main(String[] args) {
        String input = MyIO.readLine(); 
 
        while (!input.equals("FIM")) {
            String vowel = vowels(input); 
            MyIO.print(vowel); 
            String consonants = conso(input);
            MyIO.print(consonants);
            String integer = integers(input);
            MyIO.print(integer);
            String realNum = realNum(input);
            MyIO.print(realNum);
            input = MyIO.readLine(); 
        }
    }
}

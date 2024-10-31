public class recursiveStringIS {
    private static String vowels(String input,int index, int len) {
        if (index == len)  return "SIM ";
        char c = input.charAt(index);
        c = Character.toLowerCase(c);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') return "NAO ";
        
        return vowels(input, index+1,len);
    }
    private static String conso(String input,int index, int len) {
            if (index == len) return "SIM ";
            char c = input.charAt(index);
            c = Character.toLowerCase(c);
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "NAO ";
            
            if (c >= '0' && c <= '9') return "NAO ";
            
            return conso(input,index+1,len);
        }
        
    
    private static String integers(String input,int index, int len) {
            if (index == len) return "SIM ";
            char c = input.charAt(index);
            if (!(c >= '0' && c <= '9')) return "NAO ";
            return integers(input,index+1,len);
        }
    
    private static String realNum(String input,int index, int len, boolean  hasDot) {
            if (index == len && hasDot) return "SIM\n";
            else if (index == len && !hasDot) return "NAO\n";
            char c = input.charAt(index);
            if (!(c >= '0' && c <= '9')) {
                if ((c != '.' && c != ',') || hasDot) return "NAO\n";
                else return realNum(input,index+1,len,true);
            }
            return realNum(input,index+1,len,hasDot);
    }
    public static String vowels(String input) {
        return vowels(input,0,input.length());
    }
    public static String conso(String input) {
        return conso(input,0,input.length());
    }
    public static String integers(String input) {
        return integers(input,0,input.length());
    }
    public static String realNum(String input) {
        return realNum(input,0,input.length(),false);
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

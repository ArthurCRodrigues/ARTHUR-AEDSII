public class CaesarCipher {


    public static String encrypt(String input) {
        String encrypted = ""; //Cria a nova String a qual os caracteres criptografados serão adicionados

        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            
            char ch = (char) (x + 3); // Adiciona o caractere criptografado à uma nova variavel
            
            encrypted += ch; // Adiciona o novo caractere à String
        }

        return encrypted;
    }

    public static void main(String[] args) {
        String input = MyIO.readLine(); 

        while (!input.equals("FIM")) {
            String encryptedMessage = encrypt(input); 
            MyIO.println(encryptedMessage); 
            input = MyIO.readLine(); 
        }
    }
}

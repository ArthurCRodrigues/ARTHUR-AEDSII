public class recursiveCaesarCipher {


   private static String encrypt(String input, String newString,int index,int len) {
        if (index == len) {
            return newString; //Caso base, testa se o índice atual já é igual ao tamanho da string. 
        }
        char x = input.charAt(index);
           
        char ch = (char) (x + 3); // Adiciona o caractere criptografado à uma nova variavel
           
        newString += ch; // Adiciona o novo caractere à String

        return encrypt(input, newString, index+1, len); //Chamada recursiva com índice do próximo elemento da String (input[i+1])
   }

   public static String encrypt(String input) {
        return encrypt(input, "", 0,input.length());
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

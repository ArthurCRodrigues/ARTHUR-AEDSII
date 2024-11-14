package ListTree;
public class Contato {
    public String nome;
    public String telefone;
    public String email;
    int CPF;
    Contato (String nome, String telefone, String email, int CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CPF = CPF;
    }
    public void print(){
        System.out.print("Nome: "+this.nome+" ");
        System.out.print("Telefone: "+this.telefone+" ");
        System.out.print("Email: "+this.email+" ");
        System.out.print("CPF: "+this.CPF+" ");
        System.out.println();
    }
}

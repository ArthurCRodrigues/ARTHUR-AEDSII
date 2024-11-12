

public class MainHB {
    public static void main(String[] args) {
        char[] letters = {'A','B','C','D','E'};
        Agenda agenda = new Agenda(letters);
        agenda.display();
        agenda.inserir(new Contato("Arthur Carvalho","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Andre Borges","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Beatriz Carvalho","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Camila Cardoso","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Caio Mesquita","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Diogo Defante","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.inserir(new Contato("Eloisa Martins","(31) 9824645-15","arthurcarvalhorodrigues2409@gmail.com",95874));
        agenda.display();
        

    }
    
}

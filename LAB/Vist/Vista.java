import java.util.*;

class Pessoa{
    String nome;
    String horario;
    Pessoa (String input) {
        this.nome = input.split(" ")[1];
        this.horario = input.split(" ")[0];
    }
    public String getHora() {
        return horario.split(":")[0];
    }
    public String getMinuto() {
        return horario.split(":")[1];
    }
    public void display() {
        System.out.println(this.nome + " " +getHora()+":"+getMinuto());
    }
    public int getDif() {
        if (this.getHora().compareTo("00") == 0) {
            return Integer.parseInt(getMinuto());
        } else {
            return 60 - Integer.parseInt(getMinuto());
        }
    }
    public boolean whosFirst(Pessoa cmp) {
        return this.getHora().compareTo("00") == 0 && cmp.getHora().compareTo("23") == 0;
    }
    public boolean whosFirst2(Pessoa cmp) {
        return this.getHora().compareTo("00") == 0 && cmp.getHora().compareTo("00") == 0;
    }
    public boolean whosEqual(Pessoa cmp) {
        return this.getHora().compareTo("23") == 0 && cmp.getHora().compareTo("23") == 0;
    }
}

public class Vista {

    public static void SortPeople(Pessoa[] people,int size) {
        
        for (int i = 0; i < size; i++) {
            Pessoa maior = people[i];
            int maiorI = i;
            for (int j = i; j < size; j++) {
                if (Integer.parseInt(maior.getHora()) < Integer.parseInt(people[j].getHora())) {
                    maior = people[j];
                    maiorI = j;
                } else {

                    if (maior.whosEqual(people[j])) {
                        if (maior.getDif() < people[j].getDif()) {
                            maior = people[j];
                            maiorI = j;
                        }
                    }
                    else if (maior.whosFirst2(people[j])) {
                        if (maior.getDif() > people[j].getDif()) {
                            maior = people[j];
                            maiorI = j;
                        }
                    }
            }
            }
            Pessoa temp = maior;
            people[maiorI] = people[i];
            people[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int range = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();
        Pessoa []people = new Pessoa[num];
        int index = 0;
        for (int i = 0 ; i < num; i++) {
            String input = sc.nextLine();
            Pessoa person = new Pessoa(input);
            
            int minute = Integer.parseInt(person.getMinuto());
            if (person.getHora().compareTo("00") == 0) {
                if (minute < range) {
                    people[index] = person;
                    index++;
                }
            } else if (person.getHora().compareTo("23") == 0) {
                if (60-minute < range) {
                    people[index] = person;
                    index++;
                }
            }
        }
        SortPeople(people,index);
        for (int i = 0 ; i < index; i++) {
            System.out.println(people[i].nome);
        }
        
        

    }
    
}

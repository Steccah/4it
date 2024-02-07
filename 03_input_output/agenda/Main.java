import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda a = new Agenda();

        char scelta = ' ';
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Leggi contatti");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextLine().charAt(0);

            switch (scelta) {
                case '1':
                    String nome, cognome, telefono;
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Cognome: ");
                    cognome = scanner.nextLine();
                    System.out.print("Telefono: ");
                    telefono = scanner.nextLine();
                    a.aggiungiContatto(nome, cognome, telefono);
                    break;
                case '2':
                    a.leggiContatti();
                    break;
                case '3':
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}
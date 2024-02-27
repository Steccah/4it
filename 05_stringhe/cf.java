import java.io.*;
import java.util.Scanner;

/**
 * cf
 */
public class cf {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci nome, cognome, anno, mese, giorno, sesso e comune");
        String nome = in.nextLine().toUpperCase();
        String cognome = in.nextLine().toUpperCase();
        String anno = in.nextLine().toUpperCase();
        String mese = in.nextLine().toUpperCase();
        String giorno = in.nextLine().toUpperCase();
        String sesso = in.nextLine().toUpperCase();
        String comune = in.nextLine().toUpperCase();

        String cf = "";

        // Consonanti del cognome
        String voc = "";
        for (String c : cognome.split("")) {
            if (!"AEIOU".contains(c)) {
                cf += c;
            } else {
                voc += c;
            }
        }
        cf += voc;
        cf += "XXX";
        cf = cf.substring(0, 3);

        // Consonanti del nome
        voc = "";
        String cons = "";
        for (String c : nome.split("")) {
            if (!"AEIOU".contains(c)) {
                cons += c;
            } else {
                voc += c;
            }
        }

        if (cons.length() > 3) {
            cf += cons.charAt(0) + cons.charAt(2) + cons.charAt(3);
        } else {
            cf += cons;
            cf += voc;
            cf += "XXX";
            cf = cf.substring(0, 6);
        }

        // Anno
        cf += anno.substring(2, 4);

        // Mese
        String mesi = "ABCDEHLMPRST";
        cf += mesi.charAt(Integer.parseInt(mese) - 1);

        // Giorno
        if (sesso.equals("M")) {
            cf += giorno;
        } else {
            cf += Integer.parseInt(giorno) + 40;
        }

        // Comune
        try {
            BufferedReader br = new BufferedReader(new FileReader("comuni.txt"));
            String s = br.readLine();
            while (s != null) {
                if (s.contains(comune)) {
                    cf += s.split("\t")[1];
                    break;
                }
                s = br.readLine();
            }
            if (s == null) {
                System.out.println("Comune non trovato");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e);
        }

        // Carattere di controllo
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] dispari = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24,
                23 };
        int somma = 0;

        for (int i = 0; i < cf.length(); i++) {
            String c = cf.charAt(i) + "";
            if (i % 2 == 0) {
                if ("0123456789".contains(c)) {
                    somma += dispari[Integer.parseInt(c)];
                } else if (alfabeto.contains(c)) {
                    somma += dispari[alfabeto.indexOf(c)];
                }
            } else {
                if ("0123456789".contains(c)) {
                    somma += Integer.parseInt(c);
                } else if (alfabeto.contains(c)) {
                    somma += alfabeto.indexOf(c);
                }
            }
        }

        cf += alfabeto.charAt(somma % 26);

        System.out.println(cf);
    }
}
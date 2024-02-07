import java.io.*;

public class Agenda {

    public Agenda() {
    }

    public void aggiungiContatto(String nome, String cognome, String telefono) {
        Contatto c = new Contatto(nome, cognome, telefono);
        c.scrivi(cognome + ".dat");
        // in agenda.txt add a line with the name of the file
        try {
            FileWriter fw = new java.io.FileWriter("agenda.txt", true);
            fw.write(cognome + ".dat\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void leggiContatti() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("agenda.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                Contatto c = new Contatto();
                c.leggi(line);
                System.out.println(c.getNome() + " " + c.getCognome() + " " + c.getTelefono());
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

}

import java.io.*;

public class Contatto implements Serializable {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public Contatto() {
        this("", "", "");
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void leggi(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Contatto c = (Contatto) ois.readObject();
            this.nome = c.getNome();
            this.cognome = c.getCognome();
            this.telefono = c.getTelefono();
            ois.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void scrivi(String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
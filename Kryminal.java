package client;

public class Kryminal extends Ksiazka {
    String opisKsiazki;
    String motywPowiesci;
    public Kryminal(String tytul, String opis, String motyw) {
        super(tytul);
        opisKsiazki = opis;
        motywPowiesci = motyw;
    }
    
    public String dajRodzaj() {
        return "Kryminal";
    }
    public String dajOpis() {
        return opisKsiazki;
    }
    public void Motyw() {
        System.out.println(motywPowiesci);
    }
}

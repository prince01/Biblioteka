package client;

public class KsiazkaFantastyczna extends Ksiazka {
    String opisKsiazki;
    String bohaterowie;
    public KsiazkaFantastyczna(String tytul, String opis, String heroes) {
        super(tytul);
        opisKsiazki = opis;
        bohaterowie = heroes;
    }
    
    public String dajRodzaj() {
        return "Ksiazka Fantastyczna";
    }
    public String dajOpis() {
        return opisKsiazki;
    }
    public void Bohaterowie() {
        System.out.println(bohaterowie);
    }
}

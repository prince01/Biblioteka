package client;

public class Epopeja extends Ksiazka {
    String opisKsiazki;
    String okolicznosciPowstania;
    public Epopeja(String tytul, String opis, String okolicznosci) {
        super(tytul);
        okolicznosciPowstania = okolicznosci;
        opisKsiazki = opis;
    }
    
    public String dajRodzaj() {
        return "Epopeja";
    }
    public String dajOpis() {
        return opisKsiazki;
    }
    public void okolicznosciPowstania() {
        System.out.println(okolicznosciPowstania);
    }
}

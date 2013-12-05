package client;

public class KsiazkaNaukowa extends Ksiazka {
    String opisKsiazki;
    String PodstawoweTerminy;
    public KsiazkaNaukowa(String tytul, String opis, String terminy) {
        super(tytul);
        opisKsiazki = opis;
        PodstawoweTerminy = terminy;
    }
    
    public String dajRodzaj() {
        return "Ksiazka Naukowa";
    }
    public String dajOpis() {
        return opisKsiazki;
    }
    public void Terminy() {
        System.out.println(PodstawoweTerminy);
    }
}

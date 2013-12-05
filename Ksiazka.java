package client;

public class Ksiazka {
    String tytul;
            boolean czyWypozyczona;

            public Ksiazka( String tytul )
            {
                    this.tytul = tytul;
            }

            public void wypozycz()
            {
                    czyWypozyczona = true;
            }
            
            public void oddaj()
            {
                    czyWypozyczona = false;
            }

            public boolean czyWypozyczona()
            {
                    return czyWypozyczona;
            }

            public String dajTytul()
            {
                    return tytul;
            }

            public String dajRodzaj()
            {
                    return "Nieznany";
            }

            public String dajOpis()
            {
                    return "Brak opisu";
            }

            public static void main( String[] argumenty ) 
            {
                    Ksiazka przykladowa = new Ksiazka( "Pan Tadeusz" );
                    System.out.println( "Tytul: (powinno byc Pan Tadeusz) " + przykladowa.dajTytul() );
                    System.out.println( "Czy wypozyczona (powinna byc false)? " + przykladowa.czyWypozyczona() );
                    przykladowa.wypozycz();
                    System.out.println( "Czy wypozyczona (powinno byc true)? " + przykladowa.czyWypozyczona() );
                    przykladowa.oddaj();
                    System.out.println( "Czy wypozyczona (powinno byc false)? " + przykladowa.czyWypozyczona() );   
            }
}

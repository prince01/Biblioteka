package client;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;
import java.io.StreamTokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Biblioteka {
    String adresBiblioteki;
    List<Ksiazka> ksiazki;
    
    public Biblioteka(String adres) {
        ksiazki = new ArrayList<Ksiazka>();
        adresBiblioteki = adres;
    }
    
    public void dodajKsiazke(Ksiazka k){
        ksiazki.add(k);
    }
    
    public static void wypiszGodzinyOtwarcia() {
        System.out.println("Biblioteki s¹ otwarte codziennie od 9:00 do 17:00");
    }
    
    public void wypiszAdres() {
        System.out.println(adresBiblioteki);
    }
    
    void wypiszDaneOKsiazce(String tytul) {
        Ksiazka k = new Ksiazka("");
        for(Ksiazka kk : ksiazki)
        if(kk.dajTytul() == tytul)
        {
        k = kk;
        break;
        }
        if(k.dajTytul() != "")
        {
            System.out.println("Nazwa ksiazki: " + k.dajTytul());
            System.out.println("Rodzaj ksiazki: " + k.dajRodzaj());
            System.out.println("Opis ksiazki: " + k.dajOpis());
            
            if(k.dajRodzaj() == "Epopeja")
            {
                Epopeja e;
                e = (Epopeja) k;
                System.out.println("Okolicznosci powstania: ");
                e.okolicznosciPowstania();
            }
            else if(k.dajRodzaj() == "Ksiazka Fantastyczna") {
                KsiazkaFantastyczna kf;
                kf = (KsiazkaFantastyczna) k;
                System.out.println("Bohaterowie powiesci: ");
                kf.Bohaterowie();
            }
            else if(k.dajRodzaj() == "Kryminal") {
                Kryminal kk = (Kryminal) k;
                System.out.println("Motyw powiesci: ");
                kk.Motyw();
            }
            else if(k.dajRodzaj() == "Ksiazka naukowa") {
                KsiazkaNaukowa kn = (KsiazkaNaukowa) k;
                System.out.println("Podstawowe terminy: ");
                kn.Terminy();
            }
        }
    }
    
    
    public void wypozyczKsiazke(String tytul){
        boolean znalazlem = false;
        for(Ksiazka k : ksiazki)
        if(k.dajTytul() == tytul)
        {
            znalazlem = true;
            if(!k.czyWypozyczona()) {
                k.wypozycz();
                
                System.out.println("Udalo sie wypozyczyc ksiazke: " + tytul);
                return;
            }
        }
        if(znalazlem)
            System.out.println("Przykro nam, ale ksiazka jest juz wypozyczona");
        else
            System.out.println("Przykro nam, ale nie mamy takiej ksiazki.");
    }
    
    public void wypiszDostepneKsiazki() {
        if(ksiazki.size() == 0) {
            System.out.println("Brak ksiazek w bibliotece.");
            return;
        }
        for(Ksiazka k : ksiazki)
        if(!k.czyWypozyczona())
            System.out.println(k.dajTytul());
    }
    
    public void oddajKsiazke(String tytul){
        boolean znalazlem = false;
        for(Ksiazka k : ksiazki)
        if(k.dajTytul() == tytul)
        {
            znalazlem = true;
            if(k.czyWypozyczona()) {
                k.oddaj();
                
                System.out.println("Udalo sie zwrocic ksiazke: " + tytul);
                return;
            }
        }
        if(znalazlem)
            System.out.println("Przykro nam, ale ksiazka jest juz oddana");
        else
            System.out.println("Przykro nam, ale nie mamy takiej ksiazki.");
    }
    public static void main(String[] args) {
                        Biblioteka pierwsza = new Biblioteka( "Armi Krajowej 24" );
                        Biblioteka druga = new Biblioteka( "Plac Grunwaldzki 6" );

                        //Dodaj cztery ksiazki do pierwszej biblioteki
                        pierwsza.dodajKsiazke( new Epopeja( "Pan Tadeusz", "Litwo, Ojczyzno moja! ty jesteœ jak zdrowie;\n" + 
                        "Ile ciê trzeba ceniæ, ten tylko siê dowie,\n" + 
                        "Kto ciê straci³. Dziœ piêknoœæ tw¹ w ca³ej ozdobie\n" + 
                        "Widzê i opisujê, bo têskniê po tobie.", "Wed³ug Józefa Bohdana Zaleskiego, przyjaciela Adama Mickiewicza, pomys³ „poematu sielskiego” narodzi³ siê ju¿ w 1831 podczas pobytu wieszcza w Wielkopolsce. Poeta mia³ rozpocz¹æ go od opisu dworku szlacheckiego[2]. Z kolei Józef Grabowski, w³aœciciel wsi £ukowo, utrzymywa³ póŸniej, ¿e to w jego miejscowoœci Mickiewicz powzi¹³ postanowienie napisania Pana Tadeusza. Dok³adne fakty na ten temat jednak nie s¹ znane. Badacze przypuszczaj¹, ¿e poeta napisa³ wówczas oko³o sto kilkadziesi¹t wersów opisuj¹cych Soplicowo (w ostatecznym kszta³cie fragment ten ma siê koñczyæ na 174 wersie I ksiêgi)[3]. Poeta jednak – po napisaniu tego fragmentu – nie rozwija³ tekstu przez kilkanaœcie nastêpnych miesiêcy." ) );
                        pierwsza.dodajKsiazke( new KsiazkaFantastyczna( "Gra o Tron", "Siedem rodzin szlacheckich walczy o panowanie nad ziemiami krainy Westeros. Polityczne i seksualne intrygi s¹ na porz¹dku dziennym. Pierwszorzêdne role wiod¹ rodziny: Stark, Lannister i Baratheon. Robert Baratheon, król Westeros, prosi swojego starego przyjaciela, Eddarda Starka, aby s³u¿y³ jako jego g³ówny doradca. Eddard, podejrzewaj¹c, ¿e jego poprzednik na tym stanowisku zosta³ zamordowany, przyjmuje propozycjê, aby dog³êbnie zbadaæ sprawê.", "Eddard Stark – nazywany Nedem, w³adca Winterfell, zamku po³o¿onego na pó³nocy krainy Westeros. Posiada wielu wasali, a jego ród nale¿y do najstarszych i najbardziej licz¹cych siê w królestwie. Jest starym przyjacielem króla Roberta Baratheona, z którym obali³ rz¹dy ostatniego z Targaryenów, Aerysa Ob³¹kanego. Ma szeœcioro dzieci: Robba, Sansê, Aryê, Brandona i Rickona, których matk¹ jest jego ¿ona lady Catelyn Tully, a tak¿e bêkarta – Jona Snowa.\n" + 
                        "Catelyn Stark – ¿ona Eddarda Starka, pochodz¹ca z rodu Tullych.\n" + 
                        "Sansa Stark – dwunastoletnia córka Eddarda Starka. Sansa jest przeciwieñstwem swojej siostry Aryi, z któr¹ nierzadko siê k³óci. Jest dobrze wychowana, interesuje siê legendami i opowieœciami o wielkich rycerzach, lubi plotkowaæ.\n" + 
                        "Arya Stark – dziesiêcioletnia córka Eddarda Starka. W przeciwieñstwie do Sansy, Arya jest urodzon¹ wojowniczk¹ i interesuje siê jazd¹ konn¹ oraz broni¹. Czêsto bywa nieznoœna. Bardzo lubi swojego przyrodniego brata, Jona.\n" + 
                        "Brandon Stark – oœmioletni syn Neda Starka, przez znajomych nazywany po prostu Branem. Jego pasj¹ jest wspinaczka.\n" + 
                        "Jon Snow – piêtnastoletni bêkart Neda Starka. Marzy o wst¹pieniu do Nocnej Stra¿y, interesuje siê broni¹ i walk¹.\n" + 
                        "Tyrion Lannister – syn lorda Tywina Lannistera. Jest kar³em, przez co inni z niego szydz¹, mimo ¿e jest bardzo inteligentny. Ma brata Jaimego i siostrê Cersei.\n" + 
                        "Daenerys Targaryen – córka Aerysa Ob³¹kanego, która po buncie w Westeros musia³a uciekaæ wraz ze swoim bratem Viserysem." ) );
                        pierwsza.dodajKsiazke( new Kryminal( "Tozsamosc Bourne'a", "powieœæ sensacyjna z 1980 roku, której autorem jest amerykañski pisarz Robert Ludlum. Pierwsza, rozpoczynaj¹ca 3 tomow¹ powieœæ, ksi¹¿ka opisuj¹ca przygody Jasona Bourne'a. Zosta³a zekranizowana po raz pierwszy jako miniserial w roku 1988 i nastêpnie jako film sensacyjny w 2002 w re¿yserii Douga Limana. Ksi¹¿ka jest inspirowana postaci¹ terrorysty Ilicza Ramireza Sancheza znanego jako Carlos i Szakal.", "Tajemniczego mê¿czyznê wy³owionego z morza ratuje grupa rybaków. Pod okiem lekarza – uciekiniera, dochodzi on jednak do pe³ni si³ fizycznych. Po przebytym urazie g³owy, krzepki, szarozielononiebieskooki mê¿czyzna nie pamiêta nic ze swojej przesz³oœci. Nie pamiêta ¿adnych faktów ze swojego ¿ycia. Dysponuj¹c jedynie poszlakami rusza \"wstecz\" by odkryæ swoj¹ to¿samoœæ. Jednak z ka¿d¹ sekund¹ dowiaduje siê, ¿e przez ca³e \"poprzednie\" ¿ycie tylko od niej ucieka³. Wykorzystywa³ do tego swój trudny do jednoznacznego okreœlenia wygl¹d, dziêki któremu przybiera³ ró¿ne oblicza. Kolejne wydarzenia i dziwnie znajome uczucia co do nieznanych mu miejsc czy wydarzeñ, pomimo amnezji, wprowadzaj¹ go w nieustanny ob³êd. Wie jedynie, ¿e ktoœ usi³uje go zabiæ, i co najgorsze – jemu równie¿ przychodzi to bez trudu. W swej podœwiadomoœci wie ¿e potrafi zrobiæ wszystko, byle by tylko przetrwaæ, jak równie¿ uzyskaæ odpowiedŸ na pytanie – \"Kim jest?\"." ) );
                        pierwsza.dodajKsiazke( new KsiazkaNaukowa( "Analiza Matematyczna", "zespó³ teorii obejmuj¹cy wiele wa¿nych dzia³ów matematyki.\n" + 
                        "Pocz¹tkowo analiza matematyczna obejmowa³a jedynie to, co dzisiaj nazywamy rachunkiem ró¿niczkowym i ca³kowym. Jej rozwój zainicjowa³y prace Leibniza i Newtona z pocz¹tku XVII wieku.\n" + 
                        "Z czasem rachunek ró¿niczkowy i ca³kowy, ograniczaj¹cy siê wczeœniej do kartezjañskich przestrzeni rzeczywistych, obj¹³ swoim zakresem inne przestrzenie: przestrzenie zespolone (teoria funkcji holomorficznych), przestrzenie Banacha i Hilberta (wraz z odpowiadaj¹cymi im teoriami) oraz bardziej zaawansowane twory geometryczne (na przyk³ad rozmaitoœci ró¿niczkowalne).\n" + 
                        "Zaawansowanej analizy matematycznej nie mo¿na obecnie uprawiaæ bez znajomoœci algebry, topologii (w tym topologii algebraicznej) czy geometrii ró¿niczkowej.", "W miarê rozwi¹zywania kolejnych problemów stawianych przez analizê matematyczn¹ powstawa³y zupe³nie nowe dzia³y matematyki, które dziœ wchodz¹ w sk³ad analizy:\n" + 
                        "algebry Banacha i analiza harmoniczna,\n" + 
                        "analiza funkcjonalna,\n" + 
                        "funkcje specjalne,\n" + 
                        "funkcje zmiennej zespolonej (jednej zmiennej),\n" + 
                        "funkcje zespolone wielu zmiennych,\n" + 
                        "rachunek wariacyjny,\n" + 
                        "rozmaitoœci ró¿niczkowalne,\n" + 
                        "równania ca³kowe,\n" + 
                        "przekszta³cenie Mellina,\n" + 
                        "równania ró¿niczkowe cz¹stkowe,\n" + 
                        "równania ró¿niczkowe zwyczajne,\n" + 
                        "teoria dystrybucji,\n" + 
                        "teoria form ró¿niczkowych,\n" + 
                        "teoria miary i ca³ki,\n" + 
                        "teoria reprezentacji grup Liego,\n" + 
                        "teoria szeregów ortogonalnych,\n" + 
                        "uk³ady dynamiczne i ergodycznoœæ." ) );

                        pierwsza.wypiszDaneOKsiazce("Pan Tadeusz");
        pierwsza.wypiszDaneOKsiazce("Gra o Tron");
        pierwsza.wypiszDaneOKsiazce("Tozsamosc Bourne'a");
        pierwsza.wypiszDaneOKsiazce("Analiza Matematyczna");
        
                        /*//Wypisz godziny urzedowania bibliotek
                        System.out.println( "Godziny otwarcia bibliotek ");
                        wypiszGodzinyOtwarcia();
                        System.out.println(); //pusta linijka

                        System.out.println( "Adresy bibliotek " );
                        pierwsza.wypiszAdres();
                        druga.wypiszAdres();
                        System.out.println(); //pusta linijka                        
                        System.out.println("Opis pana tadeusza");
                        pierwsza.wypiszDaneOKsiazce("Pan Tadeusz");
                        

                        //wypozycz Pana Tadeusza z obu bibliotek
                        System.out.println( "Wypozyczanie Pana Tadeusza" );
                        pierwsza.wypozyczKsiazke( "Pan Tadeusz" );

                        pierwsza.wypozyczKsiazke( "Pan Tadeusz" ); //sprobuj jeszcze raz

                        druga.wypozyczKsiazke( "Pan Tadeusz" );

                        System.out.println(); //pusta linijka

                        //Wypisz dostepne tytuly w obu bibliotekach
                        System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
                        pierwsza.wypiszDostepneKsiazki();
                        System.out.println(); //pusta linijka
                        System.out.println( "Ksiazki z drugiej biblioteki" );
                        druga.wypiszDostepneKsiazki();
                        System.out.println();

                        // zwroc Pana Tadeusza do biblioteki
                        System.out.println( "Zwrot Pana Tadeusza" );
        pierwsza.oddajKsiazke( "Pan Tadeusz" ); pierwsza.oddajKsiazke( "Pan Tadeusz" );
                        System.out.println();

                        // Wypisz tytuly dostepne w pierwszej bibliotece
                        System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
                        pierwsza.wypiszDostepneKsiazki();*/
    }
}

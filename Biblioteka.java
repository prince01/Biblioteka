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
        System.out.println("Biblioteki s� otwarte codziennie od 9:00 do 17:00");
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
                        pierwsza.dodajKsiazke( new Epopeja( "Pan Tadeusz", "Litwo, Ojczyzno moja! ty jeste� jak zdrowie;\n" + 
                        "Ile ci� trzeba ceni�, ten tylko si� dowie,\n" + 
                        "Kto ci� straci�. Dzi� pi�kno�� tw� w ca�ej ozdobie\n" + 
                        "Widz� i opisuj�, bo t�skni� po tobie.", "Wed�ug J�zefa Bohdana Zaleskiego, przyjaciela Adama Mickiewicza, pomys� �poematu sielskiego� narodzi� si� ju� w 1831 podczas pobytu wieszcza w Wielkopolsce. Poeta mia� rozpocz�� go od opisu dworku szlacheckiego[2]. Z kolei J�zef Grabowski, w�a�ciciel wsi �ukowo, utrzymywa� p�niej, �e to w jego miejscowo�ci Mickiewicz powzi�� postanowienie napisania Pana Tadeusza. Dok�adne fakty na ten temat jednak nie s� znane. Badacze przypuszczaj�, �e poeta napisa� w�wczas oko�o sto kilkadziesi�t wers�w opisuj�cych Soplicowo (w ostatecznym kszta�cie fragment ten ma si� ko�czy� na 174 wersie I ksi�gi)[3]. Poeta jednak � po napisaniu tego fragmentu � nie rozwija� tekstu przez kilkana�cie nast�pnych miesi�cy." ) );
                        pierwsza.dodajKsiazke( new KsiazkaFantastyczna( "Gra o Tron", "Siedem rodzin szlacheckich walczy o panowanie nad ziemiami krainy Westeros. Polityczne i seksualne intrygi s� na porz�dku dziennym. Pierwszorz�dne role wiod� rodziny: Stark, Lannister i Baratheon. Robert Baratheon, kr�l Westeros, prosi swojego starego przyjaciela, Eddarda Starka, aby s�u�y� jako jego g��wny doradca. Eddard, podejrzewaj�c, �e jego poprzednik na tym stanowisku zosta� zamordowany, przyjmuje propozycj�, aby dog��bnie zbada� spraw�.", "Eddard Stark � nazywany Nedem, w�adca Winterfell, zamku po�o�onego na p�nocy krainy Westeros. Posiada wielu wasali, a jego r�d nale�y do najstarszych i najbardziej licz�cych si� w kr�lestwie. Jest starym przyjacielem kr�la Roberta Baratheona, z kt�rym obali� rz�dy ostatniego z Targaryen�w, Aerysa Ob��kanego. Ma sze�cioro dzieci: Robba, Sans�, Ary�, Brandona i Rickona, kt�rych matk� jest jego �ona lady Catelyn Tully, a tak�e b�karta � Jona Snowa.\n" + 
                        "Catelyn Stark � �ona Eddarda Starka, pochodz�ca z rodu Tullych.\n" + 
                        "Sansa Stark � dwunastoletnia c�rka Eddarda Starka. Sansa jest przeciwie�stwem swojej siostry Aryi, z kt�r� nierzadko si� k��ci. Jest dobrze wychowana, interesuje si� legendami i opowie�ciami o wielkich rycerzach, lubi plotkowa�.\n" + 
                        "Arya Stark � dziesi�cioletnia c�rka Eddarda Starka. W przeciwie�stwie do Sansy, Arya jest urodzon� wojowniczk� i interesuje si� jazd� konn� oraz broni�. Cz�sto bywa niezno�na. Bardzo lubi swojego przyrodniego brata, Jona.\n" + 
                        "Brandon Stark � o�mioletni syn Neda Starka, przez znajomych nazywany po prostu Branem. Jego pasj� jest wspinaczka.\n" + 
                        "Jon Snow � pi�tnastoletni b�kart Neda Starka. Marzy o wst�pieniu do Nocnej Stra�y, interesuje si� broni� i walk�.\n" + 
                        "Tyrion Lannister � syn lorda Tywina Lannistera. Jest kar�em, przez co inni z niego szydz�, mimo �e jest bardzo inteligentny. Ma brata Jaimego i siostr� Cersei.\n" + 
                        "Daenerys Targaryen � c�rka Aerysa Ob��kanego, kt�ra po buncie w Westeros musia�a ucieka� wraz ze swoim bratem Viserysem." ) );
                        pierwsza.dodajKsiazke( new Kryminal( "Tozsamosc Bourne'a", "powie�� sensacyjna z 1980 roku, kt�rej autorem jest ameryka�ski pisarz Robert Ludlum. Pierwsza, rozpoczynaj�ca 3 tomow� powie��, ksi��ka opisuj�ca przygody Jasona Bourne'a. Zosta�a zekranizowana po raz pierwszy jako miniserial w roku 1988 i nast�pnie jako film sensacyjny w 2002 w re�yserii Douga Limana. Ksi��ka jest inspirowana postaci� terrorysty Ilicza Ramireza Sancheza znanego jako Carlos i Szakal.", "Tajemniczego m�czyzn� wy�owionego z morza ratuje grupa rybak�w. Pod okiem lekarza � uciekiniera, dochodzi on jednak do pe�ni si� fizycznych. Po przebytym urazie g�owy, krzepki, szarozielononiebieskooki m�czyzna nie pami�ta nic ze swojej przesz�o�ci. Nie pami�ta �adnych fakt�w ze swojego �ycia. Dysponuj�c jedynie poszlakami rusza \"wstecz\" by odkry� swoj� to�samo��. Jednak z ka�d� sekund� dowiaduje si�, �e przez ca�e \"poprzednie\" �ycie tylko od niej ucieka�. Wykorzystywa� do tego sw�j trudny do jednoznacznego okre�lenia wygl�d, dzi�ki kt�remu przybiera� r�ne oblicza. Kolejne wydarzenia i dziwnie znajome uczucia co do nieznanych mu miejsc czy wydarze�, pomimo amnezji, wprowadzaj� go w nieustanny ob��d. Wie jedynie, �e kto� usi�uje go zabi�, i co najgorsze � jemu r�wnie� przychodzi to bez trudu. W swej pod�wiadomo�ci wie �e potrafi zrobi� wszystko, byle by tylko przetrwa�, jak r�wnie� uzyska� odpowied� na pytanie � \"Kim jest?\"." ) );
                        pierwsza.dodajKsiazke( new KsiazkaNaukowa( "Analiza Matematyczna", "zesp� teorii obejmuj�cy wiele wa�nych dzia��w matematyki.\n" + 
                        "Pocz�tkowo analiza matematyczna obejmowa�a jedynie to, co dzisiaj nazywamy rachunkiem r�niczkowym i ca�kowym. Jej rozw�j zainicjowa�y prace Leibniza i Newtona z pocz�tku XVII wieku.\n" + 
                        "Z czasem rachunek r�niczkowy i ca�kowy, ograniczaj�cy si� wcze�niej do kartezja�skich przestrzeni rzeczywistych, obj�� swoim zakresem inne przestrzenie: przestrzenie zespolone (teoria funkcji holomorficznych), przestrzenie Banacha i Hilberta (wraz z odpowiadaj�cymi im teoriami) oraz bardziej zaawansowane twory geometryczne (na przyk�ad rozmaito�ci r�niczkowalne).\n" + 
                        "Zaawansowanej analizy matematycznej nie mo�na obecnie uprawia� bez znajomo�ci algebry, topologii (w tym topologii algebraicznej) czy geometrii r�niczkowej.", "W miar� rozwi�zywania kolejnych problem�w stawianych przez analiz� matematyczn� powstawa�y zupe�nie nowe dzia�y matematyki, kt�re dzi� wchodz� w sk�ad analizy:\n" + 
                        "algebry Banacha i analiza harmoniczna,\n" + 
                        "analiza funkcjonalna,\n" + 
                        "funkcje specjalne,\n" + 
                        "funkcje zmiennej zespolonej (jednej zmiennej),\n" + 
                        "funkcje zespolone wielu zmiennych,\n" + 
                        "rachunek wariacyjny,\n" + 
                        "rozmaito�ci r�niczkowalne,\n" + 
                        "r�wnania ca�kowe,\n" + 
                        "przekszta�cenie Mellina,\n" + 
                        "r�wnania r�niczkowe cz�stkowe,\n" + 
                        "r�wnania r�niczkowe zwyczajne,\n" + 
                        "teoria dystrybucji,\n" + 
                        "teoria form r�niczkowych,\n" + 
                        "teoria miary i ca�ki,\n" + 
                        "teoria reprezentacji grup Liego,\n" + 
                        "teoria szereg�w ortogonalnych,\n" + 
                        "uk�ady dynamiczne i ergodyczno��." ) );

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

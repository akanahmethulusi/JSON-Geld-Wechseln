package src;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.spi.CurrencyNameProvider;

public class BaseMenuCreateManager {
    static String menuParanthese = ConsoleManager.CYAN + new String(new char[25]).replace("\0", "-") + ConsoleManager.RESET;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/y H:m:s");
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    Object aktuelleZeit = simpleDateFormat.format(gregorianCalendar.getTime());
    Scanner scanner = new Scanner(System.in);

    // Willkommen und Vorinfo
    void welcome(){
        System.out.println(menuParanthese);
        System.out.println(ConsoleManager.YELLOW + "<Devisenkonsoll app >\n" + ConsoleManager.RESET + menuParanthese);
        System.out.println(ConsoleManager.RED + "-> Entwickler von App: " + ConsoleManager.RESET + ConsoleManager.GREEN + "A H 4K4N" + ConsoleManager.RESET);
        System.out.println(ConsoleManager.RED + "-> Die Appzeit: " + ConsoleManager.RESET + ConsoleManager.GREEN + aktuelleZeit + ConsoleManager.RESET);
        System.out.println(menuParanthese);
    }

    //Menu Option
    void startMenu(){
        String select;
        String paranthese = ConsoleManager.BLACK + "-" + ConsoleManager.RESET;
        String nummern[] = {"[1]", "[2]", "[3]", "[4]"};

        System.out.println(ConsoleManager.RED + nummern[0] + ConsoleManager.RESET + paranthese + ConsoleManager.BLUE + "Show Devisen Betraege\n " + ConsoleManager.RESET
                        +  ConsoleManager.RED + nummern[1] + ConsoleManager.RESET + paranthese + ConsoleManager.BLUE + "Abfragen Devisen\n" + ConsoleManager.RESET
                        +  ConsoleManager.RED + nummern[2] + ConsoleManager.RESET + paranthese + ConsoleManager.BLUE + "Update die JSON info\n" + ConsoleManager.RESET
                        +  ConsoleManager.RED + nummern[3] + ConsoleManager.RESET + paranthese + ConsoleManager.BLUE + "Ende App" + ConsoleManager.RESET);
        System.out.println(menuParanthese);
        System.out.println(ConsoleManager.RED + "-> Welche Operationen möchten Sie durchführen?" + ConsoleManager.RESET);
        select = scanner.nextLine();
        System.out.println(menuParanthese);
        selectMenu(select);
    }

    //Weiterleiten zur ausgewaehlten Menu
    void selectMenu(String select){
        CurrencyUnitsManager currencyUnitsManager = new CurrencyUnitsManager();
        if (select.equalsIgnoreCase("eins") || select.equals("1") || select.equalsIgnoreCase("Show Devisen Betraege")) {
            currencyUnitsManager.currencyRead();
            currencyUnitsManager.currencyInfoMenu();
            currencyUnitsManager.currencyInfoBox();
            restartMenu();
        }else if (select.equalsIgnoreCase("zwei") || select.equals("2") || select.equalsIgnoreCase("Abfragen Devisen")){
            currencyUnitsManager.currencyInfoMenu();
            currencyUnitsManager.currencyInfoBox();
            restartMenu();
        }else if(select.equalsIgnoreCase("drei") || select.equals("3") || select.equalsIgnoreCase("Update die JSON info")){
            JSONWrite jsonWrite = new JSONWrite();
            System.out.println(ConsoleManager.GREEN + "->JSON wird update geworden.\n" + ConsoleManager.RESET + menuParanthese);
            restartMenu();
        }else if (select.equalsIgnoreCase("vier") || select.equals("4") || select.equalsIgnoreCase("Ende App")){
            System.out.println(ConsoleManager.YELLOW + "Die App wird geschlossen.\n" + ConsoleManager.RESET + menuParanthese);
            System.exit(0);
        }else{
            System.out.println(ConsoleManager.YELLOW + "->Unbekannte Werte wird abgegeben. Das App wird geschlossen.\n" + ConsoleManager.RESET + menuParanthese);

        }
    }
    void restartMenu(){
        String entscheidung;
        System.out.println(ConsoleManager.YELLOW + "->Zurück die Hauptmenü" + ConsoleManager.RESET + ConsoleManager.GREEN + " [Y]" + ConsoleManager.RESET
                        +  ConsoleManager.YELLOW + ", End die App" + ConsoleManager.RESET
                        +  ConsoleManager.RED + " [N]" + ConsoleManager.RESET + ConsoleManager.YELLOW + " drücken Sie Taste" + ConsoleManager.RESET);
        System.out.println(ConsoleManager.RED + "\n ->Ihre Entscheidung: " + ConsoleManager.RESET);
        entscheidung = scanner.nextLine();
        System.out.println(menuParanthese);
        if (entscheidung.equalsIgnoreCase("y")){
            ConsoleManager.clear();
            startMenu();
        }else if (entscheidung.equalsIgnoreCase("n")){
            System.out.println(ConsoleManager.RED + "-> Die App wird beendet." + ConsoleManager.RESET);
            System.out.println(menuParanthese);
            System.exit(0);
        }else {
            System.out.println(ConsoleManager.RED + "Sie haben eine Unbekannte Werte abgegeben." + ConsoleManager.RESET);
            System.out.println(menuParanthese);
            System.exit(0);
        }

    }
}

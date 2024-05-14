package src;

import java.util.Scanner;

//Enum Definition wurde durchgeführt, dass die Name des Devisen  von JSON ist, auswendig zu lernen
enum currencyUnits{
    USD("Amerikan dollar"),
    EUR("Euro"),
    GBP("Sterlin"),
    CHF("Schweizer Franken"),
    CAD("Canada dollar"),
    RUB("Rusia Rubel"),
    KWD("Kuweit Dinar");
    private String moneyName;
    currencyUnits(String moneyName){
        this.moneyName = moneyName;
    }

    public String getMoneyName(){
        return moneyName;
    }
}
public class CurrencyUnitsManager {
    //Das Method ist Ausgegeben von Devisen Einheiten
    void currencyRead(){
        int count = 1;
        String paranthese = ConsoleManager.BLACK + "-" + ConsoleManager.RESET;
        System.out.println(ConsoleManager.YELLOW + "< Devisen Einheiten >\n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
        for (currencyUnits c:currencyUnits.values()){
            System.out.println(ConsoleManager.RED + "["+count+"] " + ConsoleManager.RESET + paranthese + ConsoleManager.BLUE + " ["+c.name()+"] " + ConsoleManager.RESET +
                                                                                                            ConsoleManager.YELLOW + c.getMoneyName() + ConsoleManager.RESET);
            count++;
        }
        System.out.println(BaseMenuCreateManager.menuParanthese);
    }
    //Das Method, dass wir von User eine Devisen Einheits verlangen werden.
    String currencyInfo;
    JSONReader jsonReader = new JSONReader();
    void currencyInfoMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleManager.RED + "->Die Waehrung des Abfragen" + ConsoleManager.RESET);
        currencyInfo = scanner.nextLine();
        System.out.println(BaseMenuCreateManager.menuParanthese);
    }

    void currencyInfoBox(){
        if(currencyInfo.equalsIgnoreCase("USD") || currencyInfo.equals("1") || currencyInfo.equalsIgnoreCase("Amerikan dollar")){
            System.out.println(ConsoleManager.BLUE + "< Info Amerikan Dollar> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("USD");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("EUR") || currencyInfo.equals("2") || currencyInfo.equalsIgnoreCase("Euro")){
            System.out.println(ConsoleManager.BLUE + "< Info Euro> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("EUR");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("GBP") || currencyInfo.equals("3") || currencyInfo.equalsIgnoreCase("Sterlin")){
            System.out.println(ConsoleManager.BLUE + "< Info Sterlin> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("GBP");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("CHF") || currencyInfo.equals("4") || currencyInfo.equalsIgnoreCase("Schweizer Franken")) {
            System.out.println(ConsoleManager.BLUE + "< Info Schweizer Franken> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("CHF");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("CAD") || currencyInfo.equals("5") || currencyInfo.equalsIgnoreCase("Canada dollar")) {
            System.out.println(ConsoleManager.BLUE + "< Info Canada dollar> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("CAD");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("RUB") || currencyInfo.equals("6") || currencyInfo.equalsIgnoreCase("Rusia Rubel")) {
            System.out.println(ConsoleManager.BLUE + "< Info Rusia Rubel> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("RUB");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else if (currencyInfo.equalsIgnoreCase("KWD") || currencyInfo.equals("7") || currencyInfo.equalsIgnoreCase("Kuweit Dinar")) {
            System.out.println(ConsoleManager.BLUE + "< Info Kuweit Dinar> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
            jsonReader.showMe("KWD");
            System.out.println(BaseMenuCreateManager.menuParanthese);
        }else{
            System.out.println(ConsoleManager.RED + "< Unbekannte Werte wird abgegeben> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
        }
    }
}

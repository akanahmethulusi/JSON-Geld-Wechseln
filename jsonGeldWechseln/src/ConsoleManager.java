package src;

public class ConsoleManager {

    //Für die farbige Ausgaben ist Definitionen
    public static final String RESET = "\033[0m"; //textt reset

    //Man kann in [1;xxm" die 1 aendern, um die unterzeihen oder normal text zu machen
    public static final String BLACK = "\033[1;30m"; // Schwarz
    public static final String RED = "\033[1;31m";// Rot
    public static final String GREEN = "\033[1;32m";// Grün
    public static final String YELLOW = "\033[1;33m";// Gelb
    public static final String BLUE = "\033[1;34m"; // Blau
    public static final String PURPLE = "\033[1;35m"; //purple
    public static final String CYAN = "\033[1;36m"; //Türkis
    public static final String WHITE = "\033[1;37m"; //Weiss

    //Für Konsolen Reinigung ist Method Definition
    static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {
            System.out.println("Durch Konsole Reinigung habe ich eien Fehler getroffen.\n" + e);

        }
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
        BaseMenuCreateManager baseMenuCreateManager = new BaseMenuCreateManager();
        baseMenuCreateManager.welcome();
    }
}

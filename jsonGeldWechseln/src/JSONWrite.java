package src;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;
import java.util.Timer;

public class JSONWrite {
    //static int stundlich=0; wir benutzen, dass wir die Aufgabe von Method erstellt
    static int stundlich =0;
    public void start(){
        //JSON dateien schreiben wir auf waehrungDaten.JSON lassen, in dem wir von internet ausziehen
        try {
            URL url = new URL("https://finans.truncgil.com/v3/today.json"); //Die URL, die wir Daten bekommen
            HttpURLConnection hr = (HttpURLConnection) url.openConnection();
            System.out.println(hr.getResponseCode());// Wir erlernen die Antwortnummer des Verbindungs
            if(hr.getResponseCode() == 200){
                //wir implementieren die Ablaeufe, wenn die Antwortnummer 200 gleich ist, die zu uns braucht
                InputStream im = hr.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(im));
                File file = new File("/Users/*******/InteliJ-workspace/jsonGeldWechseln/src/waehrungDaten.JSON");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                String veri = (String) bufferedReader.readLine();
                while (veri!=null){
                    bufferedWriter.write(veri); //Wir drucken die Datei, die gelesen hat
                    bufferedWriter.newLine(); // Wir möchten noch eine untere Zeile vorbeigehen
                    bufferedWriter.flush(); //es wirkt Implementierung aus, um gelesene Dateien in File zu sehen
                    veri = bufferedReader.readLine(); //Wir wurden neue Dateien gelesen
                }
                //Wenn die Ablaeufe fertig ist, schliesse ich Lesen-Schreiben Ablaeufe.
                bufferedWriter.close();
                bufferedReader.close();
                im.close();
            }
        }
        catch (Exception e){
            System.out.println("src.JSONWrite Klasse Exception Fehler.\n"+e);
        }
    }
    JSONWrite(){
        start(); //Ich möchte eine Datei erstellen, nachdem main Klasse dei Darstellung getan hat
    }

    public void alertTimer(){
        Timer alertTimer = new Timer();
        TimerTask alertTask = new TimerTask() {
            @Override
            public void run() {
                if(stundlich < 4){
                    System.out.println(ConsoleManager.RED + "-> Das App ist 15 min. aktiv. " + ConsoleManager.RESET);
                    System.out.println(ConsoleManager.BLUE + "-> Die Informationen von JSON wird allgemein jede 10 min.  erneuert" + ConsoleManager.RESET);
                    System.out.println(ConsoleManager.YELLOW + "-> \n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
                    start();
                    stundlich++;
                }else{
                    System.out.println(ConsoleManager.RED + "-> Das App ist 60Min aktiv. Das App ist geschlossen. Sollten Sie bitte wieder ausführen.\n" + ConsoleManager.RESET + BaseMenuCreateManager.menuParanthese);
                    alertTimer.cancel();
                    System.exit(0);
                }
            }
        };
        alertTimer.schedule(alertTask, 900000, 900000); // Nachdem das App beginnt, (nachdem 15 min spaeter)/ nachdem erste Prozess, erneuert neu jede 15 min

    }
}

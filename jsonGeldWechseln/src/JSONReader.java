package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    static String devisenkauf = null;// kauf von Fremdewaehrung
    static String devisenVerkaeufe = null; //verkauf von Fremdewaehrung
    static String betragAendern = null;
    static String jSONUpdate = null;

    public void showMe(String welcheData){
        // definiert JSON
        JSONParser jsonParser = new JSONParser();
        //Data lesen
        try {
            FileReader fileReader = new FileReader("/Users/*****/InteliJ-workspace/jsonGeldWechseln/src/waehrungDaten.JSON");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            jSONUpdate = (String) jsonObject.get("Update_Date");
            //JSON Tabelle als Array aufmachen
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(jsonObject.get(welcheData));
            for(int i = 0; i < jsonArray.size(); i++){
                JSONObject currency = (JSONObject) jsonObject.get(i);
                devisenkauf = (String) currency.get("Buying");
                devisenVerkaeufe = (String) currency.get("Selling");
                betragAendern = (String) currency.get("Change");
            }
            System.out.println(ConsoleManager.GREEN + "->Die Zeit ist JSON updatezeit: " + ConsoleManager.RESET + jSONUpdate);// JSON Updatezeit wird ausgegeben
            System.out.println(ConsoleManager.RED + "-> Kaufvertrag in Fremdewaehrung: " + ConsoleManager.RESET + devisenkauf +
                               ConsoleManager.CYAN + "\n -> Verkaufvertrag in Fremdewaehrung: " + ConsoleManager.RESET + devisenVerkaeufe+
                               ConsoleManager.YELLOW + "\n -> Betrag Aenderung: " + ConsoleManager.RESET + betragAendern);
            //Beendigung Prozesse
            fileReader.close();
        }catch (IOException e){
            System.out.println("IOException Fehler: !\n" + e);

        }catch (ParseException e){
            System.out.println("ParseException Fehler !\n"+e);
        }
        }
}


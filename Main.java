import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat.Style;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Main{
    public static void main(String[] args) {
        new GUI();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //prova per vedere se funziona, i seguenti comandi verranno messi in GUI

        JSONArray file=new JSONArray(); //array dei file contenuti
        
        JSONObject identita=new JSONObject(),posizione=new JSONObject(),nascita=new JSONObject();
        identita.put("Elia","Rizzi");
        posizione.put("Roma","Via sassi");
        nascita.put("11 settembre","2001");

        //aggiunta degli oggetti nell'array JSON
        file.add(identita);
        file.add(posizione);
        file.add(nascita);

        try(FileWriter scrittore = new FileWriter(".\\src\\Dati\\json.json");){ //crezione file
            scrittore.write(file.toJSONString());
            System.out.println("scrittura avvenuta con successo");
        }catch(Exception e){
            System.err.println("errore nella scrittura del file");
        }
    }
}
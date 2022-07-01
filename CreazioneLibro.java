import java.io.FileWriter;

import javax.swing.JTextArea;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreazioneLibro {
    private String autore,titolo,genere,commento;
    private int voto, anno,numeroPagine,numero;

    public CreazioneLibro(int numero,String autore,String titolo,String genere,String commento,int voto,int anno, int numeroPagine){
        this.numero=numero;
        this.titolo=titolo;
        this.autore=autore;
        this.genere=genere;
        this.commento=commento;
        this.voto=voto;
        this.anno=anno;
        this.numeroPagine=numeroPagine;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getAutore(){
        return autore;
    }

    public String getGenere(){
        return genere;
    }

    public String getCommento(){
        return commento;
    }

    public int getVoto(){
        return voto;
    }

    public int getAnno(){
        return anno;
    }

    public int getNumeroPagine(){
        return numeroPagine;
    }

    public int getNumero(){
        return numero;
    }

    public JTextArea getText(){
        //creazione file Json
        JSONArray file=new JSONArray(); 
        JSONObject autore=new JSONObject(),titolo=new JSONObject(),genere=new JSONObject(),commento=new JSONObject(),anno=new JSONObject(),voto=new JSONObject(),numeroPagine=new JSONObject();
        titolo.put("titolo", getTitolo());
        autore.put("autore", getAutore());
        genere.put("genere", getGenere());
        commento.put("commento", getCommento());
        voto.put("voto", getVoto());
        anno.put("anno", getAnno());
        numeroPagine.put("numeroPagine", getNumeroPagine());

        file.add(titolo);
        file.add(autore);
        file.add(genere);
        file.add(commento);
        file.add(voto);
        file.add(anno);
        file.add(numeroPagine);

        try(FileWriter scrittore = new FileWriter(".\\src\\Dati\\Libri\\libro"+numero+".json");){ //crezione file
            scrittore.write(file.toJSONString());
        }catch(Exception e){}

        //ritorno dei dati
        JTextArea text=new JTextArea();
        text.setEditable(false);
        text.append(numero+") "+getTitolo()+" "+getAutore()+" "+getGenere()+" "+getCommento()+" "+getVoto()+" "+getAnno()+" "+getNumeroPagine());
        return text;
    }
}

import java.io.FileWriter;

import javax.swing.JTextArea;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreazioneLibro {
    private String autore,titolo,genere,commento,voto, anno,numeroPagine;
    private int numero;

    public CreazioneLibro(int numero,String autore,String titolo,String genere,String commento,String voto,String anno, String numeroPagine){
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

    public String getVoto(){
        return voto;
    }

    public String getAnno(){
        return anno;
    }

    public String getNumeroPagine(){
        return numeroPagine;
    }

    public int getNumero(){
        return numero;
    }


    public JTextArea getText(){
        JSONArray file=new JSONArray(); 
        JSONObject numero=new JSONObject(),autore=new JSONObject(),titolo=new JSONObject(),genere=new JSONObject(),commento=new JSONObject(),anno=new JSONObject(),voto=new JSONObject(),numeroPagine=new JSONObject();
        numero.put("numeroIdentificativo", getNumero());
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

        try(FileWriter scrittore = new FileWriter(".\\src\\Dati\\Libri\\libro"+getNumero()+".json");){ //crezione file
            scrittore.write(file.toJSONString());
        }catch(Exception e){}
        //ritorno dei dati
        JTextArea text=new JTextArea();
        text.setEditable(false);
        text.append(getNumero()+") Titolo:"+getTitolo()+" Autore:"+getAutore()+" Genere:"+getGenere()+" Commento:"+getCommento()+" Voto:"+getVoto()+" Anno:"+getAnno()+" NumeroPagine:"+getNumeroPagine());
        return text;
    }
}

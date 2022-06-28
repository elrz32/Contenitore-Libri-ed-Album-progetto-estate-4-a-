import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;   
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class GUI extends JFrame{

    private JPanel contenitore,nord,sud,centro;
    private BufferedImage contenitoreImmagine;
    private JLabel scrittaNord,scrittaSud, tabellaMostraImmagine;
    private JButton ritornoHome,catalogoLibri,catalogoAlbum,aggiungiLibro,creaLibro,aggiungiAlbum,creaAlbum;
    private boolean immagineMessa;
    private JTextField titolo,autore,anno,numeroPagine,commento,numeroMusiche,genere;
    //private ??? voto (va 1 a 5 stelle) TODO

    public GUI(){
        this.setTitle("contenitore album ecc");
        this.setBounds(100,0,700,800);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //contenitore della home page
        contenitore=new JPanel();
        contenitore.setLayout(new BorderLayout()); 
        //posizioni nord centro sud del contenitore
        nord=new JPanel();
        nord.setLayout(new FlowLayout());
        centro=new JPanel();
        centro.setLayout(new FlowLayout());
        sud=new JPanel();
        sud.setLayout(new FlowLayout());
        contenitore.add(nord,BorderLayout.NORTH);
        contenitore.add(sud,BorderLayout.SOUTH);
        contenitore.add(centro,BorderLayout.CENTER);

        scrittaNord=new JLabel();
        scrittaSud=new JLabel();
        ritornoHome=new JButton();
        catalogoAlbum=new JButton();
        catalogoLibri=new JButton();
        aggiungiLibro=new JButton();
        creaLibro=new JButton();
        aggiungiAlbum=new JButton();
        creaAlbum=new JButton();
        tabellaMostraImmagine=new JLabel();
        titolo=new JTextField(30);
        autore=new JTextField(30);
        anno=new JTextField(30);
        genere=new JTextField(30);
        numeroMusiche=new JTextField(30);
        numeroPagine=new JTextField(30);
        commento=new JTextField(30);
        immagineMessa=false;
        homePage();
        this.add(contenitore);
        this.setVisible(true);
    }

    public void homePage(){
        catalogoAlbum.setVisible(true);
        catalogoLibri.setVisible(true);
        ritornoHome.setVisible(false);
        aggiungiLibro.setVisible(false);
        aggiungiAlbum.setVisible(false);
        creaLibro.setVisible(false);
        titolo.setVisible(false);
        autore.setVisible(false);
        anno.setVisible(false);
        genere.setVisible(false);
        numeroMusiche.setVisible(false);
        commento.setVisible(false);
        numeroPagine.setVisible(false);

        scrittaNord.setText("CONTENITORE DI ALBUM E DI LIBRI");
        scrittaNord.setVisible(true);
        nord.add(scrittaNord);
        nord.setBackground(Color.CYAN);

        scrittaSud.setText("By Rizzi Industries");
        scrittaSud.setVisible(true);
        sud.add(scrittaSud);
        sud.setBackground(Color.GRAY);

        centro.setLayout(new FlowLayout());
        centro.setBackground(Color.LIGHT_GRAY);

        catalogoLibri.setText("clicca qui per vedere il tuo catalogo dei libri");
        catalogoLibri.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                tabellaMostraImmagine.setVisible(false);
                catalogoAlbum.setVisible(false);
                catalogoLibri.setVisible(false);
                mostraLibri();
            }
        });

        catalogoAlbum.setText("clicca qui per vedere il catalogo dei tuoi album");
        catalogoAlbum.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                tabellaMostraImmagine.setVisible(false);
                catalogoAlbum.setVisible(false);
                catalogoLibri.setVisible(false);
                mostraAlbum();
            }
        });
        //come mettere un'immagine
        try {
            if(immagineMessa==false){
                contenitoreImmagine=ImageIO.read(new File(".\\src\\Dati\\Immagini\\contenitore.png"));
                tabellaMostraImmagine=new JLabel(new ImageIcon(contenitoreImmagine));
                centro.add(tabellaMostraImmagine);
                immagineMessa=true;
            }
        } catch (Exception e) {
            System.err.println("errore nel caricamento dell'immagine");
        }
        tabellaMostraImmagine.setVisible(true);
        centro.add(catalogoLibri);
        centro.add(catalogoAlbum);
    }

    public void mostraLibri(){
        scrittaNord.setText("Elenco dei libri presenti");
        ritornoHome.setVisible(true);
        ritornoHome.setText("Torna alla schermata Home"); 
        ritornoHome.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                homePage();
            }
        });
        sud.add(ritornoHome);
        //pulsante per l'aggiunta di un libro
        aggiungiLibro.setText("Clicca qui per aggiungere un libro!");
        aggiungiLibro.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                creaLibro();
            }
        });
        aggiungiLibro.setVisible(true);
        centro.add(aggiungiLibro);
    }

    public void mostraAlbum(){
        scrittaNord.setText("Elenco degli album presenti");
        ritornoHome.setText("Torna alla schermata Home");
        ritornoHome.setVisible(true);
        ritornoHome.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                homePage();
            }
        });
        sud.add(ritornoHome);
        //pulsante per l'aggiunta di un album
        aggiungiAlbum.setVisible(true);
        aggiungiAlbum.setText("Clicca qui per aggiungere un album!");
        aggiungiAlbum.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                creaAlbum();
            }
        });
        aggiungiAlbum.setVisible(true);
        centro.add(aggiungiAlbum);
    }

    public void creaLibro(){
        titolo.setVisible(true);
        autore.setVisible(true);
        anno.setVisible(true);
        genere.setVisible(true);
        commento.setVisible(true);
        numeroPagine.setVisible(true);
        aggiungiLibro.setVisible(true);
        scrittaNord.setText("Inserisci i dati del tuo libro");
        creaLibro.setText("aggiungi il libro");
        creaLibro.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                //TODO immetto il libro nella lista
            }
        });
        creaLibro.setVisible(true);
        sud.add(creaLibro);
        //TODO schermata di aggiunta libro
        centro.add(titolo);
        centro.add(autore);
        centro.add(anno);
        centro.add(genere);
        centro.add(numeroPagine);
        centro.add(commento);
    }

    public void creaAlbum(){
        titolo.setVisible(true);
        autore.setVisible(true);
        anno.setVisible(true);
        genere.setVisible(true);
        numeroMusiche.setVisible(true);
        commento.setVisible(true);

        aggiungiAlbum.setVisible(false);
        scrittaNord.setText("Inserisci i dati del tuo album");
        creaAlbum.setText("aggiungi l'album");
        creaAlbum.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                //TODO immetto l'album nella lista
            }
        });
        creaAlbum.setVisible(true);
        sud.add(creaAlbum);
        //TODO schermata aggiunta album
        centro.add(titolo);
        centro.add(autore);
        centro.add(anno);
        centro.add(genere);
        centro.add(numeroMusiche);
        centro.add(commento);
    }
}

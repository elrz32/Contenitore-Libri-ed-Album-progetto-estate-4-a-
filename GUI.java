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
public class GUI extends JFrame{

    private JPanel contenitore,nord,sud,centro;
    private BufferedImage contenitoreImmagine;

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

        homePage();
        this.add(contenitore);
        this.setVisible(true);
    }

    public void homePage(){
        nord.add(new JLabel("CONTENITORE DI ALBUM E DI LIBRI"));
        nord.setBackground(Color.CYAN);
        sud.add(new JLabel("By Elia Rizzi"));
        sud.setBackground(Color.GRAY);
        centro.setLayout(new FlowLayout());
        centro.setBackground(Color.LIGHT_GRAY);
        JButton catalogoLibri=new JButton("clicca qui per vedere il tuo catalogo dei libri");
        //TODO collegamento pulsante-schermataLibri
        JButton catalogoAlbum=new JButton("clicca qui per vedere il catalogo dei tuoi album");
        //TODO collegamento pulsante-schermataAlbum
        //come mettere un'immagine
        try {
            contenitoreImmagine=ImageIO.read(new File(".\\src\\Dati\\Immagini\\contenitore.png"));
            JLabel tabellaMostraImmagine=new JLabel(new ImageIcon(contenitoreImmagine));
            centro.add(tabellaMostraImmagine);
        } catch (Exception e) {
            System.err.println("errore nel caricamento dell'immagine");
        }
        centro.add(catalogoLibri);
        centro.add(catalogoAlbum);
    }

    public void mostraLibri(){
        nord.add(new JLabel("Elenco dei libri presenti"));
        JButton ritornoHome=new JButton("Torna alla schermata Home"); 
        sud.add(ritornoHome);
    }

    public void mostraAlbum(){
        nord.add(new JLabel("Elenco degli album presenti"));
        JButton ritornoHome=new JButton("Torna alla schermata Home");
        sud.add(ritornoHome);
    }



    //Ascoltatori per i pulsanti
    public  class SchermataCatalogoLibri implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mostraLibri();
		} 
	}

    public  class SchermataCatalogoAlbum implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mostraAlbum();
		} 
	}
}

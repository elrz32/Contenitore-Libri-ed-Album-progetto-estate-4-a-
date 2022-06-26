import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import javax.swing.JPanel;
public class GUI extends JFrame{

    private JLabel contenitore,nord,sud,centro;

    public GUI(){
        this.setTitle("contenitore album ecc");
        this.setBounds(100,0,700,800);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //contenitore della home page
        contenitore=new JLabel();
        contenitore.setLayout(new BorderLayout()); 
        //posizioni nord centro sud del contenitore
        nord=new JLabel();
        nord.setLayout(new FlowLayout());
        centro=new JLabel();
        centro.setLayout(new FlowLayout());
        sud=new JLabel();
        sud.setLayout(new FlowLayout());
        
        this.setVisible(true);
    }
}

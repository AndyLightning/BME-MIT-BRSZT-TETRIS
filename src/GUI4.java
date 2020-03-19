import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;


public class GUI4 implements ActionListener {
    int mx=0;
    int my=0;
    boolean finished=false;
    JFrame frame = new JFrame();
    private JLabel label1, label2;
    private JButton button1;
    private Font font;
    private String[] legjobbak = new String[10];
    private int[] legjobbPontok = new int[10];


    public boolean getFinished() {
        return finished;
    }

    public void resetFinished() {
        finished=false;
    }

    public void setLegjobbak (String[] param) {
        legjobbak=param;
    }

    public void setLegjobbPontok (int[] param) {
        legjobbPontok=param;
    }



    public void setFont(Font param){
        font=param;
    }


    public GUI4() throws IOException {
        //Blokkok megteremtése

        //Alapbeállítások
        frame.setTitle("Dicsőségtábla");
        frame.setSize(340, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setVisible(false);
        frame.setResizable(false);

        Board board = new Board();
        frame.setContentPane(board);
        board.setLayout(null);

        Move move = new Move();
        frame.addMouseMotionListener(move);

        Click click = new Click();
        frame.addMouseListener(click);



        label1 = new JLabel("Játékos");
        label1.setBounds(10,10,300,15);
        board.add(label1);

        label2 = new JLabel("Elért pontszám");
        label2.setBounds(220,10,300,15);
        board.add(label2);

        button1 = new JButton("Vissza a Főmenübe");
        button1.setBounds(80,190,150,40);
        button1.addActionListener(this);
        board.add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        finished=true;
    }


    public class Board extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.black);
            g.setFont(font);

            for (int i=0; i<10; i++) {
                g.drawString(legjobbak[i], 10, 40+i*15);
                g.drawString("" + legjobbPontok[i], 220, 40+i*15);
            }
        }
    }



    public class Move implements MouseMotionListener {
        public void mouseDragged(MouseEvent arg0) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public class Click implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Kattintottál!");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
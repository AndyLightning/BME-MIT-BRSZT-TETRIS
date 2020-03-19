import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;


public class GUI4 {
    int mx=0;
    int my=0;
    JFrame frame = new JFrame();
    private JLabel label1, label2;
    private Font font;



    public void setFont(Font param){
        font=param;
    }


    public GUI4() throws IOException {
        //Blokkok megteremtése

        //Alapbeállítások
        frame.setTitle("Dicsőségtábla");
        frame.setSize(1000, 1000);
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

    }


    public class Board extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Következő blokk:", 270, 20);
        }
    }



    public class Move implements MouseMotionListener {
        public void mouseDragged(MouseEvent arg0) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("Mozgott az Egér");
            mx=e.getX();
            my=e.getY();
            System.out.println("x: " + mx + ", y: " + my);
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
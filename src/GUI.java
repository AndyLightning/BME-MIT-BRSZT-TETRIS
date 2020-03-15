import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;


public class GUI extends JFrame {
    boolean Multi;
    int spacing = 5;
    BufferedImage red, orange, yellow, green, lblue, dblue, purple;

    int[][] playerZone = new int[24][10];

    public GUI() throws IOException {
        this.setTitle("Tetris");
        this.setSize(650, 754);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Board board = new Board();
        this.setContentPane(board);

        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);

        green = ImageIO.read(new File("img/Green.png"));

    }


    public class Board extends JPanel {


        public void paintComponent(Graphics g) {
            g.setColor(Color.lightGray);
            g.fillRect(0,0,640,720);
            g.setColor(Color.DARK_GRAY);
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    g.fillRect(15 + i * (spacing + 20), j * (spacing + 20) + 105, 20, 20);
                }
            }
            g.drawImage(green, 0, 0, this);
        }
    }
    public class Move implements MouseMotionListener {
        public void mouseDragged(MouseEvent arg0) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("Mozgott az Egér");
            System.out.println("x: " + e.getX() + ", y: " + e.getY());
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
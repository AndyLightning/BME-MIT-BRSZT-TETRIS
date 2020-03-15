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
        this.setSize(650, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Board board = new Board();
        this.setContentPane(board);

        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);

        red = ImageIO.read(new File("img/Red.png"));
        orange = ImageIO.read(new File("img/Orange.png"));
        yellow = ImageIO.read(new File("img/Yellow.png"));
        green = ImageIO.read(new File("img/Green.png"));
        lblue = ImageIO.read(new File("img/LBlue.png"));
        dblue = ImageIO.read(new File("img/DBlue.png"));
        purple = ImageIO.read(new File("img/Purple.png"));

        for (int i=0; i<10; i++) {
            for (int j = 0; j < 24; j++) {
                playerZone[j][i]=(j%8);
            }
        }

    }


    public class Board extends JPanel {


        public void paintComponent(Graphics g) {
            g.setColor(Color.lightGray);
            g.fillRect(0,0,640,720);
            g.setColor(Color.white);
            g.fillRect(15,105,250,600);
            g.setColor(Color.white);
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    switch (playerZone[j][i]){
                        case 0:
                            break;
                        case 1:
                            g.drawImage(red, 15 + i *25, j *25 + 105, this);
                            break;
                        case 2:
                            g.drawImage(orange, 15 + i *25, j *25 + 105, this);
                            break;
                        case 3:
                            g.drawImage(yellow, 15 + i *25, j *25 + 105, this);
                            break;
                        case 4:
                            g.drawImage(green, 15 + i *25, j *25 + 105, this);
                            break;
                        case 5:
                            g.drawImage(lblue, 15 + i *25, j *25 + 105, this);
                            break;
                        case 6:
                            g.drawImage(dblue, 15 + i *25, j *25 + 105, this);
                            break;
                        case 7:
                            g.drawImage(purple, 15 + i *25, j *25 + 105, this);
                            break;
                        default:
                            break;
                    }
                }
            }
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
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;


public class GUI2 {
    int spacing = 5;
    BufferedImage red, orange, yellow, green, lblue, dblue, purple, logo, mit;
    Images img = new Images();
    int[][] playerZone = new int[24][10];
    int mx=0;
    int my=0;
    JFrame frame = new JFrame();

    public void setZone(int[][] zone) {
        playerZone=zone;
    }

    public GUI2() throws IOException {
        //Blokkok megteremtése
        for (int i=0; i<10; i++) {
            for (int j = 0; j < 24; j++) {
                playerZone[j][i]=(j%8);
            }
        }

        //Alapbeállítások
        frame.setTitle("Tetris");
        frame.setSize(1290, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setResizable(false);

        Board board = new Board();
        frame.setContentPane(board);
        board.setLayout(null);

        Move move = new Move();
        frame.addMouseMotionListener(move);

        Click click = new Click();
        frame.addMouseListener(click);

    }


    public class Board extends JPanel {
        //Trollkodás
        Image red = img.red.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image orange = img.orange.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image yellow = img.yellow.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image green = img.green.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image lblue = img.lblue.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image dblue = img.dblue.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image purple = img.purple.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        public void paintComponent(Graphics g) {
                    frame.setSize(650, 750);
                    g.setColor(Color.lightGray);
                    g.fillRect(0,0,640,720);
                    g.setColor(Color.white);
                    g.fillRect(15,105,250,600);
                    g.setColor(Color.white);
                    for (int i=0; i<10; i++) {
                        for (int j = 0; j < 24; j++) {
                            if(mx >= 22 + i *25 && mx < 47 + i *25 && my >= j *25 + 135 && my < j *25 + 160) {  //Szarul néznek ki a számok, de itt ez van...
                                continue;
                            }
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
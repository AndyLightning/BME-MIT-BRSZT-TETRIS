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
    private int nextObject;
    private Font font;


    public void setFont(Font param){
        font=param;
    }

    public void setNextObject (int num) {
        nextObject=num;
    }

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
        frame.setSize(650, 750);
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

    }


    public class Board extends JPanel {
        //Képek beolvasása
        Image red = img.red.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image orange = img.orange.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image yellow = img.yellow.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image green = img.green.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image lblue = img.lblue.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image dblue = img.dblue.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image purple = img.purple.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        Image n1 = img.n1.getScaledInstance(75, 110, Image.SCALE_DEFAULT);
        Image n2 = img.n2.getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        Image n3 = img.n3.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Image n4 = img.n4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
        Image n5 = img.n5.getScaledInstance(30, 90, Image.SCALE_DEFAULT);
        Image n6 = img.n6.getScaledInstance(95, 80, Image.SCALE_DEFAULT);
        Image n7 = img.n7.getScaledInstance(80, 70, Image.SCALE_DEFAULT);
        public void paintComponent(Graphics g) {
                    g.setColor(Color.lightGray);
                    g.fillRect(15,105,250,600);
                    g.setColor(Color.black);
                    g.setFont(font);
                    g.drawString("Következő blokk:", 420, 50);
                    switch (nextObject) {
                        case 1:
                            g.drawImage(n1, 430, 70, this);
                            break;
                        case 2:
                            g.drawImage(n2, 422, 70, this);
                            break;
                        case 3:
                            g.drawImage(n3, 430, 70, this);
                            break;
                        case 4:
                            g.drawImage(n4, 430, 70, this);
                            break;
                        case 5:
                            g.drawImage(n5, 453, 70, this);
                            break;
                        case 6:
                            g.drawImage(n6, 423, 70, this);
                            break;
                        case 7:
                            g.drawImage(n7, 430, 70, this);
                            break;
                    }
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
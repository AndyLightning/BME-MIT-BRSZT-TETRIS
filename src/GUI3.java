import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class GUI3 implements ActionListener{
    private boolean finished = false;
    private boolean win = false;
    private boolean exit=false;
    Images img = new Images();
    private String user;
    private String opponent;
    int[][] playerZone = new int[24][10];
    int[][] opponentZone = new int[24][10];
    int mx=0;
    int my=0;
    JFrame frame = new JFrame();
    private JLabel label1, label2, label3;
    private JButton button1;
    private int nextObject;
    private Font font;
    private int score;
    private int opponentScore;

    public void setExit(boolean logic) {
        exit=logic;
    }

    public boolean getExit() {
        return exit;
    }
    public void setFinished(boolean logic) {
        finished=logic;
    }
    public void setWin(boolean logic) {
        win=logic;
    }

    public void setUser(String name) {
        user=name;
    }

    public void setOpponent(String name) {
        opponent=name;
    }

    public void setScore (int num) {
        score=num;
    }
    public void setOpponentScore (int num) {
        opponentScore=num;
    }

    public void setFont(Font param){
        font=param;
    }

    public void setNextObject (int num) {
        nextObject=num;
    }

    public void setZone(int[][] zone) {
        playerZone=zone;
    }

    public void setOpponentZone(int[][] zone) {
        opponentZone=zone;
    }

    public GUI3() throws IOException {

        //Alapbeállítások
        frame.setTitle("Tetris Multiplayer");
        frame.setSize(650, 645);
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



        label1 = new JLabel("Elért pontszám:");
        label1.setBounds(260,305,300,15);
        board.add(label1);

        label2 = new JLabel("VS");
        label2.setFont(new Font("Dialog", Font.BOLD,24));
        label2.setBounds(300,220,300,30);
        board.add(label2);

        label3 = new JLabel("Ellenfél pontszáma:");
        label3.setBounds(260,345,300,15);
        board.add(label3);

        button1 = new JButton("Kilépés");
        button1.setBounds(258,550,120,50);
        button1.addActionListener(this);
        board.add(button1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        exit=true;
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
        Image bg1 = img.bg1.getScaledInstance(250, 600, Image.SCALE_DEFAULT);
        Image bg2 = img.bg2.getScaledInstance(250, 600, Image.SCALE_DEFAULT);
        public void paintComponent(Graphics g) {
            g.drawImage(bg1, 2, 5, this);
            g.drawImage(bg2, 385, 5, this);
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Következő blokk:", 270, 20);
            g.drawString("" + user, 316 - (g.getFontMetrics(font).stringWidth(user)/2), 220);
            g.drawString("" + opponent, 316 - (g.getFontMetrics(font).stringWidth(opponent)/2), 260);
            g.drawString("" + score, 260, 330);
            g.drawString("" + opponentScore, 260, 370);
            switch (nextObject) {
                case 1:
                    g.drawImage(n1, 280, 40, this);
                    break;
                case 2:
                    g.drawImage(n2, 272, 40, this);
                    break;
                case 3:
                    g.drawImage(n3, 280, 40, this);
                    break;
                case 4:
                    g.drawImage(n4, 280, 40, this);
                    break;
                case 5:
                    g.drawImage(n5, 303, 40, this);
                    break;
                case 6:
                    g.drawImage(n6, 273, 40, this);
                    break;
                case 7:
                    g.drawImage(n7, 280, 40, this);
                    break;
            }
            //Játékos területének kirajzolása
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    switch (opponentZone[j][i]){
                        case 0:
                            break;
                        case 1:
                            g.drawImage(red, 385 + i *25, j *25 + 5, this);
                            break;
                        case 2:
                            g.drawImage(orange, 385 + i *25, j *25 + 5, this);
                            break;
                        case 3:
                            g.drawImage(yellow, 385 + i *25, j *25 + 5, this);
                            break;
                        case 4:
                            g.drawImage(green, 385 + i *25, j *25 + 5, this);
                            break;
                        case 5:
                            g.drawImage(lblue, 385 + i *25, j *25 + 5, this);
                            break;
                        case 6:
                            g.drawImage(dblue, 385 + i *25, j *25 + 5, this);
                            break;
                        case 7:
                            g.drawImage(purple, 385 + i *25, j *25 + 5, this);
                            break;
                        default:
                            break;
                    }
                }
            }
            //Opponens területének kirajzolása
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    switch (playerZone[j][i]){
                        case 0:
                            break;
                        case 1:
                            g.drawImage(red, 2 + i *25, j *25 + 5, this);
                            break;
                        case 2:
                            g.drawImage(orange, 2 + i *25, j *25 + 5, this);
                            break;
                        case 3:
                            g.drawImage(yellow, 2 + i *25, j *25 + 5, this);
                            break;
                        case 4:
                            g.drawImage(green, 2 + i *25, j *25 + 5, this);
                            break;
                        case 5:
                            g.drawImage(lblue, 2 + i *25, j *25 + 5, this);
                            break;
                        case 6:
                            g.drawImage(dblue, 2 + i *25, j *25 + 5, this);
                            break;
                        case 7:
                            g.drawImage(purple, 2 + i *25, j *25 + 5, this);
                            break;
                        default:
                            break;
                    }
                }
            }
            //Eredmény kiírása
            if(finished) {
                if(win) {
                    g.drawString("Győzelem!", 316 - (g.getFontMetrics(font).stringWidth("Győzelem!")/2), 290);
                }
                else {
                    g.drawString("Vereség", 316 - (g.getFontMetrics(font).stringWidth("Vereség")/2), 290);
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
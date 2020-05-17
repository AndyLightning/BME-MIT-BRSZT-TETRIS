import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.border.EtchedBorder;


public class GUI1 implements ActionListener {
    private int requestScreen=0;
    int mx, my;
    JFrame frame = new JFrame();
    Images img = new Images();
    private JTextField text;
    private JButton button1, button2, button3, button4, button5, button6;
    private JLabel label1, label2;
    private String user;
    private Font font;
    private int difficulty=1;


    public void setFont(Font param){
        font=param;
    }

    public int getRequestScreen() {
        return requestScreen;
    }
    public void setRequestScreen(int num) {requestScreen=num;}
    public void setUser(String name) {
        user=name;
    }
    public int getDifficulty () {
        return difficulty;
    }


    public GUI1() throws IOException {
        //Alapbeállítások
        frame.setTitle("Főmenü");
        frame.setSize(650, 770);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setResizable(false);
        frame.setBackground(Color.lightGray);
        frame.setIconImage(img.mit);

        frame.setLayout(null);




        Move move = new Move();
        frame.addMouseMotionListener(move);

        Click click = new Click();
        frame.addMouseListener(click);


        Board board = new Board();
        frame.setContentPane(board);
        board.setLayout(null);



        label1 = new JLabel("Üdvözlünk");
        label1.setBounds(290,30,300,15);
        board.add(label1);

        button1 = new JButton("Egyjátékos Üzemmód");
        button1.setBounds(175,150,300,50);
        button1.addActionListener(this);
        board.add(button1);

        button2 = new JButton("Többjátékos Üzemmód");
        button2.setBounds(175,250,300,50);
        button2.addActionListener(this);
        board.add(button2);

        button3 = new JButton("Dicsőségtábla");
        button3.setBounds(175,350,300,50);
        button3.addActionListener(this);
        board.add(button3);

        button4 = new JButton("Könnyű");
        button4.setBounds(120,420,100,50);
        button4.addActionListener(this);
        board.add(button4);

        button5 = new JButton("Normális");
        button5.setBounds(270,420,100,50);
        button5.addActionListener(this);
        board.add(button5);


        button6 = new JButton("Nehéz");
        button6.setBounds(420,420,100,50);
        button6.addActionListener(this);
        board.add(button6);

        label2 = new JLabel("<html>Készítették:<br/>Dudás András<br/>Hartung Júlia<br/>Kenyeres Norbert  Gábor</html>");
        label2.setBounds(8,650,300,70);
        board.add(label2);

    }




    public class Board extends JPanel {

        Image iit = img.iit.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Image mit = img.mit.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        public void paintComponent(Graphics g) {
            g.setFont(font);
            g.drawString(user + "!", 319 - (g.getFontMetrics(font).stringWidth(user)/2), 60);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Egyjátékos Üzemmód":
                requestScreen=2;
                break;
            case "Többjátékos Üzemmód":
                requestScreen=3;
                break;
            case "Dicsőségtábla":
                requestScreen=4;
                break;
            case "Könnyű":
                difficulty=1;
                break;
            case "Normális":
                difficulty=2;
                break;
            case "Nehéz":
                difficulty=3;
                break;

        }
    }
}
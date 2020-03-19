import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class GUI0 implements ActionListener {
    boolean finished=false;
    int mx, my;
    JFrame frame = new JFrame();
    Images img = new Images();
    private JTextField text;
    private JButton button;
    private JLabel label1, label2, label3;
    private String user;

    public boolean getFinished() {
        return finished;
    }
    public void resetFinished(){
        finished=false;
    }
    public String getUser() {
        return user;
    }

    public GUI0() throws IOException {

        //Alapbeállítások
        frame.setTitle("Belépés");
        frame.setSize(650, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.lightGray);
        frame.setIconImage(img.khazy);

        frame.setLayout(null);

        Move move = new Move();
        frame.addMouseMotionListener(move);

        Click click = new Click();
        frame.addMouseListener(click);

        Board board = new Board();
        frame.setContentPane(board);
        board.setLayout(null);

        text = new JTextField(20);
        text.setBounds(100,100,450,30);
        board.add(text);

        button = new JButton("Belépés!");
        button.setBounds(275,150,100,25);
        button.addActionListener(this);
        board.add(button);

        label1 = new JLabel("Kérlek add meg a felhasználónevedet!");
        label1.setBounds(215,70,300,15);
        board.add(label1);

        label2 = new JLabel("Powered by");
        label2.setBounds(290,190,300,15);
        board.add(label2);

        label3 = new JLabel("&");
        label3.setBounds(320,240,15,15);
        board.add(label3);
    }




    public class Board extends JPanel {

        Image iit = img.iit.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Image mit = img.mit.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        public void paintComponent(Graphics g) {
            g.drawImage(mit, 250, 220, this);
            g.drawImage(iit, 350, 220, this);
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
        user = text.getText();
        if (user == null || user.isEmpty())
            user = "n00b";
        System.out.println(user);
        finished=true;
    }
}

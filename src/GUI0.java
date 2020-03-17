import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class GUI0 {
    int spacing = 5;
    int mx, my;
    JFrame frame = new JFrame();


    public GUI0() throws IOException {
        //Blokkok megteremtése


        //Alapbeállítások
        frame.setTitle("Belépés");
        frame.setSize(650, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setResizable(false);


        Move move = new Move();
        frame.addMouseMotionListener(move);

        Click click = new Click();
        frame.addMouseListener(click);

        Board board = new Board();
        frame.setContentPane(board);
        placeComponents(board);

    }

    public class Board extends JPanel {

    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Kérlek add meg a felhasználónevedet!");
        label.setBounds(215,70,300,15);
        panel.add(label);

        JTextField text = new JTextField(20);
        text.setBounds(100,100,450,30);
        panel.add(text);
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

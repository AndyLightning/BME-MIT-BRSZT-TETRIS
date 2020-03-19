import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;

public class Images{
        BufferedImage red, orange, yellow, green, lblue, dblue, purple, iit, mit, khazy, n1, n2, n3, n4, n5, n6, n7, bg1;

        public Images() throws IOException {
            red = ImageIO.read(new File("img/Red.png"));
            orange = ImageIO.read(new File("img/Orange.png"));
            yellow = ImageIO.read(new File("img/Yellow.png"));
            green = ImageIO.read(new File("img/Green.png"));
            lblue = ImageIO.read(new File("img/LBlue.png"));
            dblue = ImageIO.read(new File("img/DBlue.png"));
            purple = ImageIO.read(new File("img/Purple.png"));
            iit = ImageIO.read(new File("img/IIT.png"));
            mit = ImageIO.read(new File("img/MIT.png"));
            khazy = ImageIO.read(new File("img/khazy.jpg"));
            n1 = ImageIO.read(new File("img/N1.png"));
            n2 = ImageIO.read(new File("img/N2.png"));
            n3 = ImageIO.read(new File("img/N3.png"));
            n4 = ImageIO.read(new File("img/N4.png"));
            n5 = ImageIO.read(new File("img/N5.png"));
            n6 = ImageIO.read(new File("img/N6.png"));
            n7 = ImageIO.read(new File("img/N7.png"));
            bg1 = ImageIO.read(new File("img/Background1.png"));
        }

}

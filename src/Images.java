import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;

public class Images{
        BufferedImage red, orange, yellow, green, lblue, dblue, purple, iit, mit, khazy;

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
        }

}

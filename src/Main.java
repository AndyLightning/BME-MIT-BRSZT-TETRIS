import java.io.IOException;

public class Main implements Runnable{

    GUI gui = new GUI();


    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();

    }
    @Override
    public void run(){
        gui.repaint();
    }


    public Main() throws IOException {
    }
}

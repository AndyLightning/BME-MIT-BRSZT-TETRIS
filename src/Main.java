import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{

    GUI gui = new GUI();


    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();

    }



        @Override
        public void run() {
            while (true) {
                gui.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    public Main() throws IOException {
    }
}

import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{

   //GUI gui = new GUI();
   GUI0 gui2 = new GUI0();


    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();
    }



        @Override
        public void run() {
            while (true) {
                //gui.repaint();
                gui2.frame.setVisible(true);
                gui2.frame.repaint();
                //gui.dispose();
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

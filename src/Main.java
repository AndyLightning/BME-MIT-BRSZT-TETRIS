import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{
    GUI gui = new GUI();
    GUI0 gui0 = new GUI0();
    Info info = new Info();


    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();
    }



        @Override
        public void run() {
            while (true) {
                switch(info.getScreen()) {
                    case 0:
                        gui0.frame.repaint();
                        break;
                    case 1:
                        gui.repaint();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;

                }
                if (gui0.getFinished()) {
                    gui0.frame.dispose();
                    gui0.resetFinished();
                    info.setScreen(1);
                    info.setUser(gui0.getUser());
                    gui.setVisible(true);
                }

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

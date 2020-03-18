import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{
    GUI gui = new GUI();
    GUI0 gui0 = new GUI0();
    GUI1 gui1 = new GUI1();
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

                        //Kijelzőváltás
                        if (gui0.getFinished()) {
                            gui0.frame.dispose();
                            gui0.resetFinished();
                            info.setScreen(1);
                            info.setUser(gui0.getUser());
                            gui1.setUser(info.getUser());
                            gui1.setFont(info.getFont());
                            gui1.frame.setVisible(true);
                        }
                        break;
                    case 1:
                        gui1.frame.repaint();

                        //Kijelzőváltás
                        if(gui1.getRequestScreen() != 0) {
                            info.setScreen(gui1.getRequestScreen());
                        }
                        break;
                    case 2:
                       // gui.repaint();
                        System.out.println(info.getScreen());
                        break;
                    case 3:
                        System.out.println(info.getScreen());
                        break;
                    case 4:
                        System.out.println(info.getScreen());
                        break;
                    default:
                        break;

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

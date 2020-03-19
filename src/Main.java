import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{
    GUI gui = new GUI();
    GUI0 gui0 = new GUI0();
    GUI1 gui1 = new GUI1();
    GUI2 gui2 = new GUI2();
    GUI4 gui4 = new GUI4();
    Info info = new Info();


    int[][] playerZone = new int[24][10];




    public static void main(String[] args) throws IOException {

        new Thread(new Main()).start();
    }



        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    playerZone[j][i]=(j%8);
                }
            }
            info.setPlayerZone(playerZone);
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
                            gui1.frame.dispose();
                            info.setScreen(gui1.getRequestScreen());
                            gui2.setFont(info.getFont());
                            gui2.frame.setVisible(true);
                        }
                        break;
                    case 2:
                        gui2.frame.repaint();
                        gui2.setZone(info.getPlayerZone());
                        gui2.setNextObject(info.getNextObject());
                        gui2.setScore(info.getScore());

                        //Kijelzőváltás
                        if(info.getFinished()) {
                            gui2.frame.dispose();
                            info.setScreen(4);
                            gui4.setFont(info.getFont());
                            gui4.frame.setVisible(true);
                        }
                        break;
                    case 3:
                        System.out.println(info.getScreen());
                        break;
                    case 4:
                        gui4.frame.setVisible(true);
                        gui4.frame.repaint();
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

import java.io.IOException;
import java.util.TimerTask;

public class Main implements Runnable{
    //Változók, osztálypéldányok
    //A felhasznált gui megnevezések megegyeznek a githubon jelöltekkel, de a rend kedvéért:
    //0: Login
    //1: Menu
    //2: Single
    //3: Multiplayer
    //4: Highscore
    //Az info osztály tartalmazza a legfontosabb információkat
    GUI0 gui0 = new GUI0();
    GUI1 gui1 = new GUI1();
    GUI2 gui2 = new GUI2();
    GUI3 gui3 = new GUI3();
    GUI4 gui4 = new GUI4();
    Info info = new Info();
    String[] legjobbak = new String[10];
    int[] legjobbPontok = new int[10];
    int[][] playerZone = new int[24][10];




    public static void main(String[] args) throws IOException {

        new Thread(new Main()).start();
    }



        @Override
        public void run() {

        //Tesztkód, a végén törölhető
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 24; j++) {
                    playerZone[j][i]=(j%8);
                }
            }
            legjobbak[0]="asd";
            legjobbak[1]="MIT";
            legjobbak[2]="Kovács Alajos Lajos László";
            legjobbak[3]="BME";
            legjobbak[4]="IIT";
            legjobbak[5]="A";
            legjobbak[6]="Charaf Gábor";
            legjobbak[7]="Tevesz Hassan";
            legjobbak[8]="Dudás András";
            legjobbak[9]="C++";
            legjobbPontok[0]=0;
            legjobbPontok[1]=0;
            legjobbPontok[2]=0;
            legjobbPontok[3]=0;
            legjobbPontok[4]=0;
            legjobbPontok[5]=0;
            legjobbPontok[6]=0;
            legjobbPontok[7]=0;
            legjobbPontok[8]=999999;
            legjobbPontok[9]=0;

            //Ezeknek a kezelését még meg kell oldani, ha a tesztkódot eltüntetjük
            info.setPlayerZone(playerZone);
            info.setLegjobbak(legjobbak);
            info.setLegjobbPontok(legjobbPontok);
            info.setOpponentZone(playerZone);
            //Idáig tart a tesztkód

            //Actually important kód
            gui1.setFont(info.getFont());
            gui2.setFont(info.getFont());
            gui3.setFont(info.getFont());
            gui4.setFont(info.getFont());
            while (true) {

                //A screen alapján kiválasztja, melyik gui fusson
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
                            gui1.frame.setVisible(true);
                        }
                        break;
                    case 1:
                        gui1.frame.repaint();

                        //Kijelzőváltás
                        if(gui1.getRequestScreen() != 0) {
                            gui1.frame.dispose();
                            info.setScreen(gui1.getRequestScreen());
                            switch (info.getScreen()) {
                                case 2:
                                    gui2.frame.setVisible(true);
                                    break;
                                case 3:
                                    gui3.setUser(info.getUser());
                                    gui3.setOpponent(info.getOpponent());
                                    gui3.frame.setVisible(true);
                                    break;
                                case 4:
                                    gui4.setLegjobbak(info.getLegjobbak());
                                    gui4.setLegjobbPontok(info.getLegjobbPontok());
                                    gui4.frame.setVisible(true);
                                    break;
                                default:
                                    break;
                            }
                            gui1.setRequestScreen(0);
                        }
                        break;
                    case 2:
                        gui2.frame.repaint();
                        gui2.setZone(info.getPlayerZone());
                        gui2.setNextObject(info.getNextObject());
                        gui2.setScore(info.getScore());

                        //Kijelzőváltás
                        if(gui2.getExit()) {
                            gui2.setExit(false);
                            gui2.frame.dispose();
                            info.setScreen(4);
                            gui4.setLegjobbak(info.getLegjobbak());
                            gui4.setLegjobbPontok(info.getLegjobbPontok());
                            gui4.frame.setVisible(true);
                        }
                        break;
                    case 3:
                        gui3.frame.repaint();
                        gui3.setZone(info.getPlayerZone());
                        gui3.setOpponentZone(info.getOpponentZone());
                        gui3.setNextObject(info.getNextObject());
                        gui3.setScore(info.getScore());
                        gui3.setOpponentScore(info.getOpponentScore());

                        //Kijelzőváltás
                        if(gui3.getExit()) {
                            gui3.setExit(false);
                            gui3.setFinished(false);
                            gui3.frame.dispose();
                            info.setScreen(4);
                            gui4.setLegjobbak(info.getLegjobbak());
                            gui4.setLegjobbPontok(info.getLegjobbPontok());
                            gui4.frame.setVisible(true);
                        }
                        break;
                    case 4:
                        gui4.setLegjobbak(info.getLegjobbak());
                        gui4.setLegjobbPontok(info.getLegjobbPontok());
                        gui4.frame.repaint();

                        //Kijelzőváltás
                        if(gui4.getFinished()) {
                            gui4.resetFinished();
                            gui4.frame.dispose();
                            info.setScreen(1);
                            gui1.frame.setVisible(true);
                        }
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

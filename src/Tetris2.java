import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.*;

import static java.awt.SystemColor.info;

public class Tetris2 extends JFrame {
    private JLabel statusBar;
    //int[][] playerZone = new int[24][10];
    Board board = new Board(this);
    public int[][] getZone() {
        return board.getPlayerZone();
    }
    public int getBoardScore(){
        return board.getRemovedLines();
    }
    public int getNextObject() {return board.getNextObject();}
    public void setStart() {
        board.start();
    }
    public void setDiff(int num) {board.setDiff(num);}
    public Tetris2() throws IOException {
        //Main asdMaster;
        //asdMaster = new Main();

        System.out.println("asd");
        statusBar = new JLabel("0");
        add(statusBar, BorderLayout.SOUTH);
        add(board);
        setSize(800, 512);
        setTitle("My Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) throws IOException {
        String[] legjobbak = new String[10];
        int[] legjobbPontok = new int[10];
        //Fájlolvasás
        FileReader fr = new FileReader("src/highscore.txt");
        int fread;
        for(int i =0;i<10;i++) {
            System.out.println("Következő:");
            String Name = "";
            while((fread=fr.read()) != ':')
                Name=Name+(char)fread;
            System.out.println(Name);
            legjobbak[i]=Name;
            int Scored = 0;
            int num=1000;
            while((fread=fr.read()) != '\n') {
                Scored += num * (fread-'0');
                num = num / 10;
            }
            System.out.println(Scored);
            legjobbPontok[i]=Scored;
        }
        //while ((fread=fr.read()) != -1)
            //System.out.print((char) fread);




        Tetris2 myTetris = new Tetris2();
        myTetris.setLocationRelativeTo(null);
        myTetris.setVisible(true);
        boolean BME=true;
        GUI0 gui0 = new GUI0();
        GUI1 gui1 = new GUI1();
        GUI2 gui2 = new GUI2();
        GUI3 gui3 = new GUI3();
        GUI4 gui4 = new GUI4();
        Info info = new Info();
        int[][] playerZone = new int[24][10];
        //Tesztkód, a végén törölhető
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 24; j++) {
                playerZone[j][i] = (j % 8);
            }
        }
        playerZone[3][4] = 0;
        /*
        legjobbak[0] = " asd";
        legjobbak[1] = "MIT";
        legjobbak[2] = "Kovács Alajos Lajos László";
        legjobbak[3] = "BME";
        legjobbak[4] = "IIT";
        legjobbak[5] = "A";
        legjobbak[6] = "Charaf Gábor";
        legjobbak[7] = "Tevesz Hassan";
        legjobbak[8] = "Dudás András";
        legjobbak[9] = "C++";
        legjobbPontok[0] = 0;
        legjobbPontok[1] = 0;
        legjobbPontok[2] = 0;
        legjobbPontok[3] = 0;
        legjobbPontok[4] = 0;
        legjobbPontok[5] = 0;
        legjobbPontok[6] = 0;
        legjobbPontok[7] = 0;
        legjobbPontok[8] = 999999;
        legjobbPontok[9] = 0;
        */
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

            if (info.getScreen() == 2) {

            }

            if (info.getScreen() == 3) {

            }
            //System.out.println("" + info.getDifficulty());
            //A screen alapján kiválasztja, melyik gui fusson
            switch (info.getScreen()) {
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
                    info.setDifficulty(gui1.getDifficulty());
                    //Kijelzőváltás
                    if (gui1.getRequestScreen() != 0) {
                        myTetris.setDiff(info.getDifficulty());
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
                    if(BME) {
                        BME = false;
                        myTetris.setStart();
                    }

                    info.setPlayerZone(myTetris.getZone());
                    gui2.frame.repaint();
                    gui2.setZone(info.getPlayerZone());
                    info.setNextObject(myTetris.getNextObject());
                    gui2.setNextObject(info.getNextObject());
                    gui2.setScore(info.getScore());
                    info.setScore(myTetris.getBoardScore());
                    System.out.println("Nehézség:");
                    System.out.println(info.getDifficulty());
                    //Kijelzőváltás
                    if (gui2.getExit()) {
                        BME=true;
                        gui2.setExit(false);
                        gui2.frame.dispose();
                        info.setScreen(4);
                        gui4.setLegjobbak(info.getLegjobbak());
                        gui4.setLegjobbPontok(info.getLegjobbPontok());
                        gui4.frame.setVisible(true);
                        String[] newBest = info.getLegjobbak();
                        int[] newNum = info.getLegjobbPontok();
                        for (int i = 0; i < 10; i++)
                            for (int j = i+1; j < 10; j++)
                                if (newNum[j] > newNum[i]) {
                                    int temp = newNum[j];
                                    newNum[j] = newNum[i];
                                    newNum[i] = temp;
                                    String tempStr =newBest[j];
                                    newBest[j]=newBest[i];
                                    newBest[i]=tempStr;
                                }
                        int i;
                        for (i=9;i>=0;i--) {
                            if(info.getScore()<newNum[i]) {
                                break;
                            }
                        }
                        int nextInt=info.getScore();
                        String nextStr=info.getUser();
                        for(int j=i+1;j<9;j++) {
                            int temp=newNum[j];
                            newNum[j]=nextInt;
                            nextInt=temp;
                            String tempStr=newBest[j];
                            newBest[j]=nextStr;
                            nextStr=tempStr;
                        }
                        info.setLegjobbPontok(newNum);
                        info.setLegjobbak(newBest);
                    }
                    break;
                case 3:
                    if(BME) {
                        BME = false;
                        myTetris.setStart();
                    }
                    info.setPlayerZone(myTetris.getZone());
                    info.setNextObject(myTetris.getNextObject());
                    info.setScore(myTetris.getBoardScore());
                    gui3.frame.repaint();
                    gui3.setZone(info.getPlayerZone());
                    gui3.setOpponentZone(info.getOpponentZone());
                    gui3.setNextObject(info.getNextObject());
                    gui3.setScore(info.getScore());
                    gui3.setOpponentScore(info.getOpponentScore());

                    //Kijelzőváltás
                    if (gui3.getExit()) {
                        BME=true;
                        gui3.setExit(false);
                        gui3.setFinished(false);
                        gui3.frame.dispose();
                        info.setScreen(4);
                        gui4.setLegjobbak(info.getLegjobbak());
                        gui4.setLegjobbPontok(info.getLegjobbPontok());
                        gui4.frame.setVisible(true);
                        String[] newBest = info.getLegjobbak();
                        int[] newNum = info.getLegjobbPontok();
                        for (int i = 0; i < 10; i++)
                            for (int j = i+1; j < 10; j++)
                                if (newNum[j] > newNum[i]) {
                                    int temp = newNum[j];
                                    newNum[j] = newNum[i];
                                    newNum[i] = temp;
                                    String tempStr =newBest[j];
                                    newBest[j]=newBest[i];
                                    newBest[i]=tempStr;
                                }
                        int i;
                        for (i=9;i>=0;i--) {
                            if(info.getScore()<newNum[i]) {
                                break;
                            }
                        }
                        int nextInt=info.getScore();
                        String nextStr=info.getUser();
                        for(int j=i+1;j<9;j++) {
                            int temp=newNum[j];
                            newNum[j]=nextInt;
                            nextInt=temp;
                            String tempStr=newBest[j];
                            newBest[j]=nextStr;
                            nextStr=tempStr;
                        }
                        info.setLegjobbPontok(newNum);
                        info.setLegjobbak(newBest);
                    }
                    break;
                case 4:
                    gui4.setLegjobbak(info.getLegjobbak());
                    gui4.setLegjobbPontok(info.getLegjobbPontok());
                    gui4.frame.repaint();

                    //Kijelzőváltás
                    if (gui4.getFinished()) {
                        gui4.resetFinished();
                        gui4.frame.dispose();
                        info.setScreen(1);
                        gui1.frame.setVisible(true);
                        File myFoo = new File("src/highscore.txt");
                        FileWriter fooWriter = new FileWriter(myFoo, false);
                        for(int i=0;i<10;i++) {
                            fooWriter.write(info.getLegjobbak()[i]);
                            fooWriter.write(':');
                            fooWriter.write(String.format("%04d", info.getLegjobbPontok()[i]));
                            fooWriter.write(System.getProperty( "line.separator" ));
                        }
                        fooWriter.close();
                    }
                    break;
                default:
                    break;

            }
            try {
                Thread.sleep(50); //Átírható, terhelés függvényében
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

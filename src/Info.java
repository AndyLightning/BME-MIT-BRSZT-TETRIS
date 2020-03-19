import java.awt.*;

public class Info {
    private boolean finished = false;
    private int screen=0;
    private String user="IIT=Best";
    private String opponent="IIT=Best";
    private Font font = new Font("Dialog", Font.BOLD,12);
    private int[][] playerZone = new int[24][10];
    private int[][] opponentZone = new int[24][10];
    private String[] legjobbak = new String[10];
    private int[] legjobbPontok = new int[10];
    private int nextObject=4;
    private int score=0;
    private int opponentScore=0;

    public void setScreen(int i) {
        screen=i;
    }
    public int getScreen(){
        return screen;
    }
    public void setUser(String name) {
        user=name;
    }
    public String getUser(){
        return user;
    }
    public void setOpponent(String name) {
        opponent=name;
    }
    public String getOpponent(){
        return opponent;
    }
    public Font getFont() { return font; }
    public void setPlayerZone(int[][] zone) {
        playerZone=zone;
    }
    public void setOpponentZone(int[][] zone) {
        opponentZone=zone;
    }
    public int[][] getPlayerZone(){
        return playerZone;
    }
    public int[][] getOpponentZone(){
        return opponentZone;
    }
    public void setNextObject (int num) {
        nextObject=num;
    }
    public int getNextObject () {
        return nextObject;
    }
    public int getScore () {
        return score;
    }
    public void setScore (int num) {
        score=num;
    }
    public int getOpponentScore () {
        return opponentScore;
    }
    public void setOpponentScore (int num) {
        opponentScore=num;
    }
    public void setFinished (boolean logic) {
        finished=logic;
    }
    public boolean getFinished () {
        return finished;
    }
    public void setLegjobbak (String[] param) {
        legjobbak=param;
    }
    public String[] getLegjobbak () {
        return legjobbak;
    }
    public void setLegjobbPontok (int[] param) {
        legjobbPontok=param;
    }
    public int[] getLegjobbPontok () {
        return legjobbPontok;
    }
}

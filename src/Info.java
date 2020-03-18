import java.awt.*;

public class Info {
    private int screen=0;
    private String user;
    private Font font = new Font("Dialog", Font.BOLD,12);
    private int[][] playerZone = new int[24][10];
    private int[][] opponentZone = new int[24][10];
    private int nextObject=2;

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
}

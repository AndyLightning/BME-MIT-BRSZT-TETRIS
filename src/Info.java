import java.awt.*;

public class Info {
    private int screen=0; //aktuális képernyő
    private String user="n00b"; //játékosnév
    private String opponent="n00b"; //ellenfél neve
    private Font font = new Font("Dialog", Font.BOLD,12);
    private int[][] playerZone = new int[24][10]; //játékos területe
    private int[][] opponentZone = new int[24][10]; //ellenfél területe
    private String[] legjobbak = new String[10]; //highscoreban szereplő felhasználók
    private int[] legjobbPontok = new int[10]; //hozzájuk tartozó pontok
    private int nextObject=0; //soron következő objektum
    private int score=0; //játékos aktuális pontja
    private int opponentScore=0; //ellenfél pontja
    private int difficulty=1;

    //getterek és setterek
    //az itt megjelölteket és a tesztkódban kiemelteket kell majd használni a mainben, a többit már érdemben lekezeltem
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
    } //Oponens nevének beállítása
    public String getOpponent(){
        return opponent;
    }
    public Font getFont() { return font; }
    public void setPlayerZone(int[][] zone) {
        playerZone=zone;
    }
    public void setOpponentZone(int[][] zone) { opponentZone=zone; }
    public int[][] getPlayerZone(){
        return playerZone;
    }
    public int[][] getOpponentZone(){
        return opponentZone;
    }
    public void setNextObject (int num) {
        nextObject=num;
    } //következő objektum beállítása
    public int getNextObject () {
        return nextObject;
    }
    public int getScore () {
        return score;
    }
    public void setScore (int num) {
        score=num;
    } //játékos pontjának megadása
    public int getOpponentScore () {
        return opponentScore;
    }
    public void setOpponentScore (int num) {
        opponentScore=num;
    } //ellenfél pontjai
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
    public void setDifficulty(int num) {
        difficulty=num;
    }
    public int getDifficulty () {
        return difficulty;
    }
}

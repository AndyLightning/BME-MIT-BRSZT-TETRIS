import java.awt.*;

public class Info {
    private int screen=0;
    private String user;
    private Font font = new Font("Dialog", Font.BOLD,12);
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

}

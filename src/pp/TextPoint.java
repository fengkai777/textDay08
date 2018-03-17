package pp;

public class TextPoint {
    private int x;
    private int y;

    public void TextPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
     public void print(){
         System.out.println(x+","+y);
     }
}

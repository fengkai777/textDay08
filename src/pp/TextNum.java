package pp;

public class TextNum {

    {
        i=111;
    }

    private int i=10;

    {
        i=100;
    }

    public TextNum(){
        int i=1;
    }

    {
        i=55;
    }

    void output(){
        i=5;
    }
    {
        i=15;
    }

     public static void main(String[] args) {
        TextNum a=new TextNum();
        a.output();
         System.out.println(a.i);
    }
}

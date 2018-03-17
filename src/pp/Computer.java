package pp;

public class Computer {

    public void doPrint(Print agdsf){
            agdsf.a();
    }


    public static void main(String[] args) {

        Computer computer=new Computer();
        BWPrinter a1=new BWPrinter();
        computer.doPrint(a1);
        ColorPrinter a2=new ColorPrinter();
        computer.doPrint(a2);
    }
}

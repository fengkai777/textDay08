package pp;

public class Phone {
    private String name;
    private int price;
    private String color;

    public  void Phone(String name,int price,String color){
        this.name=name;
        this.price=price;
        this.color=color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display(){
        System.out.println(name+" "+color+" "+price+"元");
    }
    static void phone(){
        System.out.println("打电话");
    }

}

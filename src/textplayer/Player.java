package textplayer;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Player {
    private String name;
    private int age;
    private int id;
    private double salary;
    private String location;

    private static int count=1; //计数器

    //构造代码块
    {
        this.id=count++;
    }

    public Player(){}

    public Player(String name,int age,double salary,String location){
        this.setAge(age);
        this.setLocation(location);
        this.setName(name);
        this.setSalary(salary);
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0||age >45){
            this.age=19;
        }else {
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary>0)
            this.salary=0;
        else
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void shot(){
        System.out.println(this.getName()+"投篮练习中~~~");
    }

    public void passBall(){
        System.out.println(this.getName()+"传球练习中~~~");
    }
}

package textplayer;

import java.util.Scanner;

public class TeamManager {
    //球队的名字
    private String teamName;
    //保存球员信息的数据
    private Player [] allPlayers = new Player[defaultCount];

    //统计当前球队中有多少球员
    private static int itemCont=0;
    //球队的默认球员个数
    private static final int defaultCount = 10;

    public TeamManager(){}

    public TeamManager(String teamName){
        this.setTeamName(teamName);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 添加球员
     * 解雇球员
     * 修改球员信息
     * 查询球员信息
     *
     * 排序算法
     *
     * 数组增长
     * */

    /**
     * 添加球员到数组中
     * */
    public void addPlayer(Player playerToAdd){
        //参数合法性判断（异常处理）
        if (null == playerToAdd){
            System.out.println("球员信息为空，不可添加");
            return;
        }

        //累内有一个itemCount的静态成员变量，是用来统计插入的元素个数，而且也是下个元素保存的下标位置
        //因为是插入操作，所有要考虑数组的容量问题，如果插入的数据个数一加大于了数组的长度，需要扩容
        if (itemCont>=allPlayers.length){
            //扩容
            grow();
        }
        allPlayers[itemCont++]=playerToAdd;
    }

    /**
     * 需要一个扩容方法，方法不需要参数，不要类外调用，只是在类内使用
     * */
    private void grow(){
        //获取数组元素个数
        int oldCapacity=allPlayers.length;
        //新数组元素个数
        int newCapacity=oldCapacity+oldCapacity/2;
        //创建新的数组
        Player []  newArray= new Player[newCapacity];
        //循环拷贝
        for (int i = 0; i < oldCapacity; i++) {
            newArray[i]=this.allPlayers[i];
        }
        //地址交换
        this.allPlayers=newArray;
    }
    /**
     * 私有化方法，只是提供给类内使用，用来获取指定球员ID在数组中下标的位置
     * @param playerID 要查询的球员ID
     * @return int类型，返回查询的数据在数组中的下标位置，如果没有找到，返回-1
     * */
    private int findPlayerIndexByPlayerID(int playerID){
        //参数合法性判断
        if (playerID<1||playerID>100){
            System.out.println("传入球员ID不合法");
            return -1;
        }
        //用来保存球员的下标位置
        int index=-1;
        for (int i = 0; i < itemCont; i++) {
            //拿球员的ID和传入的ID进行比较
            if (allPlayers[i].getId()==playerID){
                index=i;
                break;
            }
        }
        return index;
    }

    /**
     * * 通过球员的ID删除球员
     * @param playerID
     * */
    public void layoffPlayerByPlayerID(int playerID){
        //需求查询方法，调用类内私有化通过球员ID查询球员在数组中位置的方法，获取下标
        int index=findPlayerIndexByPlayerID(playerID);

        if (index>=0){
            //删除该位置的球员，数组整体向左移
            for (int i = index; i <itemCont-1 ; i++) {
                allPlayers[i]=allPlayers[i+1];
            }
            //原本最后一个有效元素赋值为null
            allPlayers[itemCont-1]=null;

            //球队的球员个数-1
            itemCont--;
        }else {
            System.out.println("查无此人，无法删除");
        }
    }

    /**
     * 通过球员的ID，来查询球员的信息
     * @param playerID 要展示的球员的ID号
     * */
    public void showPlayerInforPlayerID(int playerID){
        int index=findPlayerIndexByPlayerID(playerID);
        if (index>-1){
            System.out.println(allPlayers[index]);
        }else {
            System.out.println("查无此人");
        }

    }
    /**
     * 通过球员ID 修改球员信息
     * @param playerID 需要修改信息的球员ID
     * */
    public void modifyPlayerInfoByPlayerID(int playerID){
        int index = findPlayerIndexByPlayerID(playerID);
        Scanner sc = new Scanner(System.in);
        //表示找到球员，进行修改
        if (index>-1){
            int flag = 0;
            int choose =-1;
            Player temp = allPlayers[index];
            while (true){
                System.out.println("修改"+temp.getId()+":"+temp.getName()+"的信息");
                System.out.println("***Age:"+temp.getAge());
                System.out.println("***Salary:"+temp.getSalary());
                System.out.println("***Location:"+temp.getLocation());

                System.out.println("1.修改球员姓名");
                System.out.println("2.修改球员年龄");
                System.out.println("3.修改球员工资");
                System.out.println("4.修改球员位置");
                System.out.println("5.退出");

                switch (choose){
                    case 1:
                        System.out.println("请输入球员姓名：");
                        String name = sc.nextLine();
                        temp.setName(name);
                        break;
                    case 2:
                        System.out.println("请输入球员年龄：");
                        int age = sc.nextInt();
                        temp.setAge(age);
                        break;
                    case 3:
                        System.out.println("请输入球员工资：");
                        double salary = sc.nextDouble();
                        temp.setSalary(salary);
                        break;
                    case 4:
                        System.out.println("请输入球员位置：");
                        String location  = sc.nextLine();
                        temp.setLocation(location);
                        break;
                    case 5:
                        flag=1;
                        break;
                    default:
                        System.out.println("选择错误");
                        break;
                }
                if (1==flag){
                    allPlayers[index]=temp;
                    System.out.println("保存退出");
                    break;
                }
            }
        }else{
            System.out.println("查无此人");
        }

    }
    /**
     * 工资的降序排序
     * */
    public void descendingSelectSortBySalary(){
        //保护原数据
        //准备一个数组专门用来做排序操作，数组的大小和原数据有效元素个数一致
        Player[] sortArray = new Player[itemCont];

        //数据拷贝
        for (int i = 0; i < itemCont; i++) {
            sortArray[i]=allPlayers[i];
        }
        //外层控制选择排序的次数
        for (int i = 0; i < itemCont-1; i++) {
            int index = i;
            for (int j = i+1; j <itemCont ; j++) {
                if (sortArray[index].getSalary()<sortArray[j].getSalary()){
                    index=j;
                }
            }
            if (index!=1){
                Player temp = sortArray[index];
                sortArray[index]=sortArray[i];
                sortArray[i]=temp;
            }
        }
        showSortResult(sortArray);
    }
    //展示增强for循环
    private void showSortResult(Player[] sortArray){
        for (Player player:sortArray) {
            System.out.println(player);
        }
    }

    public void showAllPlayers(){
        for (Player player:allPlayers) {
            System.out.println();
            
        }
    }

}

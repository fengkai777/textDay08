package textplayer;

public class View {

    public static void main(String[] args) {
        TeamManager tm = new TeamManager("孤狼B组");

        Player p1 = new Player("森林狼",21,10000,"PG");
        Player p2 = new Player("西伯利亚狼",19,9000,"SF");
        Player p3 = new Player("鸵鸟",20,9500,"SG");
        Player p4 = new Player("卫生员",22,9800,"SG");
        Player p5 = new Player("恶狼",22,8800,"PF");
        Player p6 = new Player("老炮",22,9900,"C");

        tm.addPlayer(p1);
        tm.addPlayer(p2);
        tm.addPlayer(p3);
        tm.addPlayer(p4);
        tm.addPlayer(p5);
        tm.addPlayer(p6);

        tm.showAllPlayers();

    }
}

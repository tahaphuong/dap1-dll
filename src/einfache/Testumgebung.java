package einfache;

public class Testumgebung {
    public static void main(String args[]) {
        Group gg = new Group(6);
        gg.insert(new Tupel("1", 1));
        gg.insert(new Tupel("2", 2));
        gg.insert(new Tupel("3", 3));
        gg.insert(new Tupel("4", 4));
        gg.insert(new Tupel("5", 5));
        gg.insert(new Tupel("6", 6));
        System.out.println(Use.maxValue(gg));
    }
}

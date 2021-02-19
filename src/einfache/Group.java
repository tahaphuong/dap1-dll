package einfache;

public class Group {
    private Tupel[] map;
    public Group(int n) {
        map = new Tupel[n];
    }
    public int size() {
        return map.length;
    }
    public Tupel delete(int i) {
        if(i<0 || i>=size()) {
            return null;
        }
        Tupel t = map[i];
        map[i] = null;
        return t;
    }
    public Group copy() {
        Group g2 = new Group(size());
        for (int i=0; i<size(); i++) {
            g2.map[i] = map[i] == null ? null : new Tupel(map[i].getText(), map[i].getValue());
        }
        return g2;
    }
    public boolean insert(Tupel p) {
        if(p == null) {
            return false;
        }
        for(int i=0; i<size(); i++) {
            if(map[i] == null) {
                map[i] = p;
                return true;
            }
        }
        return false;
    }
    public String toString() {
        for(int i=0; i<size(); i++) {
            String separator = i == size()-1 ? "." : ", ";
            System.out.print((map[i] == null ? null : map[i].getValue()) + separator);
        }
        return null;
    }
}

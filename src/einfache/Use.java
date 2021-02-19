package einfache;

public class Use {
    public static Group extract(Group g, int v) {
        Group g2 = g.copy();
        int count = 0;
        Tupel[] tupels = new Tupel[g2.size()];
        for(int i=0; i<g2.size(); i++) {
            Tupel t = g2.delete(i);
            if(t != null && t.getValue() < v) {
                tupels[count] = t;
                count += 1;
            }
        }
        Group g3 = new Group(count);
        for(int i=0; i<count; i++) {
            g3.insert(tupels[i]);
        }
        return g3;
    }
    public static int maxValue(Group source) {
        Group g = source.copy();
        if(g.size() == 0) {
            return 0;
        }
        Integer max = null;
        for(int i=0; i<g.size(); i++) {
            Tupel t = g.delete(i);
            if(t != null) {
                if(max == null || t.getValue() > max) {
                    max = t.getValue();
                }
            }
        }
        return max == null ? 0 : (int)max;
    }
}

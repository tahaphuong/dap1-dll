package dll;

import java.util.Arrays;

public class Testumgebung {
    public static void main(String[] args) {
        Auf10<Integer> dll = new Auf10<Integer>();
        dll.add(-5); dll.add(12); dll.add(11);
        dll.add(7); dll.add(-5); dll.add(null);

        Auf31<Integer> dll2 = new Auf31<Integer>();
        dll2.add(-5); dll2.add(11); dll2.add(1);
        dll2.add(7); dll2.add(1); dll2.add(null);







        // dll.exchange() // A1
        // System.out.println(dll.splitBehind(-10));
        // System.out.println(Arrays.toString(dll.positions()));
        // dll.exchange();
        // dll.inject(dll2, 6); // A5

        // System.out.println(dll.allEqual(dll2));
        // dll.moveToHead(2);
        // System.out.println(dll.strip());
        // System.out.println(dll.allIn(new Integer[]{2, 2, 2}));
        // dll.exchangeHalfs();

        // dll.delete(1,12); // A11
        // System.out.println(dll.noOneIn(new Integer[]{16, 2, 3}));
        // dll.prepend(new Integer[] {null, 0, 1});
        // dll.sub(5).showAll();
        // System.out.println(dll.unequals(dll2)); // A15

        // dll.pack();
        // Auf17<Integer> dll3 = new Auf17<Integer>(new Auf17[] {dll, dll2});
        //
        // dll.deleteHead(5);
        // System.out.println(dll.isDiff(dll2));

        // dll.reverse(); // A21
        // dll.deleteNext(5);
        // dll.singleton(0).showAll();
        // dll.deleteTo(12);
        // dll.sel(dll2).showAll(); // A25

        // dll.deleteFrom(11);
        // System.out.println(dll.equalHead(dll2));
        // System.out.println(dll.asymmetric());
        // dll.deleteInner();
        // dll.lastTwo().showAll();

        // System.out.println(dll.equalContent(dll2)); // A31
        // dll.substitute(12, 11); // inputs are not null
        // dll.removeMiddle();
        // dll.removeUnequalToFirst();

        dll.showAll();
    }
}

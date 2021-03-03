package bst;

public class Testumgebung {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] arr = new int[]{34,17,48,91,62,5,9,11,85,28,1};
        for (int x : arr) {
            tree.add(x);
        }
        System.out.println(tree.countNodes(1,3));
    }
}

package bst;

// Zusatzaufgaben BST 2020
public class BinarySearchTree<T extends Comparable<T>> {
    private T content;
    private BinarySearchTree<T> leftChild, rightChild;

    // Auf 1
    public int countNodes(int top, int bottom) {
        if (top <= bottom && !isEmpty()) {
            // falls top < 0 => sich erhoeht bis 0
            if (top < 0) {
                return countNodes(top + 1, bottom);
            }
            // sonst wird 1 (dieser Knoten) + die Anzahl der Knoten der Teilbäume zurueckgegeben
            if (bottom >= 0 && top <= 0) {
                return 1 + leftChild.countNodes(top - 1, bottom-1)
                        + rightChild.countNodes(top - 1, bottom-1);
            }
            return leftChild.countNodes(top - 1, bottom-1)
                    + rightChild.countNodes(top - 1, bottom-1);
        } else {
            return 0;
        }
    }

    // Auf2
    static int count = 0;

    public int sortedUpTo(int n) {

        if (n > 0 && !isEmpty()) {
            if (isLeaf()) {
                System.out.println(content);
                return n - 1;
            }
            else {
                int n_rest = n;
                if (!leftChild.isEmpty()) {
                    n_rest = leftChild.sortedUpTo(n_rest);
                }
                if (n_rest > 0) {
                    System.out.println("" + getContent());
                    n_rest--;
                }
                if (!rightChild.isEmpty()) {
                    n_rest = rightChild.sortedUpTo(n_rest);
                }
                return n_rest;
            }
            /* leftChild.sortedUpTo(n);

            if (count >= n)
                return 0;

            System.out.println(content);
            count++;

            if (count >= n)
                return 0;
            return rightChild.sortedUpTo(n); */
        } else {
            return 0;
        }
    }

    // Auf3
    public T largestOn(int level) {
        if (!isEmpty() && level >= 0) {
            if (level == 0) {
                return content;
            }
            return rightChild.largestOn(level-1);
            /* if (level == 0) {
                return content;
            }
            T left = leftChild.largestOn(level-1);
            T right = rightChild.largestOn(level-1);
            if(left == null) {
                return right == null ? null : right;
            }
            if(right == null) {
                return left == null ? null : left;
            }
            return left.compareTo(right) > 0 ? left : right;*/
        } else {
            return null;
        }
    }

    // Auf4
    public int isNiceTree() {
        if(isEmpty()) {
            return 0;
        } else {
            if (isLeaf()) {
                return 1;
            }
            int left = leftChild.isNiceTree();
            int right = rightChild.isNiceTree();
            if(left >= 0 && right >= 0 && Math.abs(left-right) <= 1) {
                return left + right;
            }
            return -1;
        }
    }

    // Auf 5
    public int countNodes(int level) {
        if (!isEmpty()) {
            int valueLevel = (level % 2 != 0) ? 1 : 0;
            if(isLeaf()) {
                return valueLevel;
            }
            return valueLevel + leftChild.countNodes(level+1)
                    + rightChild.countNodes(level+1);
        } else {
            return 0;
        }
    }
    // Auf 6
    public boolean smallerExists(T obj) {
        if(!isEmpty()) {
            if(isLeaf()) {
                // if the leaf on the outer left < obj => true
                return content.compareTo(obj) < 0;
            }
            return leftChild.smallerExists(obj);
        }
        return false;
    }

    // Auf7
    public BinarySearchTree<T> subTree(T c) {
        if(!isEmpty()) {
            if(content.equals(c)) {
                leftChild = new BinarySearchTree<>();
                rightChild = new BinarySearchTree<>();
                return this;
            }
            BinarySearchTree<T> left = leftChild.subTree(c);
            BinarySearchTree<T> right = rightChild.subTree(c);
            if(left == null) {
                return right;
            }
            return left;
        } else {
            return null;
        }
    }

    // Auf 8
    public boolean isDirectParent(T parent, T child) { // angenommen parent & child nicht null sind.
        if(!isEmpty()) {
            if(parent.equals(content)) {
                if(child.equals(leftChild.content) || child.equals(rightChild.content)) {
                    return true;
                }
            }
            return leftChild.isDirectParent(parent, child)
                    || rightChild.isDirectParent(parent, child);
        } else {
            return false;
        }
    }

    // Auf 9
    public int shortest() {
        if(!isEmpty()) {
            if (!leftChild.isEmpty() == rightChild.isEmpty()) {
                return 1;
            }
            int left = leftChild.shortest();
            int right = rightChild.shortest();
            if(left != 0 && right != 0) {
                if (left < right) {
                    return left + 1;
                }
                return right + 1;
            }
            return left + right + 1;
        } else {
            return 0;
        }
    }

    // Auf 10
    public boolean succeeds(T pred, T succ) { // args ungleich null
        if(!isEmpty()) {
            if(pred != null && pred.equals(content)) {
                return leftChild.succeeds(null, succ) || rightChild.succeeds(null, succ);
            }
            if(pred == null && succ != null && succ.equals(content)) {
                return true;
            }
            return leftChild.succeeds(pred, succ) || rightChild.succeeds(pred, succ);
        } else {
            return false;
        }
    }


    // Auf 11
    public boolean completePath() {
        if(isEmpty() || isLeaf()) { // (1)
            return false;
        }
        if(leftChild.isEmpty() || rightChild.isEmpty()) { // (2)
            return false;
        }
        if(leftChild.isLeaf() || rightChild.isLeaf()) { // (3)
            return true;
        }
        return leftChild.completePath() || rightChild.completePath(); // (4)
    }
    /*
    * Beschreibung:
    * (1) Abbruchbedingung: Ist Baum leer oder nur ein Blatt: return false
    * (2) Wenn mindesten einer der zweien Teilbäume leer ist -> auch return false
    * Da dieser Knoten die Bedingung nicht erfüllt.
    * Anderenfalls (keiner der Teilbäume ein leerer Baum ist)
    * (3) wenn mindesten einer der zweien Teilbäume ein Blatt ist -> return true,
    * Da dieser Baum hat keinen direkten leeren Teilbaum und auf dem Pfad zum Blatt liegt.
    * (4) Wenn noch keinen Blatt gefunden -> die Teilbäume untersuchen.
    * Da nur einen gültigen Pfad benötigt -> return ODER-Verknüpfung
    * */

    // Auf 12

    public T maxOfLess(T obj) {
        if (isEmpty() || obj == null) {
            return null;
        }

        T left = leftChild.maxOfLess(obj);
        T right = rightChild.maxOfLess(obj);
        if (getContent().compareTo(obj) >= 0) {

            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (left.compareTo(right) > 0) {
                return left;
            }
            return right;
        } else {
            if (left == null && right == null) {
                return getContent();
            }
            if (left == null) {
                return getContent().compareTo(right) > 0 ? getContent() : right;
            }
            if (right == null) {
                return getContent().compareTo(left) > 0 ? getContent() : left;
            }
            if (left.compareTo(right) > 0) {
                return getContent().compareTo(left) > 0 ? getContent() : left;
            }
            return getContent().compareTo(right) > 0 ? getContent() : right;
        }
    }
    /*
    * Beschribung:
    * Abbruchbedingung: Baum ist leer oder obj ist null -> return null
    *
    * - Wenn der ausführende Baum hat Inhalt größer als oder gleich obj:
    * -> untersuchen die Teilbäume und der größere Inhalt wird zurueckgegegben.
    * In dem Fall einer der untersuchten Ergebnisse null -> return die andere.
    *
    * - Wenn der ausführende Baum hat Inhalt kleiner als obj:
    * -> untersuchen die Teilbäume, vergleichen die mit in dem Punkt ausführenden Baum.
    * -> der größte und nicht-null Inhalt wird zurückgegeben.
    *
    * */

    // Auf 13
    public BinarySearchTree(T p1, T p2) {
        this.content = p1;
        this.rightChild = new BinarySearchTree<>();
        this.leftChild = new BinarySearchTree<>();
        if (p1 != null && p1.compareTo(p2) > 0) {
            this.leftChild.content = p2;
            this.leftChild.leftChild = new BinarySearchTree<>();
            this.leftChild.rightChild = new BinarySearchTree<>();
        } else if (p1 != null && p1.compareTo(p2) < 0) {
            this.rightChild.content = p2;
            this.rightChild.leftChild = new BinarySearchTree<>();
            this.rightChild.rightChild = new BinarySearchTree<>();
        }
    }
    /*
     * Beschreibung:
     * - Erstmal verweist p1 auf content des ausfuehrenden Baum.
     * 2 Teilbäume werden erzeugt.
     * 3 Fälle:
     * - Falls p1 größer als p2 ist: der Inhalt des linken Teilbaums ist p2.
     * 2 Teilbäume dieses Teilbaums werden erzeugt.
     * - Falls p1 kleiner als p2 ist: der Inhalt des rechten Teilbaums ist p2.
     * 2 Teilbäume dieses Teilbaums werden erzeugt.
     * Anderenfalls (p1 gleich p2): nichts wird weitergemacht.
     * */

    // Auf 14
    public int levelOfMax() {
        if (isEmpty()) {
            return -1;
        }
        if(leftChild.isEmpty() && !rightChild.isEmpty()) {
            return getContent().compareTo(rightChild.getContent()) > 0
                    ? rightChild.levelOfMax() - 1 : rightChild.levelOfMax();
        }
        if(rightChild.isEmpty() && !leftChild.isEmpty()) {
            return getContent().compareTo(leftChild.getContent()) > 0
                    ? leftChild.levelOfMax() - 1 : leftChild.levelOfMax();
        }
        return 0;
    }

    // Auf 22
    public int completeLevels() {
        // Abbruchbedingungen
        if (isEmpty()) return 0;
        if (leftChild.isEmpty() || rightChild.isEmpty()) return 1;

        // Schritte:
        int left = leftChild.completeLevels();
        int right = rightChild.completeLevels();

        if (left == right) {
            return left + 1;
        }
        return 2;

        // Anzahl der Teilbaumen von leftTree gleich wie die von rightTree
        // -> vollstaendig -> 1 auf result addiert -> return left/right + 1.
        //if (left == right && left != 0) {
        //    return left + 1;
        //}

        // sonst
        // if(left > right) {
        //    return right;
        // }
        //return left;
    }
    public BinarySearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }
    public T getContent() {
        return content;
    }
    public boolean isEmpty() {
        return content == null;
    }
    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }
    public void add( T t )
    {
        if ( isEmpty() )
        {
            content = t;
            leftChild = new BinarySearchTree<T>();
            rightChild = new BinarySearchTree<T>();
        }
        else
        {
            if ( content.compareTo( t ) > 0 )
            {
                leftChild.add( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                rightChild.add( t );
            }
        }
    }

    public void show()
    {
        if ( !isEmpty() )
        {
            leftChild.show();
            System.out.println( content );
            rightChild.show();
        }
    }
}

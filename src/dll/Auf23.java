package dll;

public class Auf23<T> {
    public Auf23<T> singleton( int n ) {
        if (n < 0 || n >= size) {
            int count = 0;
            Element current = first;
            while (count < n) {
                current = current.succ;
                count += 1;
            }
            Element el = new Element(current.content);
            Auf23<T> dll = new Auf23<>();
            dll.first = dll.last = el;
            dll.size = 1;
            return dll;
        }
        else {
            throw new RuntimeException();
        }
    }

    private Element first, last;
    private int size;

    public Auf23()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( T content )
    {
        Element e = new Element( content );
        if ( isEmpty() )
        {
            first = last = e;
        }
        else
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    // Element

    private static class Element<T>
    {
        private T content;
        private Element pred, succ;

        Element( T c )
        {
            content = c;
            pred = succ = null;
        }

        T getContent()
        {
            return content;
        }

        void setContent( T c )
        {
            content = c;
        }

        boolean hasSucc()
        {
            return succ != null;
        }

        Element getSucc()
        {
            return succ;
        }

        void disconnectSucc()
        {
            if ( hasSucc() )
            {
                succ.pred = null;
                succ = null;
            }
        }

        void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null )
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        boolean hasPred()
        {
            return pred != null;
        }

        Element getPred()
        {
            return pred;
        }

        void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }

    }
}

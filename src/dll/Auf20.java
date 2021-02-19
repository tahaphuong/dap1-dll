package dll;

public class Auf20<T> {
    public boolean isDiff( Auf20<T> list ) {
        if (list != null) {
            Element c1 = first;
            while (c1 != null) {
                Element c2 = list.first;
                while (c2 != null) {
                    if(c1.content == null && c2.content == null
                            || c1.content != null && c1.content.equals(c2.content)) {
                        return false;
                    }
                    c2 = c2.succ;
                }
                c1 = c1.succ;
            }
        }
        return true;
    }

    private Element first, last;
    private int size;

    public Auf20()
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
            System.out.print( current.getContent() == null ? null : current.getContent().toString() );
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

package dll;

public class Auf11<T>
{
    public void delete(T p1, T p2) { // nicht null
        Element current = first;
        Element ref1 = null;
        Element ref2 = null;
        int count = 1;
        int count1 = -1;
        int count2 = -1;
        while (current != null) {
            if(ref1 == null && p1.equals(current.content)) {
                ref1 = current;
                count1 = count;
            }
            if(p2.equals(current.content)) {
                ref2 = current;
                count2 = count;
            }
            current = current.succ;
            count++;
        }
        if(ref1 == null || ref2 == null) {
            return;
        }
        if(count1 < count2) {
            ref1.connectAsSucc(ref2);
        }
        if(count1 > count2) {
            ref2.connectAsSucc(ref1);
        }
        size -= Math.abs(count2 - count1 - 1);

    }
    private Element first, last;
    private int size;

    public Auf11()
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

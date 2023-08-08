import java.util.Iterator;

public interface RangeSearchTreeInterface<T extends Comparable<T>> extends SortedCollectionInterface<T> {
    public Iterator<T> iterator();
 //   public RangeSearchTreeInterface();
    public void removeOne(T data);
    public void insertOne(T data);
    public int getNumberOfNodes();
}


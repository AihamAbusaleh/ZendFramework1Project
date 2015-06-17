package erweiterungblatt5;


public interface Set<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    void add(T x);  // Falls x nicht in der Menge ist 
    void remove(T x);
    boolean contains(T x);
    T get(int index);
    boolean containsAll(Set<T> s);
    void addAll(Set<T> s);
    void removeAll(Set<T> s);
	void clear();
}
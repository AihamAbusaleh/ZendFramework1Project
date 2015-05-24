package aufgabe2;

public interface Set {
    int size();
    boolean isEmpty();
    void add(int x);
    void remove(int x);
    boolean contains(int x);
    int get(int i);
    boolean containsAll(Set s);
    void addAll(Set s);
    void removeAll(Set s);
	void clear();
}

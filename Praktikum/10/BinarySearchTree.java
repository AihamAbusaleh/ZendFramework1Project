// O. Bittel
// 17.5.2011

package aufgabenblatt9;

public class BinarySearchTree {

    static private class Node {
        private int data;
        private Node left;
        private Node right;
        private Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    private Node root = null;
    private int size = 0;


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("BinarySearchTree: ");
        appendR(s,root);
        s.append(" size = ").append(size);
        return s.toString();
    }

    private static void appendR(StringBuilder s, Node p) {
        if (p != null) {
            appendR(s,p.left);
            s.append(p.data).append(", ");
            appendR(s,p.right);
        }
    }

    public boolean contains(int x) {
        return containsR(x,root);
    }

    private boolean containsR(int x, Node p) {
	if (p == null)
            return false;
	else if (x < p.data)
            return containsR(x,p.left);
	else if (x > p.data)
            return containsR(x,p.right);
	else
            return true;
    }

    public void insert(int x) {
        root = insertR(x,root);
    }

    private Node insertR(int x, Node p) {
	if (p == null) {
            size++;
            return new Node(x);
        }
	if (x < p.data)
            p.left = insertR(x,p.left);
	else if (x > p.data)
            p.right = insertR(x,p.right);
	// im else-Fall ist nicht zu tun; keine doppelten Werte
	return p;
    }

    public void remove(int x) {
        root = removeR(x,root);
    }

    private Node removeR(int x, Node p) {
        if (p == null)
            return null;
	if (x < p.data)
            p.left = removeR(x,p.left);
	else if (x > p.data)
            p.right = removeR(x,p.right);
        else {
            // Knoten loeschen:
            if (p.left == null || p.right == null) {
                // One or no child can be deleted directly:
                size--;
                p = (p.left != null) ? p.left : p.right;
            }
            else {
                // Two children
                p.data = getMin(p.right);
                p.right = removeR(p.data,p.right);
            }
        }
	return p;
    }

    private int getMin(Node p) {
        assert (p != null);
        while(p.left != null)
            p = p.left;
        return p.data;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public static void main(String[] args) {

        BinarySearchTree t = new BinarySearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(3);
        t.insert(8);
        t.insert(7);
        t.insert(15);
        t.insert(20);
        t.insert(17);
        System.out.println(t);
    }
}

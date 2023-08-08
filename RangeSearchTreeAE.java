import java.util.Iterator;
import java.util.Stack;

/**
 * Class that extends implementation of RedBlackTree.java
 *
 * @param <T> Comparable<T>
 */
public class RangeSearchTreeAE<T extends Comparable<T>> extends RedBlackTree<T>
    implements RangeSearchTreeInterface<T> {

    public void RangeSearchTreeInterface() {
        new RangeSearchTreeAE<>();
    }

    /**
     * Iterates through the red black tree
     *
     * @return next Node
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Stack<Node<T>> stack = null;
            Node<T> current = root;
            public boolean hasNext() {
                if (stack == null) {
                    return current != null;
                }
                else {
                    return (current != null || !stack.isEmpty());
                }
            }
            public T next() {
                if (stack == null) {
                    stack = new Stack<>();
                }
                while (!stack.isEmpty() || current != null) {
                    if (current == null) {
                        Node<T> poppedNode = stack.pop();
                        current = poppedNode.context[2];
                        return poppedNode.data;
                    }
                    else {
                        stack.add(current);
                        current = current.context[1];
                    }
                }
                return null;
            }
        };
    }

    /**
     * This class removes a node from the Red Black Tree
     *
     * @param data node to be removed
     */
    public void removeOne(T data) {
        if (contains(data)) {
            remove(data);
        }
    }

    /**
     * This class inserts a node from the Red Black Tree
     *
     * @param data a reference to a newly added red node
     */
    public void insertOne(T data) {
            insert(data);
    }

    /**
     * This class returns the number of nodes from the Red Black Tree
     *
     * @return number of nodes
     */
    public int getNumberOfNodes() {
        return size();
    }

    /**
     * The job of this enforceRBTreePropertiesAfterRemove method is to resolve any red-black tree
     * property violations that are introduced by removing each old node from a red-black tree
     *
     * @param data a reference to a newly added red node
     */
    protected void enforceRBTreePropertiesAfterRemove(Node<T> data) {
        Node<T> parent = data.context[0];

        if (data == root) {
            data.blackHeight = 1;
            return;
        }

        Node<T> sibling = null;
        if (data == parent.context[1]) {
            sibling = parent.context[2];
        } else if (data == parent.context[2]) {
            sibling = parent.context[1];
        }

        if (sibling.blackHeight == 0) {
            sibling.blackHeight = 1;
            data.context[0].blackHeight = 1;
            if (data == data.context[0].context[1]) {
                rotate(data, data.context[0]);
            }
            else {
                rotate(data, data.context[0]);
            }
        }
        if ((sibling.context[1].blackHeight == 1) && (sibling.context[2].blackHeight == 1)) {
            sibling.blackHeight = 0;
            if (data.context[0].blackHeight == 0) {
                data.context[0].blackHeight = 1;
            }
            else {
                enforceRBTreePropertiesAfterRemove(data.context[0]);
            }
        }
        else {
            if (!data.isRightChild() && sibling.context[2].blackHeight == 1) {
                sibling.context[1].blackHeight = 1;
                sibling.blackHeight = 0;
                rotate(sibling, sibling.context[0]);
                sibling = data.context[0].context[2];
            }
            else if (data.isRightChild() && sibling.context[1].blackHeight == 1) {
                sibling.context[2].blackHeight = 1;
                sibling.blackHeight = 0;
                rotate(sibling, sibling.context[0]);
                sibling = data.context[0].context[1];
            }
            sibling.blackHeight = data.context[0].blackHeight;
            data.context[0].blackHeight = 1;
            if (!data.isRightChild()) {
                sibling.context[2].blackHeight = 1;
                rotate(data, data.context[0]);
            }
            else {
                sibling.context[1].blackHeight = 1;
                rotate(data, data.context[0]);
            }
        }
    }

    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a left child of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * right child of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
        if (child == null || parent == null) {
            throw new IllegalArgumentException();
        }
        if (!child.isRightChild()) {
            parent.context[1] = child.context[2];
            if (child.context[2] != null) {
                child.context[2].context[0] = parent;
            }
            child.context[0] = parent.context[0];
            if (parent.context[0] == null) {
                this.root = child;
            }
            else if (parent == parent.context[0].context[2]) {
                parent.context[0].context[2] = child;
            }
            else {
                parent.context[0].context[1] = child;
            }
            child.context[2] = parent;
            parent.context[0] = child;
        }
        else if (child.isRightChild()) {
            parent.context[2] = child.context[1];
            if (child.context[1] != null) {
                child.context[1].context[0] = parent;
            }
            child.context[0] = parent.context[0];
            if (parent.context[0] == null) {
                this.root = child;
            }
            else if (parent == parent.context[0].context[1]) {
                parent.context[0].context[1] = child;
            }
            else {
                parent.context[0].context[2] = child;
            }
            child.context[1] = parent;
            parent.context[0] = child;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

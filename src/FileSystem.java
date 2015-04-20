/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * FileSystem is a binary search tree object
 * Based largely on BinarySearchTree.java by thaoc
 * NOTE: @.CLI = Command Line Interface equivalent
 */
@SuppressWarnings("unchecked") // Stop IntelliJ from providing unchecked warnings
public class FileSystem<E extends Comparable> extends BinaryTree<E> {

    private boolean addReturn;
    private E deletedItem;

    /**
     * Add the specified item
     * @.CLI mkdir
     * @param item The item to add
     * @return true if added, otherwise false
     */
    boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Add the specified item
     * @param n The current node
     * @param item The item to add
     * @return The node
        Recursively searching for a match
        -if a match is found, return false;
        -if no match is found, create a node with the item and return it.
        -if item is less than current node's data,
        assign the result of the add method to the left child.
        -otherwise, assign the result to the right child.
     */
    private Node<E> add(Node<E> n, E item) {
        if (n == null) {
            addReturn = true;
            return new Node<E>(item);
        } else if (item.compareTo(n.data) == 0) {
            addReturn = false;
            return n;
        } else if (item.compareTo(n.data) < 0) {
            n.leftChild = add(n.leftChild, item);
            return n;
        } else {
            n.rightChild = add(n.rightChild, item);
            return n;
        }
    }

    /**
     * Find the specified target
     * @param target The object to find
     * @return The target
     */
    public E find(E target) {
        return find(target, root);
    }

    /**
     * Locate the specified target
     * @param target The object to find
     * @param node The current node
     * @return The target
        node is null, not found.
        target == node.data, found it.
        target < node.data, search left
        target > node.data, search right
     */
    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        int result = target.compareTo(node.data);
        if (result == 0) {
            return node.data;
        }
        if (result < 0) {
            return find(target, node.leftChild);
        }
        return find(target, node.rightChild);
    }
    public E delete(E target) {
        delete(root, target);
        return deletedItem;
    }

    /**
     * Delete the specified item
     * @.CLI rm
     * @param n The current node within which to search for a matching item
     * @param item The specified item for which to search and delete if found
     * @return The node
     *  1. item < node.data, search left.
        2. item > node.data, search right.
        3. item is not found, do nothing.
        4. item = node.data, delete it.
        if node has a single child, attach the child to node's parent
        if node has two children,
        replace node with the largest node in its left sub tree
     */
    private Node<E> delete(Node<E> n, E item) {
        if (n == null) {
            deletedItem = null;
            return null;
        }
        int compResult = item.compareTo(n.data);
        if (compResult < 0) {
            n.leftChild = delete(n.leftChild, item);
            return n;
        } else if (compResult > 0) {
            n.rightChild = delete(n.rightChild, item);
            return n;
        } else { //item is found, perform deletion
            deletedItem = n.data;
            //has a single child, replace parent with child
            if (n.leftChild == null) {
                return n.rightChild;
            } else if (n.rightChild == null) {
                return n.leftChild;
                //has two children, replace the largest node on
                //left subtree.
            } else {
                n.data = findLargestChild(n.leftChild);
                return n;
            }
        }
    }

    /**
     * Fine the largest child of the specified parent node
     * @param parent The specified parent node
     * @return data of the largest child of the specified parent node
     */
    private E findLargestChild(Node<E> parent) {
        if (parent.rightChild.rightChild == null) {
            E value = parent.rightChild.data;
            parent.rightChild = parent.rightChild.leftChild;
            return value;
        } else {
            return findLargestChild(parent.rightChild);
        }
    }

    /**
     * Change current node
     * Will be in Main class
     * @.CLI cd
     */

    /**
     * Get current node
     * Will be in Main class
     * @.CLI pwd
     */
}
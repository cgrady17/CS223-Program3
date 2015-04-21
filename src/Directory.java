import java.util.ArrayList;
import java.util.List;

/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * Directory represents a filesystem directory object
 * Essentially, this is a Node in a Tree
 */
public class Directory<E> {

    private Directory<E> parent;

    private List<Directory<E>> children;

    private String name;

    public Directory(String name) {
        this.children = new ArrayList<Directory<E>>();
        this.parent = null;
        this.name = name;
    }

    public Directory(String name, Directory parent) {
        this.children = new ArrayList<Directory<E>>();
        this.parent = parent;
        this.name = name;
    }

    /**
     * remove node from tree
     */
    public void remove() {
        if (parent != null) {
            parent.removeChild(this);
        }
    }

    /**
     * remove child node
     * @param child
     */
    private void removeChild(Directory child) {
        if (children.contains(child)) {
            children.remove(child);
        }
    }
}

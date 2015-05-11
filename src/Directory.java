import java.util.*;

/**
 * UWW CS223 - Program 3/4
 * Created by Connor Grady (GradyCP17)
 * Directory represents a filesystem directory object
 * Essentially, this is a Node in a Tree
 */
public class Directory<E> {

    // List data store for directory's child files
    List<File<E>> childFiles;

    // Directory object for this Directory's parent directory
    private Directory<E> parent;

    // List data store for this directory's child directories
    private List<Directory<E>> children;

    // This directory's name
    private String name;

    /**
     * Constructor that takes single parameter
     * @param name Name of the new Directory object
     */
    public Directory(String name) {
        // Create children ArrayList
        this.children = new ArrayList<Directory<E>>();
        // Create childFiles ArrayList
        this.childFiles = new ArrayList<File<E>>();
        // Set parent to be null
        this.parent = null;
        // Set the name to the parameter name
        this.name = name;
    }

    /**
     * Constructor that sets both name and parent
     * @param name Name of the new Directory object
     * @param parent Parent directory of the new Directory object
     */
    public Directory(String name, Directory<E> parent) {
        // Create children ArrayList
        this.children = new ArrayList<Directory<E>>();
        // Create childFiles ArrayList
        this.childFiles = new ArrayList<File<E>>();
        // Set parent to the parameter parent
        this.parent = parent;
        // Set the name to the parameter name
        this.name = name;
    }

    /**
     * Constructor that sets both name and parent, and specifies an initial set of child directories
     * @param name Name of the new Directory object
     * @param parent Parent directory of the new Directory object
     * @param initialChildren Array of initial child Directories
     */
    public Directory(String name, Directory<E> parent, Directory<E>... initialChildren) {
        // Create children ArrayList
        this.children = new ArrayList<Directory<E>>();
        // Add initial child directory to children
        Collections.addAll(children, initialChildren);
        // Create childFiles ArrayList
        this.childFiles = new ArrayList<File<E>>();
        // Set parent to the parameter parent
        this.parent = parent;
        // Set the name to the parameter name
        this.name = name;
    }

    /**
     * Retrieve the name of the Directory
     * @return Name of Directory as String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of this Directory
     * @param name String to set as name
     * @return The newly set name
     */
    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    /**
     * Boolean if Directory has any children
     * @return True if getChildren() not null, otherwise false
     */
    public boolean hasChildren() {
        return getChildren() != null;
    }

    /**
     * Get the first child directory of this Directory
     * @return The first child, or null if no children
     */
    public Directory<E> firstDir() {
        if (hasChildren()) {
            return this.children.get(0);
        } else {
            return null;
        }
    }

    /**
     * Get the last child of this Directory
     * @return The last child, or null if no children
     */
    public Directory<E> lastDir() {
        if (hasChildren()) {
            return this.children.get(this.children.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Gets all children
     * @return List of all children
     */
    public List<File<E>> getChildren() {
        return this.childFiles;
    }

    /**
     * Returns the number of children of this node
     * @return The number of children
     */
    public int numOfChildren() {
        return this.children.size();
    }

    public Directory<E> getChild(String name) {
        for (Directory<E> thisDir : children) {
            if (thisDir.getName().equals(name)) {
                return thisDir;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Returns the child at the specified index
     * @param index The index of the desired child
     * @return The child of this Directory at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
    public Directory<E> getChild(int index) throws NoSuchElementException {
        if (index < 0 || index >= this.children.size()) {
            throw new NoSuchElementException("Index out of bounds at " + index + ".");
        } else {
            return this.children.get(index);
        }
    }

    /**
     * Returns an iterator for the child directories of this Directory
     * @return An iterator for this directory's children
     */
    public Iterator<Directory<E>> children() {
        return this.children.iterator();
    }

    /**
     * Gets the parent Directory
     * @return Parent directory
     */
    public Directory<E> getParent() {
        return this.parent;
    }

    /**
     * Changes the directory's parent
     * @param newParent The new parent directory
     * Will be used for moving a directory (and its contents)
     */
    public void setParent(Directory<E> newParent) {
        this.parent = newParent;
    }

    /**
     * Adds the specified directory as a child of this directory
     * @param newDir The new directory to add as a child
     * @return The newly added directory if added, otherwise null
     */
    public Directory<E> addDirectory(Directory<E> newDir) {
        if (exists(this, newDir)) {
            System.out.println("Error: Directory already exists.");
            return null;
        } else {
            children.add(newDir);
            return newDir;
        }
    }

    /**
     * Adds the specified directory as a child of this directory at the specified index
     * @param newDir The new directory to add as a child
     * @param index The index at which to add the new Directory
     * @return The newly added directory if added, otherwise null
     */
    public Directory<E> addDirectory(Directory<E> newDir, int index) throws IllegalArgumentException {
        if ( index < 0 || index > this.children.size()) {
            throw new IllegalArgumentException();
        } else {
            children.add(index, newDir);
            return newDir;
        }
    }

    /**
     * Adds the specified file as a child of this directory
     * @param newFile The new file to add as a child
     * @return The newly added file if added, otherwise null
     */
    public File<E> addFile(File<E> newFile) {
        boolean exists = false;
        if (childFiles.contains(newFile)) {
            exists = true;
        }

        if (!exists) {
            childFiles.add(newFile);
            return newFile;
        } else {
            System.out.println("Error: File already exists.");
            return null;
        }
    }

    /**
     * Returns a string representation of this directory's path
     * @return This directory path as String
     * @TODO Implementation
     */
    public String getPath() {
        return null;
    }

    /**
     * Removes this directory from the tree
     */
    public void delete() {
        if (parent != null) {
            parent.removeChild(this);
        }
    }

    /**
     * Removes the specified child directory
     * @param child Child directory to remove
     */
    private void removeChild(Directory<E> child) {
        if (children.contains(child)) {
            children.remove(child);
        } else {
            System.out.println("Error: Specified directory not found.");
        }
    }

    /**
     * Removes the specified child file
     * @param file Child file to remove
     */
    public void removeFile(File<E> file) {
        if (childFiles.contains(file)) {
            childFiles.remove(file);
        } else {
            System.out.println("Error: Specified file not found.");
        }
    }

    /**
     * Returns a String representation of this Directory.
     * @return A string representation of this Node
     */
    @Override
    public String toString() {
        return toString(this, "");
    }

    /**
     * Generates the string representation of this Directory tree
     * @param dir Starting directory
     * @param separator The desired separating character
     * @return The generated string representation of this Directory
     */
    public String toString(Directory<E> dir, String separator) {
        String result = separator + dir.name + "\n";
        Iterator<Directory<E>> directoryIterator = dir.children.iterator();
        while (directoryIterator.hasNext()) {
            result += toString(directoryIterator.next(), separator + " ");
        }
        return result;
    }

    /**
     * Recursive method to find whether the specified Directory exists in the specified Directory
     * @param dirToFind Directory to search for
     * @param dirToSearch Directory to search in
     * @return true if the Directory is found, otherwise false
     */
    private boolean exists (Directory<E> dirToFind, Directory<E> dirToSearch) {
        if (dirToFind == dirToSearch) {
            return true;
        }
        Iterator<Directory<E>> directoryIterator = parent.children();
        while (directoryIterator.hasNext()) {
            if (exists(dirToFind, directoryIterator.next())) {
                return true;
            }
        }
        return false;
    }
}

/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * File represents a filesystem file object
 */
abstract class File<E> {
    // This file's name
    private String name;
    // This files parent directory
    private Directory parent;

    /**
     * Primary constructor that sets File's name
     * @param name The name of the new File
     */
    public File(String name) {
        // Set the name to specified name
        this.name = name;
        this.parent = null;
    }

    /**
     * Constructor that sets File's name and parent
     * @param name The name of the new File
     * @param parent The parent directory of the new File
     */
    public File(String name, Directory<E> parent) {
        this.name = name;
        this.parent = parent;
    }

    /**
     * Gets the name of this File
     * @return Name of this File as String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the parent directory of the File
     * @return Parent directory of this File
     */
    public Directory<E> getParent(){
        return parent;
    }

    /**
     * Sets the parent directory of this File (essentially moving it)
     * @param parent The new parent directory of this File
     */
    public void setParent(Directory<E> parent) {
        this.parent = parent;
    }

    /**
     * Returns a string representation of this File's path
     * @return This directory path as String
     * @TODO Implementation
     */
    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.toString();
    }
}

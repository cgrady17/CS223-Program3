/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * File represents a filesystem file object
 */
abstract class File {
    private String name;
    private Directory parent;

    public File(String name) {
        this.name = name;
    }

    Directory getParent(){
        return parent;
    }
}

import java.util.ArrayList;

/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * Directory represents a filesystem directory object
 */
public class Directory extends File {
    private ArrayList<File> children;

    Directory(String name) {
        super(name);
    }

    void addChild(File f) {
        children.add(f);
    }

    ArrayList<File> getChildren() {
        return children;
    }
}

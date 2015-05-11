import java.util.ArrayList;
import java.util.List;

/**
 * UWW CS223 - Program 3/4
 * Created by Connor Grady (GradyCP17)
 * Simulates a UNIX FileSystem (essentially a General Tree)
 */
public class FileSystem {
    // Root directory of FileSystem
    Directory<String> root;
    // Working directory
    Directory<String> workingDir;
    List<String> files;

    /**
     * Primary parameter-less constructor
     */
    public FileSystem() {
        // Initialize root to new Directory = "/"
        this.root = new Directory<String>("/");
        // Initialize the files list
        this.files = new ArrayList<String>();
    }

    
}

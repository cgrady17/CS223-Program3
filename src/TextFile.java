/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * TextFile represents a filesystem text file object
 */
public class TextFile extends File {
    private String content;

    TextFile (String name, String content) {
        super(name);
    }
    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }
}

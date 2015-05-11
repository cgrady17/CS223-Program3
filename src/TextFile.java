/**
 * UWW CS223 - Program 3/4
 * Created by Connor Grady (GradyCP17)
 * TextFile represents a File object hat contains text
 */
public class TextFile<String> {
    private String name;
    private String content;

    public TextFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public TextFile(String name) {
        this.name = name;
        this.content = (String) "";
    }

    /**
     * Gets the name of this File
     * @return Name of this File as String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the content of the Text File
     * @return Content of this File
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Sets the content of the Text File
     * @param text The text to set as the file's content
     */
    public void setContent(String text) {
        this.content = text;
    }
}

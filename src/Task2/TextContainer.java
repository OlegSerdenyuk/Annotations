package Task2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(someString = "C:\\Users\\Snicks\\IdeaProjects\\Annotations\\src\\Task2\\file.txt")
public class TextContainer {
    private String someString;

    public TextContainer() {
    }

    public TextContainer(String someString) {
        this.someString = someString;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Saver
    public void save(String someString){
        try (PrintWriter pw = new PrintWriter(someString)) {
            pw.write(this.getSomeString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

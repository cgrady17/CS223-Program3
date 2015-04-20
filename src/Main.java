import java.util.Scanner;

/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * Main driver class
 * "mkdir" and "rm" commands relate to methods of FileSystem
 * "cd" and "pwd" are relative to this class
 */
public class Main {
    public static void Main(String[] args) {
        String input;

        // Create current working directory object starting at root
        Directory workingDir = new Directory("/");

        // Create our File System
        FileSystem fs = new FileSystem();

        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to Fake UNIX");
        System.out.print("$");

        input = s.nextLine();

        String[] inputParts = input.split(" ");

        String command = inputParts[0];
        String arg = null;
        String path = null;
        if (inputParts[1] != null) {
            arg = inputParts[1];
            if (arg.contains("-")) {
                if (inputParts[2] != null) {
                    // Path exists after argument
                    path = inputParts[2];
                }
            } else {
                // NOT an argument
                path = arg;
                arg = null;
            }
        }

        if (command.equals("mkdir")) {
            if (arg != null) {
                // Has argument
                if (arg.equalsIgnoreCase("-p")) {
                    // Create parents if they do not exist
                    if (path != null) {
                        // Evaluate the path
                        String[] directories = path.split("/");
                        for (int i = 0; i < directories.length; i++) {
                            if (fs.find(directories[i]) != null) {
                                fs.add(directories[i]);
                            }
                        }
                    } else {
                        System.out.println("Error: Please specify a path");
                    }
                } else {
                    // Invalid argument
                    System.out.println("Error: Invalid Argument");
                }
            } else {
                // No argument
                if (path != null) {
                    // Evaluate the path
                    String[] directories = path.split("/");

                } else {
                    System.out.println("Error: Please specify a path");
                }
            }
        } else if (command.equals("cd")) {

        } else if (command.equals("pwd")) {

        } else if (command.equals("rm")) {

        } else {
            System.out.println("Error: Invalid Command");
        }
    }
}

import java.util.Iterator;
import java.util.Scanner;

/**
 * UWW CS223 - Program 3
 * Created by Connor Grady (GradyCP17)
 * Main driver class
 * @commands mkdir, rm, mv, cd, pwd, ls, edit, cat, updatedb, locate, search
 */
public class Main {
    public static void Main(String[] args) {
        String input;

        // Create current working directory object starting at root
        Directory<String> workingDir = new Directory<String>("/");

        // Create our File System
        BinarySearchTree fs = new BinarySearchTree();

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
            if (arg.equals("-p")) {
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
            // mkdir [-p] path+ (-p to create missing parent directories)
            /**
             * Makes a directory (last in specified path)
             * @arg -p Create missing parent directories
             * @val path+ Path(s) that specify directory(ies) to create
             */
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
                        Directory<String> newDir = new Directory<String>(directories[directories.length - 1], workingDir);
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
                    Directory<String> newDir = new Directory<String>(directories[directories.length - 1], workingDir);
                } else {
                    System.out.println("Error: Please specify a path");
                }
            }
        } else if (command.equals("cd")) {
            // cd [dir]
            /**
             * Change the current working directory
             * @arg dir Directory to change to
             */
            String dir = (inputParts[1] != null) ? inputParts[1] : null;
            if (dir == null || dir.equals(".")) {
                // Do NOT change workingDir
                workingDir = workingDir;
            } else if (dir.equals("..")){
                // Move workingDir up one level
                if (workingDir.getParent() != null) {
                    workingDir = workingDir.getParent();
                } else {
                    System.out.println("Already at root.");
                }
            } else {
                workingDir = new Directory<String>(dir);
            }
        } else if (command.equals("pwd")) {
            // pwd
            /**
             * Prints the absolute path of the current working directory
             */
            System.out.println(workingDir.getPath());
        } else if (command.equals("rm")) {
            // rm [-r] path+ (-r Removes directory and its contents, otherwise just text files)
            /**
             * Removes the specifies item(s)
             * @arg -r Remove directory and its contents, otherwise only text files
             * @val path+ Item to remove
             */
            assert inputParts[1] != null;
            arg = (inputParts[1].equalsIgnoreCase("-r")) ? "-r" : null;
            if (arg != null) {
                path = (inputParts[2] != null) ? inputParts[2] : null;
            } else {
                path = (inputParts[1] != null) ? inputParts[2] : null;
            }

            if (path != null) {
                if (arg != null) {
                    // Delete directory and contents
                } else {
                    // Delete text files only
                }
            } else {
                System.out.println("Error: Please specify a path");
            }
        } else if (command.equals("mv")) {
            // mv src dest
            /**
             * Move item or rename item from src to dest
             * @val1 src Source item
             * @val2 dest Destination of source item
             */
            String src = (inputParts[1] != null) ? inputParts[1] : null;
            String dest = (inputParts[2] != null) ? inputParts[2] : null;
            if (src == null) {
                System.out.println("Error: Please specify a source item.");
            } else if (dest == null) {
                System.out.println("Error: Please specify a destination.");
            } else {
                // Both src and dest exist, perform function

            }
        } else if (command.equals("ls")) {
            // ls [-r] path* (-r is recursive)
            /**
             * List directory contents
             * @arg -r Perform recursive directory listing
             * @val path* Path/File to list contents of
             * If path* is not a directory, print the absolute file name of the file
             * Names are displayed in ascending sorted order
             */
            Directory<String> tempWorkingDir = null;
            arg = (inputParts[1] != null && inputParts[1].equalsIgnoreCase("-r")) ? "-r" : null;
            if (arg == null) {
                path = (inputParts[1] != null) ? inputParts[1] : ".";
            } else {
                path = (inputParts[2] != null) ? inputParts[1] : ".";
            }

            if (path.equals(".")) {
                tempWorkingDir = workingDir;
            } else {
                // Get specified directory/file
            }

            if (tempWorkingDir != null) {
                if (arg != null) {
                    // @TODO Make recursive
                    Iterator<Directory<String>> iter = tempWorkingDir.children();
                    while (iter.hasNext()) {
                        System.out.println(iter.next().getPath());
                    }
                } else {
                    Iterator<Directory<String>> iter = tempWorkingDir.children();
                    while (iter.hasNext()) {
                        System.out.println(iter.next().getPath());
                    }
                }
            }
        } else if (command.equals("edit")) {
            // edit file
            /**
             * Edits a test file if it exists, otherwise it creates it
             * @val file The absolute file path to edit/create
             */
        } else if (command.equals("cat")) {
            // cat file+
            /**
             * Prints the content of the specified file(s) to the screen
             * @val file+ One or more absolute files paths
             */
        } else if (command.equals("updatedb")) {
            // updatedb
            /**
             * Builds an index of all the file names in the file system using a binary search tree
             */
        } else if (command.equals("locate")) {
            // locate name
            /**
             * Find files by name using the binary search tree built by "updatedb"
             * @val name File name to search for
             * Output absolute name of found file, if any
             */
        } else if (command.equals("search")) {
            // search word+
            /**
             * List files containing the specified word(s). Sort files by match frequency.
             * @val word+ Word(s) to search for
             */
        } else {
            /**
             * Provided command did not match available commands
             */
            System.out.println("Error: Invalid Command");
        }
    }
}

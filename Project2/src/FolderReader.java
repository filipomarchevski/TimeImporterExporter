import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TimerTask;

/**
 * It will be called by a Timer schedule method, to read all the contents from a folder, periodically.
 */
public class FolderReader extends TimerTask {

    /**
     * Stores the number of files that we have read on the previous call,
     * so we can start where we left, and not go over the files we have already read.
     */
    private int amountOfFilesRead;

    /**
     * List of all the files in the folder.
     */
    private File[] files;

    @Override
    public void run() {
        updateFiles();
        readFiles();
    }

    /**
     * This method will be called periodically.
     * First it sorts the files in the list by their name, then we go through each one of the files,
     * and print the content line by line.
     * At the end it updates the amount of files read with the last index of the array.
     */
    public void readFiles() {
        sortFileNames();
        for (int i = amountOfFilesRead; i < files.length; i++) {
            try (Scanner scanner = new Scanner(files[i])) {
                System.out.println("Content of file " + files[i].getName());
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        amountOfFilesRead = files.length;
    }

    /**
     * Sorting the files by the number in their name.
     */
    public void sortFileNames() {
        Arrays.sort(files, (o1, o2) -> {
            Integer x1 = Integer.valueOf(o1.getName().substring(7, o1.getName().length() - 4));
            Integer x2 = Integer.valueOf(o2.getName().substring(7, o2.getName().length() - 4));
            return x1.compareTo(x2);
        });
    }

    /**
     * Before reading of the contents of the files, it will add all the files from the folder again,
     * since new files might have been added.
     */
    public void updateFiles() {
        File folder = new File("/tmp/output");
        files = folder.listFiles();
    }
}
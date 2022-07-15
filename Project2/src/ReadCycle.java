import java.util.Timer;

public class ReadCycle {

    /**
     * Executes a task and loops it after n milliseconds of time.
     *
     * @param milliseconds - the period of time, how long until the loop repeats.
     * @param folderReader - provides the task that will be repeated.
     */
    public static void startCycle(long milliseconds, FolderReader folderReader) {
        Timer timer = new Timer();
        timer.schedule(folderReader, 0, milliseconds);
    }
}

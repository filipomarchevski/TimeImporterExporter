import java.util.Timer;

public class TimeCycle {

    /**
     * Executes a task and loops it after n milliseconds of time.
     *
     * @param milliseconds - the period of time, how long until the loop repeats.
     * @param timeExporter - provides the task that will be repeated.
     */
    public static void startCycle(long milliseconds, TimeExporter timeExporter) {
        Timer timer = new Timer();
        timer.schedule(timeExporter, 0, milliseconds);
    }
}

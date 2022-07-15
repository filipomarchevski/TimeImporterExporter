import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.TimerTask;

/**
 * The class will be passed to a timers schedule method, which will execute the run() method n amount of times.
 */
public class TimeExporter extends TimerTask {
    private final static StringBuilder fileName = new StringBuilder("dateLog1");

    @Override
    public void run() {
        exportDateToFIle();
    }

    /**
     * We are exporting the current date and time, in a folder "output".
     * Each time we export, a new text file will be created.
     */
    public void exportDateToFIle() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("output/" + fileName + ".txt")) {
            fileOutputStream.write(getCurrentTime().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            updateFileName();
        }
    }

    /**
     * We are getting the current date and time and formatting it (day/month/year, hour:minutes AM/PM).
     *
     * @return the parsed LocalDateTime.
     */
    public String getCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * We are extracting the number portion of the fileName, incrementing it by one,
     * and replacing the old sequence of numbers in the fileName, with the updated version.
     * It will be called everytime we export a date in order to create a new file and export it there.
     */
    public void updateFileName() {
        int n = Integer.parseInt(fileName.substring(7));
        n++;
        fileName.replace(7, fileName.length(), n + "");
    }
}
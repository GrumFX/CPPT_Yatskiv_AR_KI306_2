package KI306.Yatskiv.Lab3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Logger {
    private static final String LOG_FILE = "Sportsman.txt";
    private static PrintWriter logWriter;

    private static Logger instance = null;

    private Logger() {
        try {
            logWriter = new PrintWriter(new FileWriter(LOG_FILE, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message); // Print to console
        logWriter.println(message);  // Write to log file
        logWriter.flush(); // Ensure the message is written immediately
    }

    public void close() {
        logWriter.close();
    }
}

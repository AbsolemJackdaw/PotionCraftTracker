package tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class PotionLogger {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Logger LOG = Logger.getLogger("PotionTracker");


    public static void setupLogger() {
        ConsoleHandler handler = new ConsoleHandler();
        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                builder.append(time(record.getMillis()));
                builder.append("]");
                //builder.append(ANSI_BLUE);
                builder.append(record.getMessage());
               // builder.append(ANSI_RESET);
                builder.append("\n");
                return builder.toString();
            }
        };
        handler.setLevel(Level.ALL);
        handler.setFormatter(formatter);
        LOG.setUseParentHandlers(false);
        LOG.addHandler(handler);
        LOG.setLevel(Level.ALL);
    }

    private static String time(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("HH:mm:ss");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }
}

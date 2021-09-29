package tracker.commands;

import tracker.PotionLogger;
import tracker.PotionTracker;

public class CommandClear extends Command {

    public CommandClear() {
        super("clear");
    }

    @Override
    public void execute() {
        PotionLogger.LOG.info("Erasing Tracker... This will clean out all data. Proceed ? (yes / no)");
        if (PotionTracker.scan.nextLine().toLowerCase().contains("y")) {
            PotionTracker.tracker.clear();
            PotionLogger.LOG.warning("cleared tracker. tracker is now empty");
        }
    }
}

package tracker.commands;

import tracker.FileReader;
import tracker.PotionLogger;
import tracker.PotionTracker;

public class CommandStop extends Command {
    public CommandStop() {
        super("stop");
    }

    @Override
    public void execute() {
        PotionLogger.LOG.info("quitting. have you recently saved ? type yes to save, no to quit.");
        if (PotionTracker.scan.nextLine().toLowerCase().contains("y")) {
            FileReader.INSTANCE.saveToFile("backup", PotionTracker.tracker);
            PotionLogger.LOG.info("saved to 'backup'");
        }
        PotionTracker.stop();
    }
}

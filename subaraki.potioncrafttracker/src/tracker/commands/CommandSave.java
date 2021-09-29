package tracker.commands;

import tracker.FileReader;
import tracker.PotionLogger;
import tracker.PotionTracker;

public class CommandSave extends Command {

    public CommandSave() {
        super("save");
    }

    @Override
    public void execute() {
        if (getArgument() == null || getArgument().length() == 0) {
            PotionLogger.LOG.warning("cant save to blank file. please give up a name for the file");
            return;
        }
        FileReader.INSTANCE.saveToFile(getArgument(), PotionTracker.tracker);
    }
}

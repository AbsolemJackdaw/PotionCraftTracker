package tracker.commands;

import tracker.Potions;
import tracker.PotionLogger;
import tracker.PotionTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandRemove extends Command {
    public CommandRemove() {
        super("remove");
    }

    @Override
    public void execute() {
        if (getArgument() == null || getArgument().isEmpty()) {
            PotionLogger.LOG.info("no arguments found. please give up what potion to remove");
            return;
        }
        List<Potions> potions = Potions.getPotionsFromString(getArgument());
        if (!potions.isEmpty()) {
            PotionTracker.tracker.remove(potions); //removes if present
        }
    }
}

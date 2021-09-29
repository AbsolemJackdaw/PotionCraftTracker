package tracker.commands;

import tracker.FileReader;
import tracker.Potions;
import tracker.PotionTracker;

import java.util.ArrayList;
import java.util.Map;

public class CommandLoad extends Command {

    public CommandLoad() {
        super("load");
    }

    @Override
    public void execute() {
        Object o = FileReader.INSTANCE.readFromFile(getArgument());
        if (o instanceof Map map) {
            PotionTracker.tracker.clear();
            PotionTracker.tracker.putAll(map);
        }
    }
}

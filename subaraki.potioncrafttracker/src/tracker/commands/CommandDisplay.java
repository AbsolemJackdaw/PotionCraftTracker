package tracker.commands;

import tracker.PotionTracker;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandDisplay extends Command {

    public CommandDisplay() {
        super("display");
    }

    @Override
    public void execute() {
        if (!PotionTracker.tracker.isEmpty()) {
            PotionTracker.tracker.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach((set) -> {
                String name = set.getKey().stream().map(Enum::name).collect(Collectors.joining("_"));
                System.out.format("%-30s : %-15d%n", name, set.getValue());
            });
        }
    }
}

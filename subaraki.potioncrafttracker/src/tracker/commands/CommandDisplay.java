package tracker.commands;

import tracker.PotionTracker;

import java.util.stream.Collectors;

public class CommandDisplay extends Command {

    public CommandDisplay() {
        super("display");
    }

    @Override
    public void execute() {
        if (!PotionTracker.tracker.isEmpty()) {
            PotionTracker.tracker.forEach((key, value) -> {
                String name = key.stream().map(Enum::name).collect(Collectors.joining("_"));
                System.out.format("%-30s : %-15d%n",name,value);
            });
        }
    }
}

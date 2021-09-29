package tracker.commands;

import java.util.List;
import java.util.Optional;

public class Commands {

    private List<Command> COMMANDS = List.of(
            new CommandFix(),
            new CommandRemove(),
            new CommandStop(),
            new CommandDisplay(),
            new CommandClear(),
            new CommandLoad(),
            new CommandSave()
    );
    public static final Commands INSTANCE = new Commands();

    public Optional<Command> getCommand(String name) {
        if (name != null && !name.isEmpty()) {
            for (Command command : COMMANDS) {
                if (command.getName().equals(name))
                    return Optional.of(command);
            }
        }
        return Optional.empty();
    }
}

package tracker.commands;

public abstract class Command {

    private String name;
    private String[] arguments;
    private String fullArgument;

    public Command(String name) {
        this.name = name;
    }

    public void setArguments(String commandArguments) {
        fullArgument = commandArguments;
        this.arguments = commandArguments.split(" ");
    }

    public String[] getSplitArgument() {
        return arguments;
    }

    public String getArgument() {
        return fullArgument;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();


}

package tracker;

import tracker.commands.Command;
import tracker.commands.Commands;

import java.util.*;
import java.util.stream.Collectors;

public class PotionTracker {

    private static boolean runProgram = true;
    public static Map<List<Potions>, Integer> tracker = new HashMap<>();
    public static Scanner scan = new Scanner(System.in);

    public void start() {
        PotionLogger.setupLogger();

        PotionLogger.LOG.fine("Welcome to PotionTracker !");
        PotionLogger.LOG.fine("We're working on a visual interface to click effects");
        PotionLogger.LOG.fine("");
        PotionLogger.LOG.fine("To add a potion to the tracking statistics, please enter its name and press enter. ");
        PotionLogger.LOG.fine("possible names are : ");
        Arrays.stream(Potions.values()).forEach(entry -> PotionLogger.LOG.info("*  " + entry.toString()));
        PotionLogger.LOG.info(" - you can type multiple potion names for combos. no level is taken in account.");
        PotionLogger.LOG.info(" - potions matching any part of typed string will be used to identify potion.");
        PotionLogger.LOG.info("     'li' will be recognized for both light and libido.");
        PotionLogger.LOG.info("     'hallu' will be recognized for Hallucinations");
        PotionLogger.LOG.info("/fix [potion] > subtract one from said stored potion.");
        PotionLogger.LOG.info("/remove [potion] > removes entry for a potion");
        PotionLogger.LOG.info("/save [filename] > save progress from tracker to file");
        PotionLogger.LOG.info("/load [filename] > load progress from file to tracker");
        PotionLogger.LOG.info("/display > display all current tracking");
        PotionLogger.LOG.info("/stop > end tracker");

        doTrackLoop();
    }

    public void doTrackLoop() {
        while (runProgram) {
            String entered = scan.nextLine().toLowerCase();

            if (entered.startsWith("/")) {
                try {
                    handleCommands(entered.substring(1)); //remove dash
                } catch (IllegalArgumentException e) {
                    PotionLogger.LOG.warning(e.getMessage());
                }
            } else {
                if (!entered.isEmpty()) {
                    List<Potions> potion = Potions.getPotionsFromString(entered);
                    if (potion.isEmpty()) {
                        PotionLogger.LOG.warning("Could not find any potions in " + entered + ". Didn't add anything");
                    } else {
                        if (tracker.containsKey(potion)) {
                            int total = tracker.get(potion);
                            tracker.put(potion, ++total);
                        } else {
                            tracker.put(potion, 1);
                        }
                        System.out.format("successfully added 1 %s", potion.stream().map(Enum::name).collect(Collectors.joining("_")));
                    }
                }
            }
        }
    }

    private void handleCommands(String entered) throws IllegalArgumentException {

        String name = entered.split(" ", 2)[0];
        Optional<Command> optional = Commands.INSTANCE.getCommand(name);
        optional.ifPresent(command -> {
            if (entered.length() > name.length()) //if the command has arguments
                command.setArguments(entered.substring(entered.indexOf(" ") + 1));
            command.execute();
        });

    }

    public static void stop() {
        runProgram = false;
    }
}

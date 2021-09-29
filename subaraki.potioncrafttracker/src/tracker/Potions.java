package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum Potions {
    ACID,
    BERSERKER,
    BOUNCE,
    CHARM,
    EXPLOSION,
    GROWTH,
    FIRE,
    FROST,
    HALLUCINATIONS,
    HEALING,
    INVISIBILITY,
    LEVITATION,
    LIBIDO,
    LIGHT,
    THUNDER,
    VISION,
    MANA,
    NECROMANCY,
    POISONING,
    HARVEST,
    SLEEP,
    SLOW,
    STONESKIN;

    public static ArrayList<Potions> getPotionsFromString(String names) {
        return (ArrayList<Potions>) Arrays.stream(Potions.values())
                .distinct()
                .filter(potion -> Arrays.stream(names.split(" ")).anyMatch(name -> potion.name().toLowerCase().contains(name)))
                .collect(Collectors.toList());
    }
}

package tracker;

import java.util.Arrays;
import java.util.List;
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

    public static List<Potions> getPotionsFromString(String names) {
        return Arrays.stream(Potions.values())
                .distinct()
                .filter(potion -> Arrays.stream(names.split(" ")).anyMatch(name -> potion.name().startsWith(name)))
                .collect(Collectors.toList());
    }
}

package live.soupsy.zau.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class AbilitiesStorage {
    private static final HashMap<String, Integer> mainAbilities = new HashMap<>();
    // Ability ID, Cooldown
    private static final ArrayList<String> abilityModifiers = new ArrayList<>();
    // Ability ID

    public static void registerAbilities(){
        // Main Abilities.
        mainAbilities.put("Strong Arm", 60);
        mainAbilities.put("Tank", 60);
        mainAbilities.put("Flame", 60);
        mainAbilities.put("Vitalist", 60);

        mainAbilities.put("Vision Keeper", 60);
        mainAbilities.put("Silencer", 60);
        mainAbilities.put("Speedster", 60);
        mainAbilities.put("Sneaker", 60);

        mainAbilities.put("Lifter", 60);
        mainAbilities.put("Revealed", 60);
        mainAbilities.put("Breaker", 60);
        mainAbilities.put("Disguise", 60);

        // Modifiers
        abilityModifiers.add("Half");
        abilityModifiers.add("Strengthen");
        abilityModifiers.add("Reach");
        abilityModifiers.add("Masterly");
    }


    public static int getAbilityCooldownLength(String ability){
        return mainAbilities.get(ability);
    }
}

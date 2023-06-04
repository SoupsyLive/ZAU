package live.soupsy.zau.utils;

import java.util.HashMap;

public class AbilitiesStorage {
    private static final HashMap<String, Integer> mainAbilities = new HashMap<>();
    // Ability ID, Cooldown

    // add cooldowns
    public static void registerAbilities(){
        // Main Abilities.
        mainAbilities.put("Strong Arm", 60);
        mainAbilities.put("Concealed Carrier", 60);
        mainAbilities.put("Tank", 60);
    }

    public static int getAbilityCooldownLength(String ability){
        return mainAbilities.get(ability);
    }
}

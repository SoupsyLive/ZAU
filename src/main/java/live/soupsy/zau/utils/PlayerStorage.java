package live.soupsy.zau.utils;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStorage {
    private static final HashMap<UUID, String> imposters = new HashMap<>();
    private static final HashMap<UUID, String> imposterModifiers = new HashMap<>();
    private static final HashMap<UUID, Long> imposterCooldowns = new HashMap<>();

    public static void addImposter(UUID id, String ability, Long currentTime){
        imposters.put(id, ability);
        imposterCooldowns.put(id, currentTime);
    }
    public static void removeImposter(UUID id){
        if(imposters.containsKey(id)){
            imposters.remove(id);
            imposterCooldowns.remove(id);
            imposterModifiers.remove(id);
        }
    }
    public static boolean checkImposter(UUID id){
        if(imposters.containsKey(id)){
            return true;
        }else{
            return false;
        }
    }
    public static long getImposterCooldown(UUID id){
        if(imposterCooldowns.containsKey(id)){
            long cooldown = imposterCooldowns.get(id);
            return cooldown;
        }
        return -1;
    }
    public static String getImposterModifier(UUID id){
        if(imposterModifiers.containsKey(id)){
            String modifier = imposterModifiers.get(id);
            return modifier;
        }
        return null;
    }
    public static void setImposterModifier(UUID id, String modifier){
        imposterModifiers.put(id, modifier);
    }
    public static void removeImposterModifier(UUID id){
        if(imposterModifiers.containsKey(id)){
            imposterModifiers.remove(id);
        }
    }
    public static void updateCooldown(UUID id, long cooldown){
        imposterCooldowns.replace(id, cooldown);
    }
}

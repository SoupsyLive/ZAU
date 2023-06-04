package live.soupsy.zau.utils;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStorage {
    private static final HashMap<UUID, String> imposters = new HashMap<>();
    private static final HashMap<UUID, Long> imposterCooldowns = new HashMap<>();

    public static void addImposter(UUID id, String ability, Long currentTime){
        if(!imposters.containsKey(id)){
            imposters.put(id, ability);
            if(!imposters.containsKey(id)){
                imposterCooldowns.put(id, currentTime);
            }
        }

    }
    public static void removeImposter(UUID id, String ability){
        if(imposters.containsKey(id)){
            imposters.remove(id);
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
    public static void updateCooldown(UUID id, long cooldown){
        imposterCooldowns.replace(id, cooldown);
    }
}

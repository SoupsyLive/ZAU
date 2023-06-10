package live.soupsy.zau.utils;

import live.soupsy.zau.game.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerStorage {
    private static final HashMap<UUID, String> imposters = new HashMap<>();
    private static final HashMap<UUID, String> imposterModifiers = new HashMap<>();
    private static final HashMap<UUID, Long> imposterCooldowns = new HashMap<>();
    private static final ArrayList<UUID> frozenPlayers = new ArrayList<>();


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
    public static boolean getFrozen(UUID id){
        if(frozenPlayers.contains(id)){
            return true;
        }
        return false;
    }
    public static void addFrozen(UUID id){
        if(!frozenPlayers.contains(id)){
            frozenPlayers.add(id);
        }
    }
    public static void removeFrozen(UUID id){
        if(frozenPlayers.contains(id)){
            frozenPlayers.remove(id);
        }
    }
}

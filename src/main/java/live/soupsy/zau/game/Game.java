package live.soupsy.zau.game;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private static Integer status;
    //0: Inactive
    //1: Starting
    //2: Active
    //3: Ended
    //4: Paused

    private static List<UUID> crewmates = new ArrayList<>();
    private static List<UUID> imposters = new ArrayList<>();

    // Game Status Functions

    public void startGame(){

    }
    public static void resetGame(){
        status = 0;
        crewmates = new ArrayList<>();
        imposters = new ArrayList<>();
    }
    public static Integer getStatus(){
        return status;
    }
    public static void setStatus(Integer status){
        status = status;
    }

    // Player Functions

    public static boolean isCrewmate(UUID uuid){
        if(crewmates.contains(uuid)){
            return true;
        }
        return false;
    }
    public static void addCrewmate(UUID uuid){
        if(crewmates.contains(uuid)){
            crewmates.add(uuid);
        }
    }
    public static void removeCrewmate(UUID uuid){
        crewmates.remove(uuid);
    }

    public static boolean isImposter(UUID uuid){
        if(imposters.contains(uuid)){
            return true;
        }
        return false;
    }
    public static void addImposter(UUID uuid){
        if(!imposters.contains(uuid)){
            imposters.add(uuid);
        }
    }
    public static void removeImposter(UUID uuid){
        imposters.remove(uuid);
    }
}

package live.soupsy.zau.game;

import live.soupsy.zau.ZyyesAmongUs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThingIDontKnowWhatToNameButItsForAfterImposterGUI {
    private static Integer readyImposters = 0;



    public static void readyImposter(){
        FileConfiguration config = ZyyesAmongUs.getInstance().getConfig();
        int imposterCount = (int) config.get("imposters");
        readyImposters++;
        if(readyImposters == imposterCount){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

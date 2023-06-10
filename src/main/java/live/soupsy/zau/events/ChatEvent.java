package live.soupsy.zau.events;

import live.soupsy.zau.game.Game;
import live.soupsy.zau.ZyyesAmongUs;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(Game.getStatus().equals(1) || Game.getStatus().equals(2)){
            FileConfiguration config = ZyyesAmongUs.getInstance().getConfig();
            boolean configPauseCheck = (boolean) config.get("canChatDuringPause");
            if(configPauseCheck){
                Player player = e.getPlayer();
                int chatRad = (int) config.get("chat-radius");

                for (Player near : Bukkit.getOnlinePlayers()) {
                    if (near.getLocation().distance(player.getLocation()) > chatRad) {
                        e.getRecipients().remove(near);
                    }
                }
            }

        }
    }
}

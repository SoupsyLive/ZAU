package live.soupsy.zau.listener;

import live.soupsy.zau.data.PlayerData;
import live.soupsy.zau.data.PlayerDataManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerDataManager.setData(e.getPlayer());
    }
}

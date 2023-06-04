package live.soupsy.zau.listener;

import live.soupsy.zau.data.PlayerData;
import live.soupsy.zau.data.PlayerDataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GuiListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        PlayerData data = PlayerDataManager.getData((Player) e.getWhoClicked());

        if(data != null && data.getOpenGui() != null){
            if(e.getCurrentItem() != null){
                data.getOpenGui().handleButton(e.getCurrentItem());

                e.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        PlayerDataManager.getData((Player) e.getPlayer()).setOpenGui(null);
    }
}

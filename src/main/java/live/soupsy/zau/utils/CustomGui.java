package live.soupsy.zau.utils;

import live.soupsy.zau.ZyyesAmongUs;
import live.soupsy.zau.data.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CustomGui {
    private int rows;
    private Inventory inv;
    private List<GuiButton> buttons = new ArrayList<>();

    public CustomGui(String title, int rows){
        if(rows > 9){
            ZyyesAmongUs.getInstance().getLogger().info("[ZUA]: GUI creation error, no more than 8 rows can be made");
            return;
        }

        this.rows = rows;
        this.inv = Bukkit.createInventory(null, rows*9, title);
    }
    public void setItem(GuiButton button, int slot){
        buttons.add(button);
        inv.setItem(slot, button.getStack());
    }

    public void handleButton(ItemStack stack){
        GuiButton button = buttons.stream().filter(p -> p.getStack().isSimilar(stack)).findAny().orElse(null);

        if(button != null){
            button.getAction().run();
        }
    }

    public void show(Player player){
        PlayerDataManager.getData(player).setOpenGui(this);
        player.openInventory(inv);
    }


}

package live.soupsy.zau.commands;

import live.soupsy.zau.gui.AbilitySelectGui;
import live.soupsy.zau.utils.GuiButton;
import live.soupsy.zau.utils.CustomGui;
import live.soupsy.zau.utils.PlayerStorage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            AbilitySelectGui.openAbilitySelector(player);

        }


        return true;
    }
}

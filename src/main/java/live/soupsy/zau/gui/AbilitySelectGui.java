package live.soupsy.zau.gui;

import live.soupsy.zau.utils.AbilitiesStorage;
import live.soupsy.zau.utils.CustomGui;
import live.soupsy.zau.utils.GuiButton;
import live.soupsy.zau.utils.PlayerStorage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class AbilitySelectGui {
    public static void openAbilitySelector(Player player){
        CustomGui classGui = new CustomGui("Choose class", 5);

        // reject button
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Pass to someone else!");
        close.setItemMeta(closeMeta);

        GuiButton button = new GuiButton(close);
        button.setAction(() -> {
            player.closeInventory();
        });

        classGui.setItem(button, 40);

        // style bars
        ItemStack gray = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(" ");
        gray.setItemMeta(grayMeta);

        button = new GuiButton(gray);
        button.setAction(() -> {});

        for(int i=0; i<9; i++){
            classGui.setItem(button, i);
        }

        //red bars
        ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(" ");
        red.setItemMeta(redMeta);

        button = new GuiButton(red);
        button.setAction(() -> {});

        for(int i=36; i<45; i++){
            if(i != 40){
                classGui.setItem(button, i);
            }
        }

        //white bars
        ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(" ");
        white.setItemMeta(whiteMeta);

        button = new GuiButton(white);
        button.setAction(() -> {});

        for(int i=9; i<36; i++){
            if(i == 10 || i == 11 || i == 13 || i == 15 || i == 17 || i == 19 || i == 20 || i == 22 || i == 24 || i == 26 ||
                    i == 28 || i == 29 || i == 31 || i == 33 || i == 35){
                classGui.setItem(button, i);
            }
        }



        // Classes

        // Categories

        // brute abilities
        ItemStack forceful = new ItemStack(Material.ANVIL);
        ItemMeta forcefulMeta = forceful.getItemMeta();
        forcefulMeta.setDisplayName(ChatColor.DARK_RED+"Brute Abilities");
        forcefulMeta.setLore(Collections.singletonList(ChatColor.DARK_GRAY + "Pure forceful tactics."));
        forceful.setItemMeta(forcefulMeta);

        button = new GuiButton(forceful);
        button.setAction(() -> {});

        classGui.setItem(button, 9);

        // stealth abilities
        ItemStack stealth = new ItemStack(Material.INK_SAC);
        ItemMeta stealthMeta = stealth.getItemMeta();
        stealthMeta.setDisplayName(ChatColor.GRAY+"Stealth Abilities");
        stealthMeta.setLore(Collections.singletonList(ChatColor.DARK_GRAY + "Sneak tactics."));
        stealth.setItemMeta(stealthMeta);

        button = new GuiButton(stealth);
        button.setAction(() -> {});

        classGui.setItem(button, 18);

        // hysteria abilities
        ItemStack hysteria = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta hysteriaMeta = hysteria.getItemMeta();
        hysteriaMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Hysteria Abilities");
        hysteriaMeta.setLore(Collections.singletonList(ChatColor.DARK_GRAY + "Chaotic tactics."));
        hysteria.setItemMeta(hysteriaMeta);

        button = new GuiButton(hysteria);
        button.setAction(() -> {});

        classGui.setItem(button, 27);

        // Abilities

        // Strong Arm
        ItemStack strongArm = new ItemStack(Material.COBBLESTONE);
        ItemMeta strongArmMeta = strongArm.getItemMeta();
        strongArmMeta.setDisplayName(ChatColor.DARK_AQUA+"Strong Arm");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Gain intense strength at a moment's notice");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Strong Arm")+"s]");
        strongArmMeta.setLore(lore);
        strongArm.setItemMeta(strongArmMeta);

        button = new GuiButton(strongArm);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Strong Arm", timern);
            player.sendMessage(ChatColor.DARK_AQUA+"Strong Arm Selected!");
            player.closeInventory();
        });
        classGui.setItem(button, 12);

        // Tank
        ItemStack tank = new ItemStack(Material.OBSIDIAN);
        ItemMeta tankMeta = tank.getItemMeta();
        tankMeta.setDisplayName(ChatColor.DARK_PURPLE+"Tank");
        lore = new ArrayList<>();
        lore.add("§7Gain intense defense when in need.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Tank")+"s]");
        tankMeta.setLore(lore);
        tank.setItemMeta(tankMeta);

        button = new GuiButton(tank);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Tank", timern);
            player.sendMessage(ChatColor.DARK_PURPLE+"Tank Selected!");
            player.closeInventory();
        });

        classGui.setItem(button, 14);

        classGui.show(player);
    }
}

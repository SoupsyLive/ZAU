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
        CustomGui classGui = new CustomGui("Choose class", 6);
        ArrayList<String> lore;
        GuiButton button;

        // reject button
        lore = new ArrayList<>();
        button = makeItem(Material.BARRIER, "§cPass to someone else!", lore);
        button.setAction(() -> {
            player.sendMessage(ChatColor.RED+"Passed to someone else.");
            PlayerStorage.removeImposter(player.getUniqueId());
            player.closeInventory();
        });
        classGui.setItem(button, 45);

        // confirm button
        lore = new ArrayList<>();
        button = makeItem(Material.LIME_CONCRETE_POWDER, "§aConfirm choices!", lore);
        button.setAction(() -> {
            player.sendMessage(ChatColor.GREEN+"Confirmed choices!");
            player.closeInventory();
        });
        classGui.setItem(button, 53);

        // black wrap bars
        lore = new ArrayList<>();
        button = makeItem(Material.BLACK_STAINED_GLASS_PANE, " ", lore);
        button.setAction(() -> {});
        for(int i=0; i<50; i++){
            if(i<9 || i== 16 || i==25 || i==34 || (i>35 && i<45) || i==49){
                classGui.setItem(button, i);
            }
        }

        //red bars
        lore = new ArrayList<>();
        button = makeItem(Material.RED_STAINED_GLASS_PANE, " ", lore);
        button.setAction(() -> {});
        for(int i=46; i<49; i++){
            classGui.setItem(button, i);
        }

        //green bars
        lore = new ArrayList<>();
        button = makeItem(Material.LIME_STAINED_GLASS_PANE, " ", lore);
        button.setAction(() -> {});
        for(int i=50; i<53; i++){
            classGui.setItem(button, i);
        }

        //white bars
        lore = new ArrayList<>();
        button = makeItem(Material.WHITE_STAINED_GLASS_PANE, " ", lore);
        button.setAction(() -> {});
        for(int i=9; i<36; i++){
            if(i == 10 || i == 15 || i == 19 || i == 24 || i == 28 || i == 33){
                classGui.setItem(button, i);
            }
        }


// CLASSES

        // CATEGORIES

        // Brute
        lore = new ArrayList<>();
        lore.add("§8Pure forceful tactics.");
        button = makeItem(Material.ANVIL, "§4Brute Abilities", lore);
        button.setAction(() -> {});
        classGui.setItem(button, 9);


        // stealth abilities
        lore = new ArrayList<>();
        lore.add("§8Sneaky tactics.");
        button = makeItem(Material.BLACK_DYE, "§7Stealth Abilities", lore);
        button.setAction(() -> {});
        classGui.setItem(button, 18);


        // hysteria abilities
        lore = new ArrayList<>();
        lore.add("§8Chaotic tactics.");
        button = makeItem(Material.DRAGON_BREATH, "§dHysteria Abilities", lore);
        button.setAction(() -> {});
        classGui.setItem(button, 27);

        // ABILITIES

        // Strong Arm
        lore = new ArrayList<>();
        lore.add("§7Gain intense strength at a");
        lore.add("§7moment's notice.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Strong Arm")+"s]");
        button = makeItem(Material.COBBLESTONE, "§3Strong Arm", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.removeImposter(player.getUniqueId());
            PlayerStorage.addImposter(player.getUniqueId(), "Strong Arm", timern);
            player.sendMessage(ChatColor.DARK_AQUA+"Strong Arm Selected!");
        });
        classGui.setItem(button, 11);

        // Tank
        lore = new ArrayList<>();
        lore.add("§7Gain intense defense when");
        lore.add("§7in need.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Tank")+"s]");
        button = makeItem(Material.OBSIDIAN, "§5Tank", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Tank", timern);
            player.sendMessage(ChatColor.DARK_PURPLE+"Tank Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 12);

        // Flame
        lore = new ArrayList<>();
        lore.add("§7Activate an intense flame to");
        lore.add("§7ignite your enemies with.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Flame")+"s]");
        button = makeItem(Material.BLAZE_POWDER, "§6Flame Wielder", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Flame", timern);
            player.sendMessage(ChatColor.GOLD+"Flame Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 13);

        // Vitalist
        lore = new ArrayList<>();
        lore.add("§7Expand your maximum health");
        lore.add("§7to double what you had before.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Vitalist")+"s]");
        button = makeItem(Material.NETHER_WART_BLOCK, "§cVitalist", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Vitalist", timern);
            player.sendMessage(ChatColor.RED+"Vitalist Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 14);

        // Vision Keeper
        lore = new ArrayList<>();
        lore.add("§7Revoke the sight of people around you.");
        lore.add("§7around you.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Vision Keeper")+"s]");
        button = makeItem(Material.INK_SAC, "§8Vision Keeper", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Vision Keeper", timern);
            player.sendMessage(ChatColor.DARK_GRAY+"Vision Keeper Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 20);

        // Silencer
        lore = new ArrayList<>();
        lore.add("§7Deafen your peers.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Silencer")+"s]");
        button = makeItem(Material.BLACK_CANDLE, "§fSilencer", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Silencer", timern);
            player.sendMessage(ChatColor.WHITE+"Silencer Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 21);

        // Speedster
        lore = new ArrayList<>();
        lore.add("§7Run like the wind, chase or");
        lore.add("§7be chased.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Speedster")+"s]");
        button = makeItem(Material.FEATHER, "§fSpeedster", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Speedster", timern);
            player.sendMessage(ChatColor.WHITE+"Speedster Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 22);

        // Sneaker
        lore = new ArrayList<>();
        lore.add("§7Turn invisible, but not");
        lore.add("§7entirely.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Sneaker")+"s]");
        button = makeItem(Material.TINTED_GLASS, "§8Sneaker", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Sneaker", timern);
            player.sendMessage(ChatColor.DARK_GRAY+"Sneaker Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 23);

        // Lifter
        lore = new ArrayList<>();
        lore.add("§7Rise everyone around you");
        lore.add("§7into the air.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Lifter")+"s]");
        button = makeItem(Material.PEARLESCENT_FROGLIGHT, "§fLifter", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Sneaker", timern);
            player.sendMessage(ChatColor.WHITE+"Lifter Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 29);

        // Revealed
        lore = new ArrayList<>();
        lore.add("§7Reveal all your peers.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Revealed")+"s]");
        button = makeItem(Material.ENDER_EYE, "§eRevealer", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Revealed", timern);
            player.sendMessage(ChatColor.YELLOW+"Revealer Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 30);

        // Breaker
        lore = new ArrayList<>();
        lore.add("§7Weaken your peers.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Breaker")+"s]");
        button = makeItem(Material.BONE, "§2Breaker", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Breaker", timern);
            player.sendMessage(ChatColor.DARK_GREEN+"Breaker Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 31);

        // Disguise
        lore = new ArrayList<>();
        lore.add("§7Send everyone into a panic,");
        lore.add("§7everyone turns blind for");
        lore.add("§7a few moments, then are");
        lore.add("§7turned invisible.");
        lore.add("§8["+ AbilitiesStorage.getAbilityCooldownLength("Disguise")+"s]");
        button = makeItem(Material.SOUL_LANTERN, "§5Disguise", lore);
        button.setAction(() -> {
            long timern = System.currentTimeMillis();
            PlayerStorage.addImposter(player.getUniqueId(), "Disguise", timern);
            player.sendMessage(ChatColor.DARK_PURPLE+"Disguise Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 32);

// ABILITY MODIFIERS

        // Half
        lore = new ArrayList<>();
        lore.add("§7Half your ability cooldown.");
        button = makeItem(Material.CLOCK, "§eCooldown Reduction", lore);
        button.setAction(() -> {
            PlayerStorage.setImposterModifier(player.getUniqueId(), "Half");
            player.sendMessage(ChatColor.YELLOW+"Half-Cooldown Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 17);

        // Strengthen
        lore = new ArrayList<>();
        lore.add("§7Double the strength of");
        lore.add("§7your ability.");
        button = makeItem(Material.GLOWSTONE_DUST, "§cStrengthen", lore);
        button.setAction(() -> {
            PlayerStorage.setImposterModifier(player.getUniqueId(), "Strengthen");
            player.sendMessage(ChatColor.RED+"Strengthen Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 26);

        // Reach
        lore = new ArrayList<>();
        lore.add("§7Double the reach of");
        lore.add("§7your ability.");
        button = makeItem(Material.GUNPOWDER, "§bReach", lore);
        button.setAction(() -> {
            PlayerStorage.setImposterModifier(player.getUniqueId(), "Reach");
            player.sendMessage(ChatColor.AQUA+"Reach Selected!");
            //player.closeInventory();
        });
        classGui.setItem(button, 35);

        classGui.show(player);
    }
    private static GuiButton makeItem(Material material, String name, ArrayList<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        return new GuiButton(item);
    }
}


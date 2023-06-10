package live.soupsy.zau.game;

import live.soupsy.zau.ZyyesAmongUs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class AbilityBossbar {
    private BossBar bar;
    private int taskID = -1;
    private final ZyyesAmongUs plugin;

    public AbilityBossbar(ZyyesAmongUs plugin){
        this.plugin = plugin;
    }

    public void addPlayer(Player player){
        bar.addPlayer(player);
    }
    public BossBar getBar(){
        return bar;
    }
    public void createBar(){
        bar = Bukkit.createBossBar(format("&lAbility"), BarColor.RED, BarStyle.SOLID);
        bar.setVisible(true);
    }
    public void cast(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            int count = -1;

            @Override
            public void run() {
                //bar.setProgress();

            }
        }, 0, 20);
    }

    private String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


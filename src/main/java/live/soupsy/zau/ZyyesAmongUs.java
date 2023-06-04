package live.soupsy.zau;

import live.soupsy.zau.commands.GuiCommand;
import live.soupsy.zau.listener.GuiListener;
import live.soupsy.zau.listener.JoinListener;
import live.soupsy.zau.utils.AbilitiesStorage;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZyyesAmongUs extends JavaPlugin {

    private static ZyyesAmongUs instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        AbilitiesStorage.registerAbilities();

        this.getServer().getPluginManager().registerEvents(new GuiListener(), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

        getCommand("gui").setExecutor(new GuiCommand());

        getLogger().info("Loaded Zyye's Amongus Plugin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ZyyesAmongUs getInstance(){
        return instance;
    }
}

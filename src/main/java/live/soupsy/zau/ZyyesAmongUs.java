package live.soupsy.zau;

import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime;
import live.soupsy.zau.commands.GuiCommand;
import live.soupsy.zau.commands.MoleCommand;
import live.soupsy.zau.commands.subcommands.MoleConfigSubcommand;
import live.soupsy.zau.events.ChatEvent;
import live.soupsy.zau.listener.GuiListener;
import live.soupsy.zau.listener.JoinListener;
import live.soupsy.zau.utils.AbilitiesStorage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZyyesAmongUs extends JavaPlugin {

    private static ZyyesAmongUs instance;

    @Override
    public FileConfiguration getConfig() {
        return super.getConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        saveDefaultConfig();

        AbilitiesStorage.registerAbilities();

        this.getServer().getPluginManager().registerEvents(new GuiListener(), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new ChatEvent(), this);


        getCommand("gui").setExecutor(new GuiCommand());
        getCommand("mole").setExecutor(new MoleCommand());


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

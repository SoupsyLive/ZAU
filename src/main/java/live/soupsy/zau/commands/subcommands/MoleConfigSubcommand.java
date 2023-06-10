package live.soupsy.zau.commands.subcommands;

import live.soupsy.zau.ZyyesAmongUs;
import live.soupsy.zau.commands.SubCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class MoleConfigSubcommand extends SubCommand{
    @Override
    public String getName() {
        return "config";
    }

    @Override
    public String getDescription() {
        return "modify the config files of ZUA";
    }

    @Override
    public String getSyntax() {
        return "/mole config <configuration> <value>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if(args.length > 1){
            String argument = args[1];
            String value = args[2];

            FileConfiguration config = ZyyesAmongUs.getInstance().getConfig();
            if(argument.equalsIgnoreCase("imposters")){
                config.set("imposters", Integer.parseInt(value));
                ZyyesAmongUs.getInstance().saveConfig();
                player.sendMessage("§eSaved §dimposters §eto §a"+value);
            }else if(argument.equalsIgnoreCase("chat-radius")){
                config.set("chat-radius", Integer.parseInt(value));
                ZyyesAmongUs.getInstance().saveConfig();
                player.sendMessage("§eSaved §dchat-radius §eto §a"+value);
            }else if(argument.equalsIgnoreCase("canChatDuringPause")){
                config.set("canChatDuringPause", value);
                ZyyesAmongUs.getInstance().saveConfig();
                player.sendMessage("§eSaved §dcanChatDuringPause §eto §a"+value);
            }
        }
    }
}

package live.soupsy.zau.commands;

import live.soupsy.zau.commands.subcommands.MoleConfigSubcommand;
import live.soupsy.zau.commands.subcommands.MoleStartSubcommand;
import live.soupsy.zau.utils.NumberCheckUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MoleCommand implements CommandExecutor, TabCompleter {
    private ArrayList<SubCommand> subcommands = new ArrayList<>();
    public MoleCommand(){
        subcommands.add(new MoleConfigSubcommand());
        subcommands.add(new MoleStartSubcommand());
    }

    public ArrayList<SubCommand> getSubCommands(){
        return subcommands;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length > 0){
                for(int i=0; i< getSubCommands().size(); i++){
                    if(args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(player, args);
                    }
                }
            }
        }
        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("config");
            arguments.add("start");
            arguments.add("pause");
            arguments.add("stop");

            return arguments;
        }else if(args.length == 2 && args[0].equalsIgnoreCase("config")){
            List<String> arguments = new ArrayList<>();
            arguments.add("imposters");
            arguments.add("chat-radius");
            arguments.add("canChatDuringPause");
            return arguments;
        }else{
            List<String> arguments = new ArrayList<>();
            arguments.add("");
            return arguments;
        }
        //return null;
    }
}

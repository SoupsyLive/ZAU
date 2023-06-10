package live.soupsy.zau.commands.subcommands;

import live.soupsy.zau.game.Game;
import live.soupsy.zau.ZyyesAmongUs;
import live.soupsy.zau.commands.SubCommand;
import live.soupsy.zau.gui.AbilitySelectGui;
import live.soupsy.zau.utils.PlayerStorage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;


public class MoleStartSubcommand extends SubCommand{
    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "starts the game";
    }

    @Override
    public String getSyntax() {
        return "/mole start";
    }

    @Override
    public void perform(Player player, String[] args) {
        if(args.length > 0){
            if(Game.getStatus().equals(0)){
                FileConfiguration config = ZyyesAmongUs.getInstance().getConfig();
                int imposterCount = (int) config.get("imposters");
                int chatRad = (int) config.get("chat-radius");

                if(imposterCount >= Bukkit.getOnlinePlayers().size()){
                    player.sendMessage("§6§l[ZAU]§r§4: §4§lError! §r§cThere must be at least 1 crew member");
                    return;
                }

                List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                for(int i = 0; i > imposterCount; i++){
                    Random randomNo = new Random();
                    int randomImposterNumber = randomNo.nextInt((Bukkit.getOnlinePlayers().size()-1) + 1) + 1;
                    Player imposter = players.get(randomImposterNumber);
                    AbilitySelectGui.openAbilitySelector(imposter);
                    Game.addImposter(imposter.getUniqueId());
                }

                Game.setStatus(1);

                for (Player person : Bukkit.getOnlinePlayers()) {
                    PlayerStorage.addFrozen(person.getUniqueId());
                    person.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, -1, 20, true, false, false));
                    person.sendTitle("§f§lImposters are choosing...", "", 20, 200, 20);
                }

                player.sendMessage("§6§l[ZAU]§r§f: §eStarting the game with §a"+imposterCount+"§e Imposters and §f"+chatRad+" §eChat Radius.");
                return;
            }
                player.sendMessage("§6§l[ZAU]§r§4: §4§lError! §r§cIt seems there is already a started game.");
        }
    }
}

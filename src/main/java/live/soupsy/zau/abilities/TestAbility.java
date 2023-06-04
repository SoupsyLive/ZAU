package live.soupsy.zau.abilities;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class TestAbility {
    public static void useAbility(Player player, String ability){
        if(ability.equalsIgnoreCase("Strong Arm")){
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 2, true, false, true));
        }else if(ability.equalsIgnoreCase("Concealed Carrier")){
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 2, true, false, true));
        }else if(ability.equalsIgnoreCase("Tank")){
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 2, true, false, true));
        }
    }

}

package coolboogey.coolboogey.system;

import coolboogey.coolboogey.files.DataManager;
import org.bukkit.entity.Player;

public class scoreUpdater {

    public static void UpdateScore(Player player, int amount) {
        if(DataManager.getConfig().contains("main.players." + player.getUniqueId())) {
            int playerInfo = DataManager.getConfig().getInt("main.players." + player.getUniqueId());
            DataManager.getConfig().set("main.players." + player.getUniqueId(), playerInfo + amount);
            DataManager.save();
        }
        else {
            DataManager.getConfig().set("main.players." + player.getUniqueId(), amount);
            DataManager.save();
        }
    }
}

package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.files.DataManager;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.sort;
import static org.bukkit.Bukkit.getServer;

public class leaderboard {
    public static boolean leaderboard(Player player) {
        player.sendMessage("Need a proper server to be able to inplement and fix this.");
        return true;
//        if(DataManager.getConfig().contains("main.event") || DataManager.getConfig().contains("main.players")) {
//            List<String> PlayersInfo = DataManager.getConfig().getStringList("main.players");
//            sort(PlayersInfo);
//            String total = null;
//            for(int i = 0; i < 10; i++) {
//                UUID curPlayer = UUID.fromString(PlayersInfo.get(i));
//                if(total == null) {
//                    total = getServer().getOfflinePlayer(curPlayer).getName();
//                }
//                else {
//                    total = total + getServer().getOfflinePlayer(curPlayer).getName();
//                }
//            }
//
//            return true;
//        }
//        else {
//            player.sendMessage("No event active or past events!");
//        }
//        return true;
    }
}

package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.files.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;


public class count {
    public static boolean count(Player player, String[] args) {
        if(DataManager.getConfig().contains("main.event") || DataManager.getConfig().contains("main.players")) {
            if(DataManager.getConfig().contains("main.players." + player.getUniqueId())) {
                List<String> EventInfo = DataManager.getConfig().getStringList("main.event");
                UUID uniqueId = null;
                if(args.length == 2) {
                    player.sendMessage("If you are trying to see other players count, you can't. I would need proper server to be able to test it with other mc account which I don't have.");
                    return true;
//                    if(Bukkit.getOfflinePlayer(args[1]).getUniqueId() != null) {
//                        uniqueId = Bukkit.getOfflinePlayer(args[1]).getUniqueId();
//                    }
//                    else {
//                        player.sendMessage("Not a valid username!");
//                    }
                }
                else {
                    uniqueId = player.getUniqueId();
                }
                if(EventInfo.get(0).equalsIgnoreCase("break")) {
                    String PlayerCount = DataManager.getConfig().getString("main.players." + uniqueId);
                    player.sendMessage("You have broken " + EventInfo.get(1).toLowerCase().replace("_", " ") + ": " + PlayerCount);
                    return true;
                }
                else if(EventInfo.get(0).equalsIgnoreCase("place")) {
                    String PlayerCount = DataManager.getConfig().getString("main.players." + uniqueId);
                    player.sendMessage("You have placed " + EventInfo.get(1).toLowerCase().replace("_", " ") + ": " + PlayerCount);
                    return true;
                }
            }
            player.sendMessage("Participate in an event to see your count!");
            return true;
        }
        else {
            player.sendMessage("No event active or past events!");
        }
        return true;
    }
}

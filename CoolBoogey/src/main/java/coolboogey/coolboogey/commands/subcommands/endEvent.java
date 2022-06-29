package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.CoolBoogey;
import coolboogey.coolboogey.files.DataManager;
import coolboogey.coolboogey.system.timer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class endEvent {
    public static boolean endEvent(Player player) {
        if(DataManager.getConfig().contains("main.event")) {
            DataManager.getConfig().set("main.event", null);
            DataManager.save();
            HandlerList.unregisterAll(JavaPlugin.getPlugin(CoolBoogey.class));
            timer.onEnd();
            player.sendMessage("§6§khi §c§lEvent Ended! §r§6§khi\n§eDo /boogey newEvent to §lstart§r§e a new one");
            return true;
        }
        player.sendMessage("§6§khi §c§lStart an Event First! §r§6§khi");
        return true;
    }

}

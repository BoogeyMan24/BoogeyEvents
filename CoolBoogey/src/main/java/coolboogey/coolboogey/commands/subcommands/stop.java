package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.files.DataManager;
import coolboogey.coolboogey.system.timer;
import org.bukkit.entity.Player;

public class stop {
    public static boolean stop(Player player) {
        if(DataManager.getConfig().contains("main.event")) {
            if (timer.timerOn) {
                timer.onEnd();
                player.sendMessage("§6§khi §a§lTimer Stopped! §r§6§khi\n§eDo /boogey endEvent to stop the §lwhole§r§e event");
                return true;
            }
            player.sendMessage("§6§khi §c§lTimer Already Stopped! §r§6§khi");
            return true;
        }
        player.sendMessage("§6§khi §c§lStart an Event First! §r§6§khi");
        return true;
    }
}

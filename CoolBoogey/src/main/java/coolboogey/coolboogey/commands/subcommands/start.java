package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.files.DataManager;
import coolboogey.coolboogey.system.timer;
import org.bukkit.entity.Player;

public class start {
    public static boolean start(Player player) {
        if(DataManager.getConfig().contains("main.event")) {
            if (!timer.timerOn) {
                timer.onStart();
                player.sendMessage("§6§khi §a§lTimer Started! §r§6§khi");
                return true;
            }
            player.sendMessage("§6§khi §c§lTimer Already Started! §r§6§khi");
            return true;
        }
        player.sendMessage("§6§khi §c§lStart an Event First! §r§6§khi");
        return true;
    }
}

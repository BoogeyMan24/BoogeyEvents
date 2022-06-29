package coolboogey.coolboogey.commands;

import coolboogey.coolboogey.commands.subcommands.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class boogey implements CommandExecutor {

    public static String noice;

    @SuppressWarnings("NullableProblems")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        noice = null;
        if(label.equalsIgnoreCase("boogey")) {
            Player player = (Player) sender;

            if (args[0].equalsIgnoreCase("newEvent") || args[0].equalsIgnoreCase("new")) {
                newEvent.newEvent(player, args);
                return true;
            }
            else if(args[0].equalsIgnoreCase("endEvent")) {
                endEvent.endEvent(player);
                return true;
            }
            else if(args[0].equalsIgnoreCase("stop")) {
                stop.stop(player);
                return true;
            }
            else if(args[0].equalsIgnoreCase("start")) {
                start.start(player);
                return true;
            }
            else if(args[0].equalsIgnoreCase("count") || args[0].equalsIgnoreCase("ct")) {
                count.count(player, args);
                return true;
            }
            else if(args[0].equalsIgnoreCase("leaderboard") || args[0].equalsIgnoreCase("lb")) {
                leaderboard.leaderboard(player);
                return true;
            }

            player.sendMessage("§c§lInvalid Action!\n§r§eUse either {newEvet, endEvent, stop, start}");
            return true;
        }
        return false;
    }
}

package coolboogey.coolboogey.commands;

import coolboogey.coolboogey.CoolBoogey;
import coolboogey.coolboogey.commands.subcommands.newEvent;
import coolboogey.coolboogey.files.DataManager;
import coolboogey.coolboogey.system.onBreak;
import coolboogey.coolboogey.system.onPlace;
import coolboogey.coolboogey.system.timer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class startEvent implements CommandExecutor {
    public static List<String> EventInfo = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length == 5) {
            if(args[4].equals(newEvent.noice)) {
                EventInfo.clear();
                EventInfo.add(args[0]);
                EventInfo.add(args[1]);
                EventInfo.add(String.valueOf(parseInt(args[2]) / 1000));
                EventInfo.add(args[3]);
                EventInfo.add("0");

                DataManager.getConfig().set("main.event", EventInfo);
                DataManager.getConfig().set("main.players", null);
                DataManager.save();
                timer.onStart();
                if(args[0].equalsIgnoreCase("break")) {
                    new onBreak(JavaPlugin.getPlugin(CoolBoogey.class));
                }
                if(args[0].equalsIgnoreCase("place")) {
                    new onPlace(JavaPlugin.getPlugin(CoolBoogey.class));
                }
                player.sendMessage("§6§khi §a§lEvent Started! §r§6§khi");
                newEvent.noice = newEvent.NewNoice();
                return true;
            }
            return true;
        }
        return false;
    }
}

package coolboogey.coolboogey.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class boogeyTab implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1) {
            List<String> arguments = new ArrayList<>();

            arguments.add("newEvent");
            arguments.add("endEvent");
            arguments.add("stop");
            arguments.add("start");
            arguments.add("count");
            arguments.add("leaderboard");

            return TabFilter(arguments, args, 0);
        }
        if(args.length == 2) {
            List<String> arguments = new ArrayList<>();

            arguments.add("break");
            arguments.add("kill");
            arguments.add("place");

            return TabFilter(arguments, args, 1);
        }
        if(args.length == 3) {
            List<String> arguments = new ArrayList<>();

            arguments.add("wip!-type-a-block/entity");

            return TabFilter(arguments, args, 2);
        }
        if(args.length == 4) {
            List<String> arguments = new ArrayList<>();

            arguments.add("1d");
            arguments.add("7d");
            arguments.add("14d");
            arguments.add("1m");
            arguments.add("3m");

            return TabFilter(arguments, args, 3);
        }



        return null;
    }

    public static List<String> TabFilter(List<String> arguments, String[] args, int count) {
        List<String> result = new ArrayList<String>();

        for(String a : arguments) {
            if(a.toLowerCase().startsWith(args[count].toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }
}

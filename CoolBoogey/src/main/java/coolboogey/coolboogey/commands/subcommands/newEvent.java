package coolboogey.coolboogey.commands.subcommands;

import coolboogey.coolboogey.files.DataManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static java.lang.Integer.parseInt;

public class newEvent {
    public static String noice;

    public static boolean newEvent(Player player, String[] args) {
        if(DataManager.getConfig().get("main.event") != null) {
            player.sendMessage("§c§lOngoing Event!\n§r§eOnly one event can be active at a time");
            return true;
        }
        if (args[1].equalsIgnoreCase("kill")) {
            player.sendMessage("sry not implemented yet :((((");
        }
        else if (args[1].equalsIgnoreCase("break") || args[1].equalsIgnoreCase("place")) {
            Material block = Material.getMaterial(args[2].toUpperCase());
            if (block != null) {
                if (args[3].endsWith("d") || args[3].endsWith("D")) {
                    long start = System.currentTimeMillis();
                    long duration = parseInt(args[3].substring(0, args[3].length() - 1)) * 86400000L;

                    player.sendMessage("§6§khello §a§lCheck§r§2 Values and Click §a§lConfirm§r§2 to Start! §r§6§khello\n§6§lStarting new event:\n§r§6Event Type: " + args[1] + "\nBlock: " + args[2] + "\nDuration: " + args[3] + "\n§cIgnore this message if you wish to cancel!");

                    noice = NewNoice();

                    TextComponent message = new TextComponent("[CONFIRM]");
                    message.setColor(ChatColor.GREEN);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/startEvent " + args[1] + " " + block + " " + duration + " " +  start + " " +  noice));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click To Confirm And Start Event!")));
                    player.spigot().sendMessage(message);

                } else if (args[3].endsWith("m") || args[3].endsWith("M")) {
                    long start = System.currentTimeMillis();
                    long duration = parseInt(args[3].substring(0, args[3].length() - 1)) * 2629746000L;

                    player.sendMessage("§6§khello §a§lCheck§r§2 Values and Click §a§lConfirm§r§2 to Start! §r§6§khello\n§6§lStarting new event:\n§r§6Event Type: " + args[1] + "\nBlock: " + args[2] + "\nDuration: " + args[3] + "\n§cIgnore this message if you wish to cancel!");

                    noice = NewNoice();

                    TextComponent message = new TextComponent("[CONFIRM]");
                    message.setColor(ChatColor.GREEN);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/startEvent " + args[1] + " " + block + " " + duration + " " + start + " " + noice));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click To Confirm And Start Event!")));
                    player.spigot().sendMessage(message);

                } else {
                    player.sendMessage("§c§lInvalid Duration!\n§r§eUse [int] + 'd' or 'm' for days or months respectively");
                    return true;
                }
                return true;
            }
            TextComponent message = new TextComponent("§c§lInvalid block!\n§r§eMake sure it follows minecraft's naming of blocks/materials!");
            message.setColor(ChatColor.GOLD);
            message.setItalic(true);
            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click To See Block Names!")));
            player.spigot().sendMessage(message);
            return true;
        }
        else {
            player.sendMessage("§c§lInvalid Event Type!\n§r§eThis value must be either {kill, break, place}");
        }
        return true;
    }

    public static String NewNoice() {
        for(int i = 0; i < 50; i++) {
            String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", "/", "]", "[", "{", "}", ".", ",", "-", "_", "=", "(", ")", "@", "#", "$", "%", "^","&", "*", ";", ":", "|", "~"};
            int random = (int)Math.floor(Math.random()*(characters.length));
            if(noice == null) {
                noice = characters[random];
            }
            else {
                noice = String.format("%s%s", noice, characters[random]);
            }
        }
        return noice;
    }
}

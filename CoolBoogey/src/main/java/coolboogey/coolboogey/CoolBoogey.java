package coolboogey.coolboogey;

import coolboogey.coolboogey.commands.boogey;
import coolboogey.coolboogey.commands.boogeyTab;
import coolboogey.coolboogey.commands.startEvent;
import coolboogey.coolboogey.files.DataManager;
import coolboogey.coolboogey.system.onBreak;
import coolboogey.coolboogey.system.onPlace;
import coolboogey.coolboogey.system.timer;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class CoolBoogey extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        timer.timerOn = false;
        DataManager.setup();
        DataManager.getConfig().options().copyDefaults(true);
        DataManager.save();

        if(DataManager.getConfig().contains("main.event")) {
            timer.onStart();
            List<String> EventInfo = DataManager.getConfig().getStringList("main.event");
            String type = EventInfo.get(0);
            if(type.equalsIgnoreCase("break")) {
                new onBreak(this);
            }
            if(type.equalsIgnoreCase("place")) {
                new onPlace(this);
            }
        }

        this.getCommand("boogey").setExecutor(new boogey());
        this.getCommand("boogey").setTabCompleter(new boogeyTab());

        this.getCommand("startEvent").setExecutor(new startEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(this);
        timer.onEnd();
    }
}

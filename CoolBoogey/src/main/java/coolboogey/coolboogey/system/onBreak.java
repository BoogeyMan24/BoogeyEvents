package coolboogey.coolboogey.system;

import coolboogey.coolboogey.CoolBoogey;
import coolboogey.coolboogey.files.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class onBreak implements Listener {
    public onBreak(CoolBoogey plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        List<String> EventInfo = DataManager.getConfig().getStringList("main.event");
        String mat = EventInfo.get(1);
        if(block.getType() != Material.getMaterial(mat.toUpperCase())) {
            return;
        }

        scoreUpdater.UpdateScore(event.getPlayer(), 1);
    }

    public void end() {
        BlockBreakEvent.getHandlerList().unregister(onBreak.this);
    }
}

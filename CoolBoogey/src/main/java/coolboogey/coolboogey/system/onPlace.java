package coolboogey.coolboogey.system;

import coolboogey.coolboogey.CoolBoogey;
import coolboogey.coolboogey.files.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class onPlace implements Listener {
    public onPlace(CoolBoogey plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();

        List<String> EventInfo = DataManager.getConfig().getStringList("main.event");
        String mat = EventInfo.get(1);
        if(block.getType() != Material.getMaterial(mat.toUpperCase())) {
            return;
        }

        scoreUpdater.UpdateScore(event.getPlayer(), 1);
    }

    public void end() {
        BlockPlaceEvent.getHandlerList().unregister(onPlace.this);
    }
}

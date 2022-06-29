package coolboogey.coolboogey.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataManager {
    private static File file;
    private static FileConfiguration configFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CoolBoogey").getDataFolder(), "data.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //uwu
            }
        }

        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {
        return configFile;
    }

    public static void save() {
        try {
            configFile.save(file);
        } catch (IOException e) {
            //bruh
        }
    }

    public static void reload() {
        configFile = YamlConfiguration.loadConfiguration(file);
    }

}
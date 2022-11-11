package me.zombie_striker.qualityarmory;

import me.zombie_striker.qualityarmory.api.QualityArmory;
import org.bukkit.plugin.java.JavaPlugin;

public final class QualityArmoryPlugin extends JavaPlugin {



    @Override
    public void onEnable() {
        new QualityArmory(this).init();
    }

    @Override
    public void onDisable() {
        QualityArmory.disable();
    }
}

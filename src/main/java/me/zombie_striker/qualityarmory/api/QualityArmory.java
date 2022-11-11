package me.zombie_striker.qualityarmory.api;

import me.zombie_striker.qualityarmory.QualityArmoryPlugin;
import me.zombie_striker.qualityarmory.data.Bullet;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.LinkedList;
import java.util.List;

public class QualityArmory {

    private static final List<Bullet> bullets = new LinkedList<>();

    private static QualityArmory inst;
    private static QualityArmoryPlugin plugin;

    public static void disable() {
        inst=null;
        plugin=null;
    }

    public QualityArmory getInstance() {
        return inst;
    }

    public void init() {
        new BukkitRunnable(){
            public void run(){
                for(Bullet b : new LinkedList<>(bullets)) {
                    b.tick();
                    if(!b.isValid()){
                        bullets.remove(b);
                    }
                }
            }
        }.runTaskTimer(plugin,1,1);
    }
    public QualityArmory(QualityArmoryPlugin plugin){
        QualityArmory.plugin = plugin;
        QualityArmory.inst = this;
    }

    public static void createBullet(Location location, Vector direction, double speed, float damage){
        Bullet b = new Bullet(location,direction.normalize(),speed,damage);
        bullets.add(b);
    }

}

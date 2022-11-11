package me.zombie_striker.qualityarmory.data;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Bullet {

    private Player shooter;
    private float damage;
    private Location location;
    private Vector normalizedVelocity;
    private double distancePerTick;
    private boolean valid = true;

    public Bullet(Location location, Vector normalizedVelocity, double distancePerTick, float damage) {
        this(location, normalizedVelocity, distancePerTick, damage, null);
    }

    public Bullet(Location location, Vector normalizedVelocity, double distancePerTick, float damage, Player shooter) {
        this.damage = damage;
        this.normalizedVelocity = normalizedVelocity;
        this.location = location;
        this.distancePerTick = -distancePerTick;
        this.shooter = shooter;
    }

    public Location getLocation() {
        return location;
    }

    public double getDistancePerTick() {
        return distancePerTick;
    }

    public float getDamage() {
        return damage;
    }

    public Player getShooter() {
        return shooter;
    }

    public Vector getNormalizedVelocity() {
        return normalizedVelocity;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setDistancePerTick(double distancePerTick) {
        this.distancePerTick = distancePerTick;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setNormalizedVelocity(Vector normalizedVelocity) {
        this.normalizedVelocity = normalizedVelocity;
    }

    public void setShooter(Player shooter) {
        this.shooter = shooter;
    }

    public void tick() {
        Block prev = null;
        for(double i = 0.0; i < distancePerTick;i+=0.1){
            location.add(normalizedVelocity);
            if(prev!=null&&prev==location.getBlock())
                continue;
            prev = location.getBlock();
            for(Entity e : location.getNearbyEntities(1,1,1)){
                if(e instanceof Damageable){
                    if(shooter!=null) {
                        ((Damageable) e).damage(damage, shooter);
                    }else{
                        ((Damageable) e).damage(damage);
                    }
                    setValid(false);
                }
            }
            if(!isValid()){
                break;
            }
        }
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        if(!valid)
            return false;
        if(location.getBlock().getType().isSolid())
            return false;
        return true;
        //TODO: Add ability to go through certain blocks.
    }
}

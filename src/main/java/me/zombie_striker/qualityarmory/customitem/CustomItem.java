package me.zombie_striker.qualityarmory.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomItem {

    private int modeldata;
    private Material material;

    public CustomItem(Material base, int modeldata){
        this.material = base;
        this.modeldata = modeldata;
    }

    public int getModeldata() {
        return modeldata;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isCustomItem(ItemStack is){
        if(is==null)
            return false;
        if(!is.hasItemMeta())
            return false;
        if(is.getType()==material&&is.getItemMeta().getCustomModelData()==modeldata)
            return true;
        return false;
    }
}

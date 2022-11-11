package me.zombie_striker.qualityarmory.data;

import me.zombie_striker.qualityarmory.customitem.CustomItem;

public class AmmoType {

    private final String name;
    private String displayname;
    private CustomItem customItem;

    public AmmoType(String name, String displayname, CustomItem customItem){
        this.name = name;
        this.displayname = displayname;
        this.customItem = customItem;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getName() {
        return name;
    }

    public CustomItem getCustomItem() {
        return customItem;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public void setCustomItem(CustomItem customItem) {
        this.customItem = customItem;
    }
}

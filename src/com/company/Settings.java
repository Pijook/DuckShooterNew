package com.company;

import com.company.option.Resolution;

public class Settings {

    //Windows Settings
    public static String title = "Ducks!";
    public static Resolution baseResolution = new Resolution(1280, 720);
    public static Resolution currentResolution = new Resolution(1280, 720);
    public static int speed = 60;
    public static int volumeLevel = 100;

    //
    public static int lives = 10;
    public static int baseDamage = 1;
    public static int baseAmmo = 5;

    public static int ammoUpgradeCost = 500;
    public static int damageUpgradeCost = 1000;

}

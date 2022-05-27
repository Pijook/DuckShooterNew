package com.company;

import com.company.option.Resolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Settings {

    //Windows Settings
    private static String title = "Ducks!";
    private static Resolution baseResolution = new Resolution(1280, 720);
    private static Resolution currentResolution = new Resolution(1280, 720);
    private static int speed = 60;
    private static int volumeLevel = 100;

    //
    private static int lives = 10;
    private static int baseDamage = 1;
    private static int baseAmmo = 5;

    private static int ammoUpgradeCost = 500;
    private static int damageUpgradeCost = 1000;

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Settings.title = title;
    }

    public static Resolution getBaseResolution() {
        return baseResolution;
    }

    public static void setBaseResolution(Resolution baseResolution) {
        Settings.baseResolution = baseResolution;
    }

    public static Resolution getCurrentResolution() {
        return currentResolution;
    }

    public static void setCurrentResolution(Resolution currentResolution) {
        Settings.currentResolution = currentResolution;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Settings.speed = speed;
    }

    public static int getVolumeLevel() {
        return volumeLevel;
    }

    public static void setVolumeLevel(int volumeLevel) {
        Settings.volumeLevel = volumeLevel;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Settings.lives = lives;
    }

    public static int getBaseDamage() {
        return baseDamage;
    }

    public static void setBaseDamage(int baseDamage) {
        Settings.baseDamage = baseDamage;
    }

    public static int getBaseAmmo() {
        return baseAmmo;
    }

    public static void setBaseAmmo(int baseAmmo) {
        Settings.baseAmmo = baseAmmo;
    }

    public static int getAmmoUpgradeCost() {
        return ammoUpgradeCost;
    }

    public static void setAmmoUpgradeCost(int ammoUpgradeCost) {
        Settings.ammoUpgradeCost = ammoUpgradeCost;
    }

    public static int getDamageUpgradeCost() {
        return damageUpgradeCost;
    }

    public static void setDamageUpgradeCost(int damageUpgradeCost) {
        Settings.damageUpgradeCost = damageUpgradeCost;
    }
}

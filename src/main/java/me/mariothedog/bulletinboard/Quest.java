package me.mariothedog.bulletinboard;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Quest extends ItemStack
{
    public Quest(String title, String itemWanted, int amount, String background, String requiredSkill, int levelSkill, int recommendedLevel, int moneyReward)
    {
        this.setType(Material.PAPER);
        this.setAmount(1);
        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(title);

        ArrayList<String> questLore = new ArrayList<String>();

        questLore.add(String.format("%sQuest: 0/%s %s", ChatColor.AQUA, amount, itemWanted));

        for (String lore : background.split("\n"))
        {
            questLore.add(lore);
        }

        questLore.add(String.format("%sRequirement: Lvl %s %s", ChatColor.GOLD, levelSkill, requiredSkill));
        questLore.add(String.format("%sRecommended: Lvl %s", ChatColor.GREEN, recommendedLevel));
        questLore.add(String.format("%sReward: %s Money", ChatColor.RED, moneyReward));

        meta.setLore(questLore);
        this.setItemMeta(meta);
    }
}
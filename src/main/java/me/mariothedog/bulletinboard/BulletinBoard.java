package me.mariothedog.bulletinboard;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class BulletinBoard extends JavaPlugin implements Listener
{
    public Inventory inv = Bukkit.getServer().createInventory(null, 54, "Bulletin Board");

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        Quest questPage = new Quest("Fur for Grandma",
                "Fur", 8,
                "I need fur for my grandma,\nshe wanted to make a sweater,\nbut they're out of stock and\nI'm afraid of going outside centoria.\nCan you find me some?",
                "Shearer",
                3,
                1,
                50);
        inv.addItem(questPage);
    }

    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.OAK_SIGN)
        {
            player.openInventory(inv);
        }
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent event)
    {
        if (event.getInventory().equals(inv))
        {
            event.setCancelled(true);
        }
    }
}
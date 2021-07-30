package co.porami.noelytra;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class OnGlide implements Listener {

    @EventHandler
    public void onGlide(EntityToggleGlideEvent event) {
        if (!(Main.elytraEnabled)) {
            event.setCancelled(true);

            Entity entity = event.getEntity();
            if (entity instanceof Player) {
                Player player = (Player) entity;
                player.setGliding(false);
                PlayerInventory inv = player.getInventory();

                player.sendMessage((ChatColor.RED + "[NoElytra]") + (ChatColor.WHITE + " Elytra are disabled on this server!"));

                if ((inv.getChestplate() != null) && (inv.getChestplate().getType() == Material.ELYTRA)) {
                    ItemStack elytra = inv.getChestplate();
                    inv.setChestplate(null);

                    // if inventory full. spawn item on player
                    if (inv.firstEmpty() != -1) {
                        inv.addItem(elytra);
                    } else {
                        player.getWorld().dropItemNaturally(player.getLocation(), elytra);
                        player.updateInventory();
                    }
                }

            }
        }
    }
}

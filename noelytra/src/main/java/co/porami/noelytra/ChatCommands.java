package co.porami.noelytra;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (((sender instanceof Player) && (sender.isOp())) || (sender instanceof ConsoleCommandSender)) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("elytra")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("enabled")) {
                        Main.elytraEnabled = true;
                        Main.data.getConfig().set("elytraEnabled", true);
                        Main.data.saveConfig();
                    } else if (args[0].equalsIgnoreCase("disabled")) {
                        Main.elytraEnabled = false;
                        Main.data.getConfig().set("elytraEnabled", false);
                        Main.data.saveConfig();
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Argument 1 must be enabled or disabled! Example:\n/elytra enabled");
                    return false;
                }
            }

            return true;
        }

        return true;
    }
}

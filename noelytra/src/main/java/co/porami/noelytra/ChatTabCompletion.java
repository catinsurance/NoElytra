package co.porami.noelytra;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ChatTabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
         if (args.length == 1) {
            List<String> booleans = new ArrayList<>();
            booleans.add("enabled");
            booleans.add("disabled");
            return booleans;
        }

         return null;
    }
}
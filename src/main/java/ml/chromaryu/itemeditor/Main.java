package ml.chromaryu.itemeditor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by chroma on 16/03/31.
 */
// Stream coding. No mic today/ Sorry!
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Plugin successfully loaded!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Plugin successfully disabled!");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("itemedit")) {
                if (args.length > 1) {
                    if (args[0].equalsIgnoreCase("name")) {
                        if (args.length == 2) {
                            Player p = (Player) sender; // get Sender as Player
                            ItemStack i = p.getItemInHand(); // it Edits holding item. So I'll get holding item.
                            ItemMeta im = i.getItemMeta(); // get ItemMeta
                            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[1])); // Replace & to separator. and set im
                            i.setItemMeta(im); // set meta value
                            return true; // End Command and see what happens.
                        } else if (args.length < 2) {
                            sender.sendMessage("Too less augments!");
                            // not args is 2.
                            // i++
                            // ++i
                            // +ii

                        } else {
                            sender.sendMessage("Too few augments!");
                            // args is less than 1. But it will not happen.
                        }
                    }
                    if(args[0].equalsIgnoreCase("enchant") || args[0].equalsIgnoreCase("ench")) {
                        if(args.length == 3) {
                            Player p = (Player) sender;
                            ItemStack i = p.getItemInHand();
                            Enchantment En = Enchantment.getByName(args[1]);
                            int lv;
                            try {
                                lv = Integer.parseInt(args[2]);
                            } catch(NumberFormatException e) {
                                sender.sendMessage("Level must be Integer!");
                                return false;
                            }
                            i.addUnsafeEnchantment(En,lv);
                        }
                    }
                } else {
                    sender.sendMessage("No Job Specified"); // No job. because just typed /itemedit
                }
            }
        }
        return false;
    }
}

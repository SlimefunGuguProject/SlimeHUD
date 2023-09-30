package io.github.schntgaispock.slimehud.command;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.slimehud.SlimeHUD;
import io.github.schntgaispock.slimehud.waila.PlayerWAILA;
import io.github.schntgaispock.slimehud.waila.WAILAManager;

/**
 * Functionality for the '/slimehud'command
 */
public class SlimeHUDCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sendInfo(player);
                return true;
            }

            UUID uuid = player.getUniqueId();

            // May add more to the command in the future
            switch (args[0]) {
                case "toggle":
                    if (!player.hasPermission("slimehud.togglewaila")) {
                        player.sendMessage("§a§lSlimeHUD§7> §c你没有权限切换 WAILA HUD！");
                        return true;
                    }
                    if (SlimeHUD.getInstance().getConfig().getBoolean("waila.disabled", false)) {
                        player.sendMessage("§a§lSlimeHUD§7> §cWAILA HUD 被禁用了！");
                        return true;
                    }
                    if (SlimeHUD.getInstance().getConfig().getList("waila.disabled-in", Collections.EMPTY_LIST).contains(player.getWorld().getName())) {
                        player.sendMessage("§a§lSlimeHUD§7> §cWAILA HUD 在当前世界被禁用了！");
                        return true;
                    }
                    boolean wailaOn = SlimeHUD.getInstance().getPlayerData().getBoolean(uuid + ".waila", true);
                    SlimeHUD.getInstance().getPlayerData().set(uuid + ".waila", !wailaOn);

                    Map<UUID, PlayerWAILA> wailas = WAILAManager.getInstance().getWailas();
                    wailas.get(uuid).setPaused(wailaOn);

                    SlimeHUD.getInstance().getPlayerData().save();
                    player.sendMessage("§a§lSlimeHUD§7> HUD 已切换为 " + (wailaOn ? "§c关闭" : "§a开启"));
                    return true;
            
                default:
                    break;
            }
        }

        return false;
    }

    private void sendInfo(Player player) {
        player.sendMessage(
            "",
            "§a§lSlimeHUD §7- §2Version " + SlimeHUD.getInstance().getPluginVersion(),
            "§7------",
            "§a§lWiki §7- §2https://schn.pages.dev/slimehud",
            "§a§lIssues §7- §2https://github.com/SchnTgaiSpock/SlimeHUD/issues",
            ""
        );
    }
    
}

package fr.denoria.api.gameapi.utils.i18n.messages;

import fr.denoria.api.gameapi.players.DenoriaPlayer;
import fr.denoria.api.gameapi.utils.i18n.TranslatableString;
import fr.denoria.api.gameapi.utils.i18n.TranslatableWord;
import fr.denoria.api.gameapi.utils.i18n.Word;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class GameMessages {
    /*public static TranslatableString deathEventMessage(FightingDeathEvent e) {
        if(e.getKiller().getType() == EntityType.PLAYER){
            return new TranslatableString("deathmessages.pvp." + e.getLastDamageCause().name().toLowerCase(),
                    e.getPlayer().getTabGroupPrefix().get(e.getPlayer())[0] + e.getPlayer().getName(),
                    ((DenoriaPlayer) ((Player) e.getKiller())).getTabGroupPrefix().get(e.getPlayer())[0] + e.getKiller().getName());
        } else {
            return new TranslatableString("deathmessages.pve." + e.getLastDamageCause().name().toLowerCase(),
                    new TranslatableWord("entities." + e.getKiller().getType().name().toLowerCase(), false,
                            Word.WordDeterminant.UNDEFINED));
        }

    }

    public static TranslatableString deathEventMessage(NormalDeathEvent e) {
        return new TranslatableString("deathmessages.normal." + e.getLastDamageCause().name().toLowerCase(),
                e.getPlayer().getTabGroupPrefix().get(e.getPlayer())[0] + e.getPlayer().getName());
    }
    /**
     * Lorsqu'un spectateur s'éloigne, le message qui lui est affiché. Utile
     * uniquement pour l'API.
     *
     * @return Le message
     */
    public static TranslatableString doNotGoTooFarWhenSpectator() {
        return new TranslatableString("game.spectator.toofar");
    }

    /**
     * Lorsqu'un un joueur join, récupère le message de join
     *
     * @param name
     *            Le nom du jeu ou serveur.
     * @param player
     *            Le nom du joueur
     * @param current
     *            Le nombre de joueurs connectés
     * @param max
     *            Le nombre maximum de joueurs connectés.
     * @return Le message
     */
    public static TranslatableString joinMessage(String name, String player, int current, int max) {
        return new TranslatableString("game.join", name, player, current, max);
    }

    /**
     * Lorsqu'un un joueur quitte, on récupère le message de quit
     *
     * @param name
     *            Le nom du jeu ou serveur.
     * @param player
     *            Le nom du joueur
     * @param current
     *            Le nombre de joueurs connectés
     * @param max
     *            Le nombre maximum de joueurs connectés.
     * @return Le message
     */
    public static TranslatableString quitMessage(String name, String player, int current, int max) {
        return new TranslatableString("game.quit", name, player, current - 1, max);
    }

    public static TranslatableWord material(Material material, boolean plural, Word.WordDeterminant determinant) {
        return new TranslatableWord("materials." + material.name().toLowerCase(), plural, determinant);
    }

    public static TranslatableString missingPlayersActionBar(int players) {
        return new TranslatableString("game.missingplayers", players);
    }

    /**
     * Le temps avant que le joueur respawn (title)
     *
     * @return La key du title
     */
    public static String respawnTitleKey() {
        return "game.respawnIn-title";
    }

    public static TranslatableString startIn(int time, ChatColor color) {
        return new TranslatableString("game.startin.title", time, color.getChar());
    }

    public static TranslatableString startInActionBar(int time, ChatColor color) {
        return new TranslatableString("game.startin.actionbar", time, color.getChar());
    }
}

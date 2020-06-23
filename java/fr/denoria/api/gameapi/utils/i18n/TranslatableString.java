package fr.denoria.api.gameapi.utils.i18n;

import fr.denoria.api.API;
import fr.denoria.api.gameapi.players.DenoriaPlayer;
import org.bukkit.command.CommandSender;

public class TranslatableString {

    private String key;
    private String overrideString;
    private Object[] objects;

    /**
     * Crée une nouvelle chaîne traduisible
     *
     * @param key
     *            La key
     * @param objects
     *            Les arguments
     */
    public TranslatableString(String key, Object... objects) {
        this.key = key;
        this.objects = objects;
    }

    /**
     * Envoit le message à tous les joueurs
     */
    public void broadcast() {
        API.i18n().broadcast(key, objects);
    }

    /**
     * Récupère le message sur plusieurs lignes
     *
     * @param player
     *            Le joueur (pour avoir la langue)
     * @return Le message
     */
    /*public String[] get(DenoriaPlayer player) {
        if (getOverrideString() != null)
        {
            return new String[] { getOverrideString() };
        }
        return get(player.getPlayerData().getLocale());
    }*/

    /**
     * Récupère le message sur plusieurs lignes
     *
     * @param locale
     *            La langue
     * @return Le message
     */
    public String[] get(Locale locale) {
        if (getOverrideString() != null)
        {
            return new String[] { getOverrideString() };
        }
        return API.i18n().get(locale, key, objects);
    }

    /**
     * Récupère la première ligne du message
     *
     * @param player
     *            Le joueur (pour la langue)
     * @return La ligne
     */
    /*public String getAsLine(DenoriaPlayer player) {
        return getAsLine(player.getPlayerData().getLocale());
    }*/

    /**
     * Récupère la première ligne du message
     *
     * @param player
     *            Le joueur (pour la langue)
     * @return La ligne
     */
    public String getAsLine(CommandSender sender) {
        if (sender instanceof DenoriaPlayer)
            return getAsLine((DenoriaPlayer) sender);

        return getAsLine(Locale.ENGLISH_US);
    }

    /**
     * Récupère la première ligne du message
     *
     * @param locale
     *            La langue
     * @return La ligne
     */
    public String getAsLine(Locale locale) {
        if (getOverrideString() != null)
        {
            return getOverrideString();
        }
        return API.i18n().get(locale, key, objects)[0];
    }

    /**
     * Envoit le message à un command sender
     *
     * @param sender
     *            Le sender
     */
    public void send(CommandSender sender) {
        API.i18n().sendMessage(sender, key, objects);
    }

    public Object[] getObjects() {
        return objects;
    }

    public String getKey() {
        return key;
    }

    public String getOverrideString() {
        return overrideString;
    }

}

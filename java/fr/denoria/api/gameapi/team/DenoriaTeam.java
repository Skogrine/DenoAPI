package fr.denoria.api.gameapi.team;

import fr.denoria.api.API;
import fr.denoria.api.gameapi.players.DenoriaPlayer;
import fr.denoria.api.gameapi.utils.i18n.Locale;
import fr.denoria.api.gameapi.utils.i18n.TranslatableString;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import java.util.Collection;
import java.util.UUID;

public interface DenoriaTeam {

    /**
     * Créé l'item de join pour la team
     *
     * @param locale
     *            La langue
     * @return L'item
     */
    //public ItemStackExtra createJoinItem(Locale locale);

    /**
     * Récupère la couleur (autre) de l'équipe.
     *
     * @return La couleur.
     */
    public Color geNormalColor();

    /**
     * Récupère la string (i18n) du nom dans le chat (pour le mettre dans une
     * phrase) de la team
     *
     * @return La string
     */
    public TranslatableString getChatName();

    /**
     * Récupère la string (i18n) du préfixe dans le chat de la team (quand les
     * joueurs parlent)
     *
     * @return La string
     */
    public TranslatableString getChatPrefix();

    /**
     * Récupère la couleur (chat) de l'équipe.
     *
     * @return La couleur (chat).
     */
    public ChatColor getColor();

    /**
     * Récupère la couleur (laine) de l'équipe.
     *
     * @return La couleur (laine).
     */
    public DyeColor getDyeColor();

    /**
     * Récupère le nom interne de la team
     *
     * @return Le nom interne.
     */
    public String getKey();

    /**
     * Récupère le nombre maximum de joueurs dans la team.
     *
     * @return Le nombre maximum.
     */
    public int getMaxPlayers();

    /**
     * Récupère les joueurs de la team étant connectés
     *
     * @return Une collection
     */
    public Collection<DenoriaPlayer> getOnlinePlayers();

    /**
     * Récupère les noms des joueurs de la team étant connectés
     *
     * @return Une collection
     */
    public Collection<String> getOnlinePlayersName();

    /**
     * Récupère les joueurs présent lors du démarrage
     *
     * @return Les joueurs
     */
    public Collection<UUID> getPlayersAtStart();

    /**
     * Récupère les joueurs présent lors du démarrage
     *
     * @return Les joueurs
     */
    public Collection<String> getPlayersNameAtStart();

    /**
     * Retourne la string (i18n) du préfixe dans la tabulation de la Team
     *
     * @param color
     *            La couleur (verte ou rouge) pour savoir si la team est alliée
     *            ou non
     * @return La string
     */
    public TranslatableString getTabPrefix(ChatColor color);

    /**
     * Permet à un BadblockPlayer de rejoindre la team.
     *
     * @param player
     *            Le player
     * @param reason
     *            La raison du join
     * @return Si l'opération est un succès
     */
    //public boolean joinTeam(DenoriaPlayer player, JoinReason reason);

    /**
     * Fait quitter la team à un BadblockPlayer.
     *
     * @param player
     *            Le player
     */
    public void leaveTeam(DenoriaPlayer player);

    /**
     * Récupère le nombre de joueurs dans la team connectés sur le serveur.
     *
     * @return Le nombre de joueurs.
     */
    public int playersCurrentlyOnline();

    /**
     * Définit le nombre maximum de joueurs dans la team.
     *
     * @param maxPlayers
     *            Le nombre maximum.
     */
    public void setMaxPlayers(int maxPlayers);

    /**
     * Récupère les données ingame de la team. Attention, la classe fournie doit
     * ętre celle donnée dans le onEnable grâçe à
     * {@link API#registerTeams(int, Class, org.bukkit.configuration.ConfigurationSection)}
     *
     * @param clazz
     *            La classe implémentant TeamData
     * @return Les données joueurs (ou null si la classe donnée n'est pas
     *         correcte)
     */
    //public <T extends TeamData> T teamData(Class<T> clazz);

    /**
     * Retourne si l'équipe ne peut plus ętre jouée (éliminiation..)
     * @return
     */
    public boolean isDead();

    /**
     * "Tuer" une équipe
     */
    public void die();
}

package fr.denoria.api.gameapi.players;

import fr.denoria.api.gameapi.team.DenoriaTeam;
import fr.denoria.api.gameapi.utils.i18n.TranslatableString;

import java.util.UUID;

public interface DenoriaPlayerData {

    /**
     * Récupčre le préfixe (par exemple [Admin]) pour afficher le nom du groupe
     * du joueur
     *
     * @return Le préfixe
     */
    public TranslatableString getGroupPrefix();

    /**
     * Récupčre le suffixe (par exemple &4) pour afficher le nom du groupe du joueur
     * @return Le suffixe
     */
    public TranslatableString getGroupSuffix();

    /**
     * Récupčre le pseudo du joueur
     *
     * @return Le pseudo
     */
    public String getName();

    /**
     * Récupčre les données du joueur. Elles ne seront pas redemandées ŕ Ladder
     * (elles n'ont théoriquement pas changées)
     *
     * @return Les données
     */
    //public PlayerData getPlayerData();

    /**
     * Récupčre le préfixe (par exemple [Admin]) pour afficher le nom du group
     * du joueur en tablist
     *
     * @return Le préfixe
     */
    public TranslatableString getTabGroupPrefix();

    /**
     * Récupčre la team du joueur avant sa déconnection
     *
     * @return La team
     */
    public DenoriaTeam getTeam();

    /**
     * Récupčre l'UUID du joueur
     *
     * @return L'UUID
     */
    public UUID getUniqueId();

    /**
     * Récupère les données ingame du joueur, avant sa déconnection. Attention,
     * la classe fournie doit avoir un constructeur sans arguments.
     *
     * @param clazz
     *            La classe implémentant InGameData
     * @return Les données joueurs (ou null si la classe donnée n'est pas
     *         correcte)
     */
    //public <T extends InGameData> T inGameData(Class<T> clazz);

    /**
     * Définit la team du joueur. A ne pas utiliser pour la changer réellement,
     * simplement une valeur de stockage.
     *
     * @param team
     *            La team
     */
    public void setTeam(DenoriaTeam team);

}

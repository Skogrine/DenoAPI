package fr.denoria.api.gameapi.players;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface DenoriaPlayer extends Player, DenoriaPlayerData {

    public static final int VERSION_1_8    = 47;
    public static final int VERSION_1_9    = 107;
    public static final int VERSION_1_9_1  = 108;
    public static final int VERSION_1_9_2  = 109;
    public static final int VERSION_1_10   = 210;

    /**

     * Représente les différents modes de jeux possibles pour un joueur Denoria

     * @author Skogrin
     */
    public static enum DenoriaMode{
        /**
         * Représente un joueur 'normal' (entrain de jouer ou au lobby)
         */
        PLAYER(),
        /**
         * Représente un joueur attendant en spectateur d'ètre respawn
         */
        RESPAWNING(),
        /**
         * Représente un joueur observant la partie sans y interférer
         */
        SPECTATOR();
    }
    /**
     * Représente les permissions basiques des Mini-Jeux, pour une gestion plus simple
     *
     * @author Skogrin
     */
    public static enum GamePermission{
        PLAYER(null),
        VIP("Denoria.vip"),
        YT("Denoria.yt"),
        STAFF("denoria.staff"),
        MODERATOR("denoria.mod"),
        ADMIN("Denoria.admin");
        private final String permission;

        private GamePermission(String permission){
            this.permission = permission;
        }

        public String getPermission() {
            return permission;
        }
    }

    /**
     * Vérifie si le joueur peut build
     *
     * @return Si le joueur peut build
     */
    public boolean canBuild();

    /**
     * Vérifie si le joueur peut build instantanément
     *
     * @return Si le joueur peut build instantanément
     */
    public boolean canInstantlyBuild();

    /**
     * Vérifie si le joueur est en ligne
     * @return si le joueur est en ligne
     */
    public boolean isOnlineMode();

    /**
     * Save and update online mode
     */
    public void saveOnlineMode();

    /**
     * Set the online mode
     * @param onlineMode
     */
    public void setOnlineMode(boolean onlineMode);

    /**

     * Change la dimension affichée par le joueur sans le changer réellement de
     * monde
     *
     * @param world
     *            La nouvelle dimension
     */
    public void changePlayerDimension(World.Environment world);

    /**
     * Clear l'inventaire du joueur (dont l'armure)
     */
    public void clearInventory();

    /**
     * Enlève le title de l'écran du joueur
     */
    public void clearTitle();

    //public void disguise(Disguise disguise);

    /**
     * Remplit la barre de faim du joueur
     */
    public void feed();

    public Object getHandle();

    public Collection<String> getAlternateGroups();

    public DenoriaMode getDenoriaMode();

    //public CustomObjective getCustomObjective();

    /**
     * @deprecated
     */
    public boolean isVisible();

    public Predicate<DenoriaPlayer> getVisiblePredicate();
    public Predicate<DenoriaPlayer> getInvisiblePredicate();

    public boolean isDataFetch();

    public int getVipLevel();

    public boolean hasVipLevel(int level, boolean showErrorMessage);

    public boolean canOnlyJoinWhileWaiting();

    public void setOnlyJoinWhileWaiting(long time);

    public void setLeaves(List<Long> leaves);

    public List<Long> getLeaves();

    public void setPlayerSkin(String skinUrl);

    public void setPlayerSkin(String skinUrl, String capeUrl);

    public void setTextureProperty(String value, String signature);

    //public RankedPlayer getRanked();



}

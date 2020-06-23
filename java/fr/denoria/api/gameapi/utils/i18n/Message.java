package fr.denoria.api.gameapi.utils.i18n;

public interface Message {

    /**
     * Renvoit tous les versions possibles du messages. Si le Message n'est pas
     * alétoire, un seul sera renvoyé.
     *
     * @return La totalité des messages.
     */
    public String[][] getAllMessages();

    /**
     * Renvoit le message 'brute', sans remplacement des paramÄ�tres ou des
     * couleurs. Néanmoins, si le message est aléatoire, en renvoit un au
     * hasard.
     *
     * @return Le message non formatté.
     */
    public String[] getUnformattedMessage();

    /**
     * Vérifie si le message est aléatoire, autrement dit si plusieurs messages
     * ont été configurés et que un sera choisit au hasard.
     */
    public boolean isRandomMessage();

    /**
     * Vérifie si le message utilise le footer (voir
     * {@link Language})
     */
    public boolean useFooter();

    /**
     * Vérifie si le message utilise le header "long" (voir
     * {@link Language})
     */
    public boolean useHeader();

    /**
     * Vérifie si le message utilise le header "court" (voir
     * {@link Language})
     */
    public boolean useShortHeader();

}

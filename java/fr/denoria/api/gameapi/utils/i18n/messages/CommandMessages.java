package fr.denoria.api.gameapi.utils.i18n.messages;

import fr.denoria.api.gameapi.utils.i18n.TranslatableString;

public class CommandMessages {
    /**
     * Lorsqu'un joueur n'a pas la permission d'utilisé une commande.
     *
     * @return Le message
     */
    public static TranslatableString noPermission() {
        return new TranslatableString("commands.nopermission");
    }
}

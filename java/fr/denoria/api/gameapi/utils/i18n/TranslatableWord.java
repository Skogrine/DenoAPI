package fr.denoria.api.gameapi.utils.i18n;

import fr.denoria.api.API;

public class TranslatableWord {
    private String key;
    private boolean plural;
    private Word.WordDeterminant determinant;


    public TranslatableWord(String key, boolean plural, Word.WordDeterminant determinant){
        this.key = key;
        this.plural = plural;
        this.determinant = determinant;
    }
    /**
     * Récupère le mot traduit dans une langue
     *
     * @param locale
     *              la langue
     * @return Le mot
     */
    public String getWord(Locale locale){
        return API.i18n().getWord(locale, key, plural, determinant);
    }

    public String getKey() {
        return key;
    }

    public Word.WordDeterminant getDeterminant() {
        return determinant;
    }

    public boolean isPlural() {
        return plural;
    }
}

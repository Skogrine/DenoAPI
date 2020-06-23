package fr.denoria.api.gameapi.utils.i18n;

public interface Word {

    /**
     * Représente les différents déterminants possible
     *
     * @author LeLanN
     */
    public enum WordDeterminant {
        /**
         * En français un / une / du / de la / des
         */
        UNDEFINED,
        /**
         * En français l'/ le / la / les
         */
        DEFINED,
        /**
         * Le mot, tout simplement :o
         */
        SIMPLE;
    }

    /**
     * Récupère le mot
     *
     * @param plural
     *            Si le mot est au pluriel
     * @param determinant
     *            Le déterminant du mot
     * @return Le mot
     */
    public String get(boolean plural, WordDeterminant determinant);
}

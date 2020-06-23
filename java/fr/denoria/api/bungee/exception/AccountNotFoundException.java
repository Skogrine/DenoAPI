package fr.denoria.api.bungee.exception;

import java.util.UUID;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(UUID uuid){
        super("Le compte (" + uuid.toString() + ") n'a pas été trouvé !");
    }

}

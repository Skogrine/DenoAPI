package fr.denoria.api.bungee.commands;

import fr.denoria.api.bungee.commons.Account;
import fr.denoria.api.bungee.core.AccountProvider;
import fr.denoria.api.bungee.exception.AccountNotFoundException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RedisCommand extends Command {


    public RedisCommand(String name) {
        super("redis");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer){
            // /redis db/r
            ProxiedPlayer player = (ProxiedPlayer)commandSender;
            if(args[0].equalsIgnoreCase("db")){
                final AccountProvider accountProvider = new AccountProvider(player);
                try {
                    final Account account = accountProvider.getAccount();
                    accountProvider.sendAccountToDatabase(account);
                } catch (AccountNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if(args[0].equalsIgnoreCase("r")){
                final AccountProvider accountProvider = new AccountProvider(player);
                try {
                    final Account account = accountProvider.getAccount();
                    accountProvider.sendAccountToRedis(account);
                } catch (AccountNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                player.sendMessage(new TextComponent("bd ou r & nique ta mere"));
            }
        }
    }
}

package view.commands;

import view.CommandManager;
import view.commandException.EmptyFieldCommandException;


/**
 * Выводит справку по доступным командам.
 */

public class HelpCommand extends AbstractCommand{
    CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        super("help", "", "display help for available commands");
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()){
                commandManager.getCommands().forEach((key,value) -> System.out.println(key + " " + getParameters() +": " + value.getDescription()));
                System.out.println("Help has been successfully issued");
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

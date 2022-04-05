package View.Commands;

import View.CommandManager;


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
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

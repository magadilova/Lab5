package view.commands;

import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;


/**
 * Выводит справку по доступным командам.
 */

public class HelpCommand extends AbstractCommand{
    ConsoleClient consoleClient;

    public HelpCommand(ConsoleClient consoleClient) {
        super("help", "", "display help for available commands");
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()){
                consoleClient.getCommands().forEach((key, value) -> System.out.println(key + " " + getParameters() +": " + value.getDescription()));
                consoleClient.println("Help has been successfully issued");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

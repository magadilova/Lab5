package view.commands;

import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

/**
 * Выводит последние 12 команд
 */

public class HistoryCommand extends AbstractCommand {
    ConsoleClient consoleClient;

    public HistoryCommand(ConsoleClient consoleClient) {
        super("history", "", "print the last 12 commands");
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                consoleClient.getHistory();
                consoleClient.println("A list of commands is displayed");
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

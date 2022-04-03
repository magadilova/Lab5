package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import View.CommandManager;

/**
 * Выводит последние 12 команд
 */

public class HistoryCommand extends AbstractCommand {
    CommandManager commandManager;

    public HistoryCommand(CommandManager commandManager) {
        super("history", "", "print the last 12 commands");
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                commandManager.getHistory();
                System.out.println("A list of commands is displayed");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

/**
 * Очищает коллекцию.
 */

public class ClearCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public ClearCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("clear", "", "clear the collection");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.clear();
                consoleClient.println("Collection has been cleared");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}
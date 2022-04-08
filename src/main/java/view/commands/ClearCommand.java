package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

/**
 * Очищает коллекцию.
 */

public class ClearCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    CommandManager commandManager;

    public ClearCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager, CommandManager commandManager) {
        super("clear", "", "clear the collection");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.clear();
                System.out.println("Collection has been cleared");
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}
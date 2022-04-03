package View.Commands;

import Controller.LinkedHashSetCollectionManager;

/**
 * Очищает коллекцию.
 */

public class ClearCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public ClearCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("clear", "", "clear the collection");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.clear();
                System.out.println("Collection has been cleared");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}
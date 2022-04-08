package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.Asker;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

/**
 * Добавляет в коллекцию новый элемент.
 */

public class AddCommand extends AbstractCommand{
    Asker asker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    CommandManager commandManager;

    public AddCommand( Asker asker, LinkedHashSetCollectionManager linkedHashSetCollectionManager, CommandManager commandManager) {
        super("add", "{element}", "add a new element to the collection");
        this.asker = asker;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.add(asker.startAsker());
                System.out.println("The element was successfully added.");
                commandManager.addToHistory(getName());
                return true;
            }
            throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

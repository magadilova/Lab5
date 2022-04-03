package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import View.Asker;

/**
 * Добавляет в коллекцию новый элемент.
 */

public class AddCommand extends AbstractCommand{
    Asker asker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public AddCommand( Asker asker, LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("add", "{element}", "add a new element to the collection");
        this.asker = asker;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.add(asker.startAsker());
                System.out.println("The element was successfully added.");
                return true;
            }
            throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

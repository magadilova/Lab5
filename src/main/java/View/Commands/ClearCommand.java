package View.Commands;

import Controller.LinkedHashSetCollectionManager;


public class ClearCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public ClearCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("clear", "clear the collection", "");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        linkedHashSetCollectionManager.clear();
        System.out.println("Collection has been cleared");
        return true;
    }
}
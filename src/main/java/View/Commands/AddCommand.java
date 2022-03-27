package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import View.Asker;

public class AddCommand extends AbstractCommand{
    Asker asker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public AddCommand( Asker asker, LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("add", "добавить новый элемент в коллекцию", "{element}");
        this.asker = asker;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        linkedHashSetCollectionManager.add(asker.startAsker());
        return true;
    }
}

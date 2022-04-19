package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.Asker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

/**
 * Добавляет в коллекцию новый элемент.
 */

public class AddCommand extends AbstractCommand{
    Asker asker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public AddCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("add", "{element}", "add a new element to the collection");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                if (ConsoleClient.fileMode)
                    asker = new Asker(ConsoleClient.getScanners().getLast());
                else
                    asker = new Asker(ConsoleClient.scanner);
                linkedHashSetCollectionManager.add(asker.startAsker());
                consoleClient.println("The element was successfully added.");
                consoleClient.addToHistory(getName());
                return true;
            }
            throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;
import view.commandException.WrongFieldComandException;

/**
 * Удаляет элемент из коллекции по его id.
 */

public class RemoveIDCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public RemoveIDCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("remove_by_id", "id", "remove element from collection by its id.");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                linkedHashSetCollectionManager.deleteByID(Long.parseLong(arguments.trim()));
                consoleClient.println("Element was successfully deleted");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command needs the value \" id \"");
        } catch (WrongFieldComandException | EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

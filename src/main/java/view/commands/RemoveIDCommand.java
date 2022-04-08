package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;
import view.commandException.WrongFieldComandException;

/**
 * Удаляет элемент из коллекции по его id.
 */

public class RemoveIDCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    CommandManager commandManager;

    public RemoveIDCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, CommandManager commandManager) {
        super("remove_by_id", "id", "remove element from collection by its id.");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                linkedHashSetCollectionManager.deleteByID(Long.parseLong(arguments.trim()));
                System.out.println("Element was successfully deleted");
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command needs the value \" id \"");
        } catch (WrongFieldComandException | EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

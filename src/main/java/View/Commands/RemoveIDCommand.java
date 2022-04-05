package View.Commands;

import Controller.LinkedHashSetCollectionManager;

/**
 * Удаляет элемент из коллекции по его id.
 */

public class RemoveIDCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public RemoveIDCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("remove_by_id", "id", "remove element from collection by its id.");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                linkedHashSetCollectionManager.deleteByID(Long.parseLong(arguments.trim()));
                System.out.println("Element was successfully deleted");
                return true;
            } else throw new CommandException("Exception: This command needs the value \" id \"");
        } catch (WrongFieldComandException | CommandException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

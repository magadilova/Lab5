package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

/**
 * Выводит в стандартный поток вывода информацию о коллекции.
 */

public class InfoCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    CommandManager commandManager;

    public InfoCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager, CommandManager commandManager) {
        super("info", "", "output collection information" +
                " (type, initialisation date, number of items)" + " to the standard output stream");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                System.out.println(" Collection type: " + linkedHashSetCollectionManager.getSet().getClass() +
                        "\n Date of initialisation: " + linkedHashSetCollectionManager.getDateInitialization() +
                        "\n Number of elements: " + linkedHashSetCollectionManager.getSet().size());
                System.out.println("Information of the collection is displayed");
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

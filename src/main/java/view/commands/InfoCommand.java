package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

/**
 * Выводит в стандартный поток вывода информацию о коллекции.
 */

public class InfoCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public InfoCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("info", "", "output collection information" +
                " (type, initialisation date, number of items)" + " to the standard output stream");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                System.out.println(" Collection type: " + linkedHashSetCollectionManager.getSet().getClass() +
                        "\n Date of initialisation: " + linkedHashSetCollectionManager.getDateInitialization() +
                        "\n Number of elements: " + linkedHashSetCollectionManager.getSet().size());
                consoleClient.println("Information of the collection is displayed");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

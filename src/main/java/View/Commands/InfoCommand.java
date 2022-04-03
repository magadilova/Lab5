package View.Commands;

import Controller.LinkedHashSetCollectionManager;

/**
 * Выводит в стандартный поток вывода информацию о коллекции.
 */

public class InfoCommand extends AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public InfoCommand( LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("info", "", "output collection information" +
                " (type, initialisation date, number of items)" + " to the standard output stream");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                System.out.println(" Collection type: " + linkedHashSetCollectionManager.getSet().getClass() +
                        "\n Date of initialisation: " + linkedHashSetCollectionManager.getDateInitialization() +
                        "\n Number of elements: " + linkedHashSetCollectionManager.getSet().size());
                System.out.println("Information of the collection is displayed");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

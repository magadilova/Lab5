package view.commands;

import controller.LinkedHashSetCollectionManager;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;
import view.commandException.WrongFieldComandException;


/**
 * Удаляет элементы, значение поля partNumber которого эквивалентно заданному
 */

public class RemovePNCommand extends AbstractCommand {
    private final LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public RemovePNCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("remove_any_by_part_number", "partNumber", "remove one element from the collection whose " +
                "partNumber field value is equivalent to the given");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }


    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                linkedHashSetCollectionManager.deleteByPN(arguments.trim());
                consoleClient.println("One element removed, partNumber field value that is equivalent to the given");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command requires the value of the \" Part Number\" field");
        } catch (EmptyFieldCommandException | WrongFieldComandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

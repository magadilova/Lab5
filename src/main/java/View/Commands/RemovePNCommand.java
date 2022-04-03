package View.Commands;

import Controller.LinkedHashSetCollectionManager;


/**
 * Удаляет элементы, значение поля partNumber которого эквивалентно заданному
 */

public class RemovePNCommand extends AbstractCommand {
    private final LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public RemovePNCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("remove_any_by_part_number", "partNumber", "remove one element from the collection whose " +
                "partNumber field value is equivalent to the given");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
    }


    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                linkedHashSetCollectionManager.deleteByPN(arguments);
                System.out.println("One element removed, partNumber field value that is equivalent to the given");
                return true;
            } else throw new CommandException("Exception: This command requires the value of the \" Part Number\" field");
        } catch (CommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

package View.Commands;

import Model.Product;

import java.util.LinkedHashSet;

/**
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class ShowCommand extends AbstractCommand {
    LinkedHashSet<Product> collection;

    public ShowCommand(LinkedHashSet<Product> collection) {
        super("show", "", "output to the standard output stream all the elements" +
                " of the collection in a string representation");
        this.collection = collection;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                if (collection.size() != 0) {
                    for (Product product : collection){
                        System.out.println(product.toString());
                    }
                } else System.out.println("Oops, сollection is empty");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

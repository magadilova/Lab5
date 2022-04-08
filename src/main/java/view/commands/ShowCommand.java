package view.commands;

import model.Product;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

import java.util.LinkedHashSet;

/**
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class ShowCommand extends AbstractCommand {
    LinkedHashSet<Product> collection;
    CommandManager commandManager;

    public ShowCommand(LinkedHashSet<Product> collection, CommandManager commandManager) {
        super("show", "", "output to the standard output stream all the elements" +
                " of the collection in a string representation");
        this.collection = collection;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                if (collection.size() != 0) {
                    for (Product product : collection){
                        System.out.println(product.toString() + "\n");

                    }
                } else System.out.println("Oops, сollection is empty");
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

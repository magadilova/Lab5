package view.commands;

import model.Product;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

import java.util.LinkedHashSet;

/**
 * выводит элементы, значение поля price которых меньше заданного
 */

public class FilterLCommand extends AbstractCommand {
    private LinkedHashSet<Product> set;
    CommandManager commandManager;



    public FilterLCommand(LinkedHashSet<Product> set, CommandManager commandManager) {
        super("filter_less_than_price", "price", "output the elements whose value of the price " +
                "field is less than the given value");
        this.set = set;
        this.commandManager= commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if(!arguments.isEmpty()) {
                int count = 0;
                double price = Double.parseDouble(arguments.trim());
                for (Product item : set) {
                    if (price > item.getPrice()){
                        System.out.println(item);
                        count++;
                    }
                }
                System.out.println("Displayed elements, the value of the price field is less than the specified one."
                        + "\nThe number of elements that satisfy the condition: " + count);
                commandManager.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command needs the value \" price \"");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

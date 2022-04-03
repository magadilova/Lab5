package View.Commands;

import Model.Product;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * выводит элементы, значение поля price которых меньше заданного
 */

public class FilterLCommand extends AbstractCommand {
    private LinkedHashSet<Product> set;



    public FilterLCommand(LinkedHashSet<Product> set) {
        super("filter_less_than_price", "price", "output the elements whose value of the price " +
                "field is less than the given value");
        this.set = set;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if(!arguments.isEmpty()) {
                int count = 0;
                double price = Double.parseDouble(arguments);
                for (Product item : set) {
                    if (price > item.getPrice()){
                        System.out.println(item);
                        count++;
                    }
                }
                System.out.println("Displayed elements, the value of the price field is less than the specified one."
                        + "\nThe number of elements that satisfy the condition: " + count);
                return true;
            } else throw new CommandException("Exception: This command needs the value \" price \"");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

package View.Commands;

import Model.Product;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * выводит элементы, значение поля price которых меньше заданного
 */

public class FilterLCommand extends AbstractCommand {
    private LinkedHashSet<Product> set;
//    private Scanner scanner;


    public FilterLCommand(LinkedHashSet<Product> set, Scanner scanner) {
        super("filter_less_than_price", "price", "output the elements whose value of the price " +
                "field is less than the given value");
        this.set = set;
//        this.scanner = scanner;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if(!arguments.isEmpty()) {
                double price = Double.parseDouble(arguments); // scanner.nextLine().trim());
                for (Product item : set) {
                    if (price > item.getPrice())
                        System.out.println(item);
                }
                System.out.println("Displayed elements, the value of the price field is less than the specified one.");
                return true;
            } else throw new CommandException("Exception: This command needs the value \" price \"");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

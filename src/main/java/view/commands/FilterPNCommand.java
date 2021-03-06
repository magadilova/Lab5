package view.commands;

import model.Product;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

import java.util.LinkedHashSet;

/**
 *  Выводит элементы, значение поля partNumber которых начинается с заданной подстроки
 */

public class FilterPNCommand extends AbstractCommand {

    private LinkedHashSet<Product> set;
    ConsoleClient consoleClient;

    public FilterPNCommand(LinkedHashSet<Product> set, ConsoleClient consoleClient) {
        super("filter_starts_with_part_number", "partNumber", "output the elements whose " +
                "partNumber field value starts with the given substring");
        this.set = set;

    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                int count = 0;
                for (Product item : set) {
                    if (item.getPartNumber().startsWith(arguments.trim())) {
                        System.out.println(item);
                        count++;
                    }
                }
                consoleClient.println("Inferred elements, the value of the partNumber field starts with the given substring." +
                        "\nThe number of elements that satisfy the condition: " + count);
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command needs the value \" Part number \"");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

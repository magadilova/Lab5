package view.commands;

import controller.LinkedHashSetCollectionManager;
import model.*;
import view.Asker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

import java.util.ArrayList;

/**
 * Удалены вес элементы, меньшие, чем заданный
 */
public class RemoveLCommand  extends  AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;
    ConsoleClient consoleClient;

    public RemoveLCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, Asker asker, ConsoleClient consoleClient) {
        super("remove_lower", "{element}", "remove all items from the collection " +
                "that are smaller than the specified");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.asker = asker;
        this.consoleClient = consoleClient;
    }


    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                Product productToCompare = asker.startAsker();
                ArrayList<Product> arrayList = new ArrayList<>();
                for (Product product : linkedHashSetCollectionManager.getSet()) {
                    if (product.getPrice() < productToCompare.getPrice() && product.getManufactureCost() < productToCompare.getManufactureCost()) {
                        arrayList.add(product);
                    }
                }
                for (Product product : arrayList) {
                    linkedHashSetCollectionManager.deleteObject(product);
                }
                consoleClient.println("Removed from the collection all elements less than the specified");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

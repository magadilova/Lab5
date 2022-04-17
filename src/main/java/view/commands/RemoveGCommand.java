package view.commands;

import controller.LinkedHashSetCollectionManager;
import model.*;
import view.Asker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

import java.util.ArrayList;

/**
 * Удаляет  из коллекции все элементы, превышающие заданный
 */

public class RemoveGCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;
    ConsoleClient consoleClient;

    public RemoveGCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, Asker asker, ConsoleClient consoleClient) {
        super("remove_greater", "{element}", "remove all items from the collection that exceed the specified");
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
                    if (product.getPrice() > productToCompare.getPrice() && product.getManufactureCost() > productToCompare.getManufactureCost()) {
                        arrayList.add(product);
                    }
                }
                for (Product product : arrayList) {
                    linkedHashSetCollectionManager.deleteObject(product);
                }
                consoleClient.println("Removed from collection all elements set given");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

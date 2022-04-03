package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.*;
import View.Asker;

import java.util.ArrayList;

/**
 * Удаляет  из коллекции все элементы, превышающие заданный
 */

public class RemoveGCommand extends AbstractCommand{
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;

    public RemoveGCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, Asker asker) {
        super("remove_greater", "{element}", "remove all items from the collection that exceed the specified");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.asker = asker;
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
                System.out.println("Removed from collection all elements set given");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e){
            System.out.println(e.getMessage());
        } return false;
    }
}

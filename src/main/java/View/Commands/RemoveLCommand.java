package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.*;
import View.Asker;

import java.util.ArrayList;

/**
 * Удалены вес элементы, меньшие, чем заданный
 */
public class RemoveLCommand  extends  AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;

    public RemoveLCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, Asker asker) {
        super("remove_lower", "{element}", "remove all items from the collection " +
                "that are smaller than the specified");
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
                    if (product.getPrice() < productToCompare.getPrice() && product.getManufactureCost() < productToCompare.getManufactureCost()) {
                        arrayList.add(product);
                    }
                }
                for (Product product : arrayList) {
                    linkedHashSetCollectionManager.deleteObject(product);
                }
                System.out.println("Removed from the collection all elements less than the specified");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

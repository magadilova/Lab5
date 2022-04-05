package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.Product;
import View.Asker;

import java.util.ArrayList;

public class UpdateCommand extends  AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;

    public UpdateCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, Asker asker) {
        super("update_id", "{element}", "update the value of the collection item " +
                "whose id is the same as the given one");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.asker = asker;
    }


    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.isEmpty()) {

                ArrayList<Product> arrayList = new ArrayList<>();
                for (Product product : linkedHashSetCollectionManager.getSet()) {
                    if (product.getId().equals(Long.parseLong(arguments.trim()))) {
                        arrayList.add(product);
                    }
                }

                for (Product product : arrayList) {
                    linkedHashSetCollectionManager.deleteObject(product);
                    if (!product.getId().equals(Long.parseLong(arguments.trim())))
                        throw new WrongFieldComandException("There is no element with the given field \"id\" value");
                    else {
                        long id = Long.parseLong(arguments);
                        linkedHashSetCollectionManager.addUpdate(asker.startAsker(), id);
                        product.setId(id);
                    }
                }

            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException | WrongFieldComandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

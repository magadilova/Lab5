package view.commands;

import controller.LinkedHashSetCollectionManager;
import model.Product;
import view.Asker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;
import view.commandException.WrongFieldComandException;

import java.util.ArrayList;

public class UpdateCommand extends  AbstractCommand {
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    Asker asker;
    ConsoleClient consoleClient;

    public UpdateCommand(LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("update_id", "{element}", "update the value of the collection item " +
                "whose id is the same as the given one");
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
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
                        if (ConsoleClient.fileMode) {
                            asker = new Asker(ConsoleClient.getScanners().getLast());
                        } else
                            asker = new Asker(ConsoleClient.scanner);
                        linkedHashSetCollectionManager.addUpdate(asker.startAsker(), id);
                        product.setId(id);
                    }
                }
                consoleClient.println("The element with the given ID was successfully updated");
                consoleClient.addToHistory(getName());
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException | WrongFieldComandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

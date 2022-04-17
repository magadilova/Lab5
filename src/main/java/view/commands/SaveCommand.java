package view.commands;

import controller.LinkedHashSetCollectionManager;
import model.*;
import options.FileWorker;
import options.XmlWorker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

import java.io.IOException;


public class SaveCommand extends AbstractCommand {
    FileWorker fileWorker;
    XmlWorker xmlWorker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    ConsoleClient consoleClient;

    public SaveCommand(FileWorker fileWorker, XmlWorker xmlWorker, LinkedHashSetCollectionManager linkedHashSetCollectionManager, ConsoleClient consoleClient) {
        super("save", "", "save the collection to a file");
        this.fileWorker = fileWorker;
        this.xmlWorker = xmlWorker;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.consoleClient = consoleClient;
    }


    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                linkedHashSetCollectionManager.sortSet();
                String xml = xmlWorker.toXml(linkedHashSetCollectionManager.getSet(),new Class[]{
                        Person.class,
                        Product.class,
                        Coordinates.class,
                        EyeColor.class,
                        HairColor.class,
                        Country.class,
                        UnitOfMeasure.class,
                        Location.class,
                        linkedHashSetCollectionManager.getSet().getClass()
                });

                fileWorker.saveFile(xml);
                consoleClient.println("Collection saved");
                consoleClient.addToHistory(getName());
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

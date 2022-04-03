package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.*;
import Options.FileWorker;
import Options.XmlWorker;

import java.io.IOException;


public class SaveCommand extends AbstractCommand {
    FileWorker fileWorker;
    XmlWorker xmlWorker;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public SaveCommand(FileWorker fileWorker, XmlWorker xmlWorker, LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("save", "", "save the collection to a file");
        this.fileWorker = fileWorker;
        this.xmlWorker = xmlWorker;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
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
                System.out.println("Collection saved");
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

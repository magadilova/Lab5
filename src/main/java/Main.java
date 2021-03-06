import controller.LinkedHashSetCollectionManager;
import model.*;

import options.FileWorker;
import options.XmlWorker;
import view.commands.*;
import view.ConsoleClient;

import java.util.LinkedHashSet;


public class Main {
    public static void main(String[] args) {
//        final String value = "-> ";
        LinkedHashSetCollectionManager linkedHashSetCollectionManager = new LinkedHashSetCollectionManager();
        ConsoleClient consoleClient = new ConsoleClient();
//        Asker asker = new Asker(new Scanner(System.in));
        XmlWorker xmlWorker = new XmlWorker(linkedHashSetCollectionManager.getSet().getClass(),Product.class);


//        Console console = System.console();
//        Asker asker = new Asker(console);
//        System.setProperty("PRODUCTS_FILENAME", "fileScr.xml");
        FileWorker fileWorker = new FileWorker();






        LinkedHashSet<Product> xmlFrom = xmlWorker.fromXML(FileWorker.readFile(),new Class[]{
                Person.class,
                Product.class,
                Coordinates.class,
                EyeColor.class,
                HairColor.class,
                Country.class,
                UnitOfMeasure.class,
                Location.class,
                linkedHashSetCollectionManager.getSet().getClass()}
        );


        linkedHashSetCollectionManager.load(xmlFrom);

        consoleClient.putCommands(
                new UpdateCommand(linkedHashSetCollectionManager, consoleClient),
                new ShowCommand(linkedHashSetCollectionManager.getSet(), consoleClient),
                new RemovePNCommand(linkedHashSetCollectionManager, consoleClient),
                new RemoveLCommand(linkedHashSetCollectionManager, consoleClient),
                new RemoveIDCommand(linkedHashSetCollectionManager, consoleClient),
                new RemoveGCommand(linkedHashSetCollectionManager, consoleClient),
                new InfoCommand(linkedHashSetCollectionManager, consoleClient),
                new HelpCommand(consoleClient),
                new FilterPNCommand(linkedHashSetCollectionManager.getSet(), consoleClient),
                new FilterLCommand(linkedHashSetCollectionManager.getSet(), consoleClient),
                new ExitCommand(),
                new ExecuteCommand(fileWorker, consoleClient, linkedHashSetCollectionManager,xmlWorker),
                new ClearCommand(linkedHashSetCollectionManager, consoleClient),
                new AddCommand (linkedHashSetCollectionManager, consoleClient),
                new SaveCommand(fileWorker,xmlWorker, linkedHashSetCollectionManager, consoleClient),
                new HistoryCommand(consoleClient));

//        ConsoleInterface consoleInterface = new ConsoleInterface(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), new InputStreamReader(System.in, StandardCharsets.UTF_8), true);

//        while (true){
//            consoleInterface.writeWithoutSpace(value);
//            String line = consoleInterface.read();
//            consoleClient.executeCommand(line);
//        }

        consoleClient.startApp();

    }
}

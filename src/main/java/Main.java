import Controller.LinkedHashSetCollectionManager;
import Model.*;

import Options.FileWorker;
import Options.XmlWorker;
import View.Asker;
import View.Commands.*;
import View.CommandManager;


import java.io.Console;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        Coordinates coordinates = new Coordinates(23, 201L);
//        Location location = new Location(10, 1.2, 23);
//        Person person1 = new Person("Voldemort", EyeColor.BROWN, HairColor.BLACK, Country.FRANCE, location);
//        Product p1 = new Product("Diary", coordinates, 3, "263517", 40, UnitOfMeasure.MILLIGRAMS, person1);
//        Person person2 = new Person("Marvolo", EyeColor.GREEN, HairColor.BLACK, Country.INDIA, location);
//        Product p2 = new Product("Ring", coordinates, 1.12, "26248", 25, UnitOfMeasure.MILLIGRAMS, person2);
//        Person person3 = new Person("Slytherin", EyeColor.GREEN, HairColor.BROWN, Country.FRANCE, location);
//        Product p3 = new Product("Medallion", coordinates, 62473, "439498", 76, UnitOfMeasure.MILLIGRAMS, person3);
//        Person person4 = new Person("Hufflepuff", EyeColor.BROWN, HairColor.YELLOW, Country.ITALY, location);
//        Product p4 = new Product("Bowl", coordinates, 329, "7345617", 21, UnitOfMeasure.MILLIGRAMS, person4);
//        Person person5 = new Person("Ravenclaw", EyeColor.BLUE, HairColor.BLUE, Country.FRANCE, location);
//        Product p5 = new Product("Diadem", coordinates, 12, "2908", 45, UnitOfMeasure.MILLIGRAMS, person5);
//        Person person6 = new Person("Voldemort", EyeColor.BROWN, HairColor.BLACK, Country.FRANCE, location);
//        Product p6 = new Product("Nagini", coordinates, 27, "10149", 100, UnitOfMeasure.MILLIGRAMS, person6);
//        Person person7 = new Person("Malfoy", EyeColor.BLUE, HairColor.YELLOW, Country.ITALY, location);
//        Product p7 = new Product("Potter", coordinates, 877, "149", 39, UnitOfMeasure.CENTIMETERS, person7);

        LinkedHashSetCollectionManager linkedHashSetCollectionManager = new LinkedHashSetCollectionManager();
        CommandManager commandManager = new CommandManager();
        Asker asker = new Asker(new Scanner(System.in));
        XmlWorker xmlWorker = new XmlWorker(linkedHashSetCollectionManager.getSet().getClass(),Product.class);
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

        commandManager.putCommands(new AbstractCommand[]{
                new UpdateCommand(linkedHashSetCollectionManager,asker),
                new ShowCommand(linkedHashSetCollectionManager.getSet()),
                new RemovePNCommand(linkedHashSetCollectionManager),
                new RemoveLCommand(linkedHashSetCollectionManager,asker),
                new RemoveIDCommand(linkedHashSetCollectionManager),
                new RemoveGCommand(linkedHashSetCollectionManager,asker),
                new InfoCommand(linkedHashSetCollectionManager),
                new HelpCommand(commandManager),
                new FilterPNCommand(linkedHashSetCollectionManager.getSet()),
                new FilterLCommand(linkedHashSetCollectionManager.getSet()),
                new ExitCommand(),
                new ExecuteCommand(fileWorker, commandManager),
                new ClearCommand(linkedHashSetCollectionManager),
                new AddCommand(asker, linkedHashSetCollectionManager),
                new SaveCommand(fileWorker,xmlWorker, linkedHashSetCollectionManager),
                new HistoryCommand(commandManager)});

//        linkedHashSetCollectionManager.getSet().add(p1);
//        linkedHashSetCollectionManager.getSet().add(p2);
//        linkedHashSetCollectionManager.getSet().add(p3);
//        linkedHashSetCollectionManager.getSet().add(p4);
//        linkedHashSetCollectionManager.getSet().add(p5);
//        linkedHashSetCollectionManager.getSet().add(p6);
//        linkedHashSetCollectionManager.getSet().add(p7);



//        commandManager.executeCommand("show");
//        commandManager.executeCommand("update_id 441488344");
//        commandManager.executeCommand("remove_any_by_part_number 7345617");
//        commandManager.executeCommand("remove_by_id 441488344");
//        commandManager.executeCommand("filter_starts_with_part_number 73456");
        commandManager.executeCommand("execute_script");

//
//        while (true) {
//            Console console = System.console();
//            if (console != null) {
//                System.out.println("Console app started");
//                commandManager.executeCommand(console.readLine("Please enter command \n"));
//            }
//        }


    }
}

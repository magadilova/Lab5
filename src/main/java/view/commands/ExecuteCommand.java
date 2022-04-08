package view.commands;

import controller.LinkedHashSetCollectionManager;

import model.*;
import options.FileWorker;
import options.XmlWorker;
import view.CommandManager;
import view.commandException.EmptyFieldCommandException;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ExecuteCommand extends AbstractCommand {
    FileWorker fileWorker;
    CommandManager commandManager;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    XmlWorker xmlWorker;

    public ExecuteCommand(FileWorker fileWorker, CommandManager commandManager, LinkedHashSetCollectionManager linkedHashSetCollectionManager, XmlWorker xmlWorker) {
        super("execute_script", "file_name", "read and execute a script from a specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
        this.fileWorker = fileWorker;
        this.commandManager = commandManager;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.xmlWorker = xmlWorker;
    }

    @Override
    public boolean execute(String arguments) {

        try {
            Scanner scanner = new Scanner(new File(arguments));
            if (!arguments.equals("")) {
                while (scanner.hasNext()) {
                    String element = scanner.nextLine();
                    if (element.equals("execute_script")) throw new EmptyFieldCommandException("You have already run the script");
                    if (element.equals("add")) {

                        Product product1 = new Product(scanner.nextLine(),
                                new Coordinates(Integer.parseInt(scanner.nextLine()), Long.parseLong(scanner.nextLine())),
                                Double.parseDouble(scanner.nextLine()), scanner.nextLine(), Long.parseLong(scanner.nextLine()),
                                UnitOfMeasure.valueOf(scanner.nextLine()),
                                new Person(scanner.nextLine(), EyeColor.valueOf(scanner.nextLine()), HairColor.valueOf(scanner.nextLine()),
                                        Country.valueOf(scanner.nextLine()), new Location(Float.parseFloat(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()))));
                        linkedHashSetCollectionManager.getSet().add(product1);
                        linkedHashSetCollectionManager.sortSet();
                        System.out.println("The element was successfully added.");}
//                    } if (element.equals("remove_lower")) {
//
//                        Product product2 = new Product(scanner.nextLine(),
//                                new Coordinates(Integer.parseInt(scanner.nextLine()), Long.parseLong(scanner.nextLine())),
//                                Double.parseDouble(scanner.nextLine()), scanner.nextLine(), Long.parseLong(scanner.nextLine()),
//                                UnitOfMeasure.valueOf(scanner.nextLine()),
//                                new Person(scanner.nextLine(), EyeColor.valueOf(scanner.nextLine()), HairColor.valueOf(scanner.nextLine()),
//                                        Country.valueOf(scanner.nextLine()), new Location(Float.parseFloat(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()))));
//
//                        ArrayList<Product> arrayList = new ArrayList<>();
//                        for (Product product : linkedHashSetCollectionManager.getSet()) {
//                            if (product.getPrice() < product2.getPrice() && product.getManufactureCost() < product2.getManufactureCost()) {
//                                arrayList.add(product);
//                            }
//                        }
//                        for (Product product : arrayList) {
//                            linkedHashSetCollectionManager.deleteObject(product);
//                        }
//                        System.out.println("Removed from the collection all elements less than the specified");
//                    } if (element.equals("remove_greater")) {
//
//                        Product product3 = new Product(scanner.nextLine(),
//                                new Coordinates(Integer.parseInt(scanner.nextLine()), Long.parseLong(scanner.nextLine())),
//                                Double.parseDouble(scanner.nextLine()), scanner.nextLine(), Long.parseLong(scanner.nextLine()),
//                                UnitOfMeasure.valueOf(scanner.nextLine()),
//                                new Person(scanner.nextLine(), EyeColor.valueOf(scanner.nextLine()), HairColor.valueOf(scanner.nextLine()),
//                                        Country.valueOf(scanner.nextLine()), new Location(Float.parseFloat(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()))));
//
//                        ArrayList<Product> arrayList = new ArrayList<>();
//                        for (Product product : linkedHashSetCollectionManager.getSet()) {
//                            if (product.getPrice() > product3.getPrice() && product.getManufactureCost() > product3.getManufactureCost()) {
//                                arrayList.add(product);
//                            }
//                        }
//                        for (Product product : arrayList) {
//                            linkedHashSetCollectionManager.deleteObject(product);
//                        }
//                        System.out.println("Removed from collection all elements set given");
//                    }
                    else commandManager.executeCommand(element);
                    commandManager.addToHistory(getName());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
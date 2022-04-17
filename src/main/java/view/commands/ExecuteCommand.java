package view.commands;

import controller.LinkedHashSetCollectionManager;

import model.*;
import options.FileWorker;
import options.XmlWorker;
import view.ConsoleClient;
import view.commandException.EmptyFieldCommandException;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteCommand extends AbstractCommand {
    FileWorker fileWorker;
    ConsoleClient consoleClient;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;
    XmlWorker xmlWorker;

    public ExecuteCommand(FileWorker fileWorker, ConsoleClient consoleClient, LinkedHashSetCollectionManager linkedHashSetCollectionManager, XmlWorker xmlWorker) {
        super("execute_script", "file_name", "read and execute a script from a specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
        this.fileWorker = fileWorker;
        this.consoleClient = consoleClient;
        this.linkedHashSetCollectionManager = linkedHashSetCollectionManager;
        this.xmlWorker = xmlWorker;
    }

    @Override
    public boolean execute(String arguments) {
        ArrayList<String> nameFile = new ArrayList();
        nameFile.add(arguments);
        try {
            Scanner scanner = new Scanner(new File(arguments));
            if (!arguments.equals("")) {
                while (scanner.hasNext()) {
                    String element = scanner.nextLine();
                    String[] strCommand = element.trim().split(" ", 2);
                    if (strCommand[0].equals("execute_script") && strCommand[1].equals(arguments)){
                        throw new EmptyFieldCommandException("You have already run the script");
                    }
                    if (strCommand[0].equals("execute_script")){
                        for (String str : nameFile){
                            str.equals(strCommand[1]);
                            throw new ScriptException("Scripts can't be recursive!!!");
                        }
                    }
                    if (strCommand[0].equals("add")) {

                        Product product1 = new Product(scanner.nextLine(),
                                new Coordinates(Integer.parseInt(scanner.nextLine()), Long.parseLong(scanner.nextLine())),
                                Double.parseDouble(scanner.nextLine()), scanner.nextLine(), Long.parseLong(scanner.nextLine()),
                                UnitOfMeasure.valueOf(scanner.nextLine()),
                                new Person(scanner.nextLine(), EyeColor.valueOf(scanner.nextLine()), HairColor.valueOf(scanner.nextLine()),
                                        Country.valueOf(scanner.nextLine()), new Location(Float.parseFloat(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()))));
                        linkedHashSetCollectionManager.getSet().add(product1);
                        linkedHashSetCollectionManager.sortSet();
                        System.out.println("The element was successfully added.");
                    }
                    else consoleClient.executeCommand(element);
                    consoleClient.addToHistory(getName());
                }
            }
        } catch (FileNotFoundException | ScriptException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
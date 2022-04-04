package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.*;
import Options.FileWorker;
import View.CommandManager;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ExecuteCommand extends AbstractCommand {
    FileWorker fileWorker;
    CommandManager commandManager;
    LinkedHashSetCollectionManager linkedHashSetCollectionManager;

    public ExecuteCommand(FileWorker fileWorker, CommandManager commandManager, LinkedHashSetCollectionManager linkedHashSetCollectionManager) {
        super("execute_script", "file_name", "read and execute a script from a specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
        this.fileWorker = fileWorker;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        Scanner scanner = new Scanner(arguments);
        int i = 1;
        try {
            if (!arguments.equals("")) {
                for (String element : FileWorker.readScript(arguments)){
                    if (element.equals("add")){
                        linkedHashSetCollectionManager.add(new Product("BVH",
                                new Coordinates(Integer.parseInt("3"),Long.parseLong("4")),
                                Double.parseDouble("37"),"37",Long.parseLong("783"),
                                UnitOfMeasure.valueOf("MILLIGRAMS"),
                                new Person("657", EyeColor.valueOf("BLUE"), HairColor.valueOf("BLUE"),
                                        Country.valueOf("ITALY"), new Location(Float.parseFloat("67"),Double.parseDouble("7"),Double.parseDouble("7")))));
                    }
                    if (element.equals("execute_script")) throw new CommandException("You have already run the script");

                    else commandManager.executeCommand(element);

                }
                return true;
            } else throw new CommandException("Exception: This command needs the value \"file_name\"");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

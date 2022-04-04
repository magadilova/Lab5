package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Model.Coordinates;
import Model.Product;
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
                    if (!element.equals("execute_script")){
                        System.out.print(i + ") ");
                        commandManager.executeCommand(element);
                        i++;
                    }

                    else throw new CommandException("You have already run the script");
                }
                return true;
            } else throw new CommandException("Exception: This command needs the value \"file_name\"");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

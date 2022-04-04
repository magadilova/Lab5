package View.Commands;

import Options.FileWorker;
import View.CommandManager;

public class ExecuteCommand extends AbstractCommand {
    FileWorker fileWorker;
    CommandManager commandManager;

    public ExecuteCommand(FileWorker fileWorker, CommandManager commandManager) {
        super("execute_script", "file_name", "read and execute a script from a specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
        this.fileWorker = fileWorker;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.equals("")) {
                for (String element : FileWorker.readScript()){
                    if (!element.equals("execute_script"))
                    commandManager.executeCommand(element);
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

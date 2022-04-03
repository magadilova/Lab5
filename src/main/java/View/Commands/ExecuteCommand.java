package View.Commands;

import Controller.LinkedHashSetCollectionManager;
import Options.FileWorker;
import Options.XmlWorker;

public class ExecuteCommand extends AbstractCommand {
    FileWorker fileWorker;
    XmlWorker xmlWorker;

    public ExecuteCommand(FileWorker fileWorker, XmlWorker xmlWorker) {
        super("execute_script", "file_name", "read and execute a script from a specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
        this.fileWorker = fileWorker;
        this.xmlWorker = xmlWorker;
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (!arguments.equals("")) {
                
                return true;
            } else throw new CommandException("Exception: This command needs the value \"file_name\"");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

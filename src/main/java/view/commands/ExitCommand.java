package view.commands;

import view.commandException.EmptyFieldCommandException;

/**
 *  Завершает работу программы.
 */
public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super("exit", "", "exit program without saving collection into file");
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()) {
                System.exit(0);
                return true;
            } else throw new EmptyFieldCommandException("Exception: This command must not have any characters");
        } catch (EmptyFieldCommandException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

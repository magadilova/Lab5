package View.Commands;

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
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

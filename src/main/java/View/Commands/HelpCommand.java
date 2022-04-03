package View.Commands;

import View.CommandManager;

/**
 * Выводит справку по доступным командам.
 */

public class HelpCommand extends AbstractCommand{

    public HelpCommand(CommandManager commandManager) {
        super("help", "", "display help for available commands");
    }

    @Override
    public boolean execute(String arguments) {
        try {
            if (arguments.isEmpty()){
                String helpMessage = "Display information about builtin commands\n\n" +
                    "help : display help for available commands\n" +
                    "info : output collection information (type, initialisation date, number of items) to the standard output stream\n" +
                    "show : output to the standard output stream all the elements\n" +
                    "add {element} : add a new element to the collection\n" +
                    "update_id {element} : update the value of the collection item whose id is the same as the given one\n" +
                    "remove_by_id id : remove element from collection by its id.\n" +
                    "clear : clear the collection\n" +
                    "save : save the collection to a file\n" +
                    "execute_script file_name : read and execute a script from a specified file. The script contains commands in the same form as they are entered by the user in interactive mode.\n" +
                    "exit : exit program without saving collection into file\n" +
                    "remove_greater {element} : remove all items from the collection that exceed the specified\n" +
                    "remove_lower {element} : remove all items from the collection that are smaller than the specified\n" +
                    "history : print the last 12 commands (with their arguments)\n" +
                    "remove_any_by_part_number partNumber : remove one element from the collection whose partNumber field value is equivalent to the given\n" +
                    "filter_starts_with_part_number partNumber : output the elements whose partNumber field value starts with the given substring\n" +
                    "filter_less_than_price price : output the elements whose value of the price field is less than the given value";
                System.out.println(helpMessage);
                return true;
            } else throw new CommandException("Exception: This command must not have any characters");
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        } return false;
    }
}

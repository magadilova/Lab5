package View;


import View.Commands.AbstractCommand;



import java.util.ArrayList;
import java.util.LinkedHashMap;


public class CommandManager {
    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();
    ArrayList<String> history = new ArrayList();


    public void putCommands(AbstractCommand[] commands) {
        for (AbstractCommand command : commands) {
            this.commands.put(command.getName(), command);
        }
    }

    public LinkedHashMap<String, AbstractCommand> getCommands() {
        return commands;
    }

    public void addToHistory(String command) {
        if (history.size() == 12) {
            history.remove(0);
            history.add(command);
        } else {
            history.add(command);
        }

    }

    public ArrayList<String> getHistory() {
        System.out.println(history);
        return history;
    }

    public boolean executeCommand(String str){

        String[] strCommand = str.trim().split(" ", 2);
        addToHistory(str);
        return commands.get(strCommand[0]).execute(strCommand.length > 1 ? strCommand[1] : "");


    }

}

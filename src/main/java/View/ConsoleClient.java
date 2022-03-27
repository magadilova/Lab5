package View;

import View.Commands.AbstractCommand;

import java.util.LinkedHashMap;

public class ConsoleClient {
    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();

    public void putCommands(AbstractCommand[] commands){
        for (AbstractCommand command : commands){
            this.commands.put(command.getName(),command);
        }
    }
}

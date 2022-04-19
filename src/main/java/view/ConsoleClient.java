package view;

import view.commands.AbstractCommand;

import java.io.Console;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class ConsoleClient {
    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();
    ArrayList<String> history = new ArrayList();
    private Deque<String> files = new ArrayDeque<>();
    static public Console scanner = System.console();
    static public boolean fileMode = false;
    private static Deque<Scanner> scanners = new ArrayDeque<>();

    public void putCommands(AbstractCommand... commands) {
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
        int i = 1;
        for (String element : history){
            System.out.println(i + ". " + element);
            i++;
        }
        return history;
    }

    public boolean executeCommand(String str){

        String[] strCommand = str.trim().split(" ", 2);
        return commands.get(strCommand[0]).execute(strCommand.length > 1 ? strCommand[1] : "");


    }

    public void startApp() {
        while (true) {
            try{
                Console console = System.console();
                String command = console.readLine("\nEnter the command\n-> ").trim();
                executeCommand(command);
            } catch (NullPointerException e) {
                startApp();
            }
        }

    }

    static public void println(String argument) {
        System.out.println(argument);
    }
    public static void setFileMode(boolean fileMode) {
        ConsoleClient.fileMode = fileMode;
    }

    public Deque<String> getFiles() {
        return files;
    }

    public static Deque<Scanner> getScanners() {
        return scanners;
    }

}

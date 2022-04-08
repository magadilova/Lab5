package view;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ConsoleInterface {
        private final Writer writer;
        private final Reader reader;
        private final Scanner scanner;
        private boolean interactive;

        public ConsoleInterface(Writer writer, Reader reader, boolean interactive) {
            this.writer = writer;
            this.reader = reader;
            this.scanner = new Scanner(reader);
            this.interactive = interactive;
        }

        public String read() {
            return scanner.nextLine();
        }

        public void write(String message) {
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                e.getMessage();
            }
        }

        public String readWithMessage(String message, boolean nullable) {
            String text = "";
            if (!nullable) {
                text = " Данное значение не может быть null";
            }
            String line = "";
            do {
                if (interactive) {
                    write(message + text);
                }
                //write(message + text )
                line = scanner.nextLine();
                line = line.isEmpty() ? null : line;
            } while (!nullable && line == null);
            return line;
        }

        public boolean hasNextLine() {
            return scanner.hasNextLine();
        }

        public boolean isInteractive() {
            return interactive;
        }

    public void writeWithoutSpace(String message){
        try{
            writer.write(message);
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

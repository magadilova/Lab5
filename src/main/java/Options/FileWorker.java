package Options;

import java.io.*;
import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс, отвечающий за работу с файлами формата XMl.
 */

public class FileWorker {

    public static String readFile() {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("fileScr.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(data);
    }

    public static ArrayList<String> readScript(String filename) {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filename))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


        public void saveFile(String data) throws IOException {
        File file = new File("fileChange.xml");
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
        writer.close();
    }
}


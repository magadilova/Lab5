package Options;

import java.io.*;

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

    public void saveFile(String data) throws IOException {
        File file = new File("fileChange.xml");
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
        writer.close();
    }
}


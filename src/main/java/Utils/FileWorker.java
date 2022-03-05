package Utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileWorker {
    public static String readFile(){
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            String line;
            while ((line = br.readLine()) != null) {
               data.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(data);
    }

}

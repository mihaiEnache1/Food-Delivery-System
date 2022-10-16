package dataLayer;

import java.io.FileWriter;

public class WriterForFile {
    public void file(String fileName, String text) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

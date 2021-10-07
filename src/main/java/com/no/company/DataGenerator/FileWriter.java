package com.no.company.DataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileWriter {

    private final File file;

    public FileWriter(String fileName)
    {
        file = new File(fileName);
    }

    public void writeLogDataToLogFile()
    {
        DataGenerator dataGenerator = new DataGenerator();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (int i=0; i<100; i++) {
                fileOutputStream.write(dataGenerator.prepareLogLine().getBytes(StandardCharsets.UTF_8));
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

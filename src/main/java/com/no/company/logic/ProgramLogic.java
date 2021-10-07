package com.no.company.logic;

import com.no.company.database.DatabaseDMLOperations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramLogic {

    private Connection databaseConnection=null;
    private List<DataFromFile> dataFromFileList = new ArrayList<>();
    private Map<String,DataFromFile> eventMap = new HashMap<>();

    public ProgramLogic(Connection con)
    {
        this.databaseConnection=con;
    }

    public void checkGivenFile(String filePath)
    {
        Path file = new File(filePath).toPath();

        if (Files.exists(file))
        {
            if (Files.isRegularFile(file))
            {
                readGivenFile(filePath);
            }
        }
    }

    private void readGivenFile(String filePath)
    {
        try {
            String lineFromFile;
            DataProcessor dataProcessor = new DataProcessor();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (  (lineFromFile = bufferedReader.readLine()) != null )
            {
                dataFromFileList.add(dataProcessor.parseLineOfData(lineFromFile));
            }

            LogEventDataProcessor logEventDataProcessor = new LogEventDataProcessor();
            eventMap =logEventDataProcessor.findToLongEvents(dataFromFileList);

            DatabaseDMLOperations databaseDMLOperations = new DatabaseDMLOperations(databaseConnection);
            databaseDMLOperations.saveData(eventMap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

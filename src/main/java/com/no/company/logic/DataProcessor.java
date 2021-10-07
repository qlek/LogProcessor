package com.no.company.logic;

public class DataProcessor {

    private static final String regexpColon = ", ";
    private static final String regexpEmpty = "";
    private static final String regexpComma =":";
    private static final String regexpQuotation ="\"";
    private static final String regexpLineBracesStart ="{";
    private static final String regexpLineBracesEnd ="}";

    DataFromFile dataFromFile;

    public DataFromFile parseLineOfData(String line)
    {
        dataFromFile = new DataFromFile();
        String[] fields = line.split(regexpColon);
        for (int i=0; i<fields.length; i++) {
            parseParameterValue(fields[i]);
        }
        return dataFromFile;
    }

    private void parseParameterValue(String data)
    {
        String[] fields = data.split(regexpComma);
        for (int i=0; i< fields.length; i++)
        {
            if(fields[i].contains(regexpQuotation))
            {
                fields[i]= fields[i].replace(regexpQuotation, regexpEmpty);
            }
            if (fields[i].contains(regexpLineBracesStart) )
            {
                fields[i]= fields[i].replace(regexpLineBracesStart, regexpEmpty);
            }
            if (fields[i].contains(regexpLineBracesEnd))
            {
                fields[i]= fields[i].replace(regexpLineBracesEnd, regexpEmpty);
            }
        }
        findDataUsingLabels(fields);
    }

    private void findDataUsingLabels(String[] params)
    {
        if(FieldsFromLog.id.getName().contains(params[0]))
        {
            dataFromFile.setId(params[1]);
        }
        if(FieldsFromLog.host.getName().contains(params[0]))
        {
            dataFromFile.setHost(params[1]);
        }
        if(FieldsFromLog.state.getName().contains(params[0]))
        {
            dataFromFile.setState(params[1]);
        }
        if(FieldsFromLog.type.getName().contains(params[0]))
        {
            dataFromFile.setType(params[1]);
        }
        if(FieldsFromLog.timestamp.getName().contains(params[0]))
        {
            dataFromFile.setTimestamp(params[1]);
        }
    }
}

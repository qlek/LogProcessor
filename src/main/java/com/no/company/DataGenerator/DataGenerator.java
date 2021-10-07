package com.no.company.DataGenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    ArrayList<LogLineData> idsToPare = new ArrayList<LogLineData>();

    public String prepareLogLine()
    {
        String lineStart = "{\"";
        String middlePatternForTimestamp = "\":";
        String middlePatternB = "\", \"";
        String middlePatternA = "\":\"";
        String lineEnd = "}";
        int randomId =0;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<10;i++)
        {
            generateLogLineData();
        }
        while (!idsToPare.isEmpty())
        {
            randomId = ThreadLocalRandom.current().nextInt(0, idsToPare.size());

            sb.append(lineStart);
            sb.append(FieldLabelsFromFile.id.getName());
            sb.append(middlePatternA);
            sb.append(idsToPare.get(randomId).getId());
            sb.append(middlePatternB);
            sb.append(FieldLabelsFromFile.state.getName());
            sb.append(middlePatternA);
            sb.append(idsToPare.get(randomId).getState());
            sb.append(middlePatternB);

            if ( !StringUtils.isEmpty(idsToPare.get(randomId).getType()) ) {
                sb.append(FieldLabelsFromFile.type.getName());
                sb.append(middlePatternA);
                sb.append(idsToPare.get(randomId).getType());
                sb.append(middlePatternB);
            }

            if (!StringUtils.isEmpty(idsToPare.get(randomId).getHost()) ) {
                sb.append(FieldLabelsFromFile.host.getName());
                sb.append(middlePatternA);
                sb.append(idsToPare.get(randomId).getHost());
                sb.append(middlePatternB);
            }

            sb.append(FieldLabelsFromFile.timestamp.getName());
            sb.append(middlePatternForTimestamp);
            sb.append(idsToPare.get(randomId).getTimestamp());
            sb.append(lineEnd);

            sb.append(System.lineSeparator());
            idsToPare.remove(randomId);
        }
        return sb.toString();
    }

    private void generateLogLineData()
    {
        LogLineData logLineDataStarted = new LogLineData();
        LogLineData logLineDataFinished = new LogLineData();
        int length =3;
        boolean hasLetters = true;
        boolean hasNumbers = false;
        int isHostInFile =ThreadLocalRandom.current().nextInt(0, 2);
        int isTypeInFile =ThreadLocalRandom.current().nextInt(0, 2);

        String id = "scsmbst" + RandomStringUtils.randomAlphabetic(length);
        logLineDataStarted.setId(id);
        logLineDataStarted.setState("STARTED");
        if (isHostInFile ==0) {
            logLineDataStarted.setHost(prepareHostData(isHostInFile));
        }
        if (isTypeInFile ==0) {
            logLineDataStarted.setType(prepareTypeData(isTypeInFile));
        }
        logLineDataStarted.setTimestamp(prepareTimestampData());
        idsToPare.add(logLineDataStarted);

        logLineDataFinished.setId(id);
        logLineDataFinished.setState("FINISHED");
        logLineDataFinished.setType(logLineDataStarted.getType());
        logLineDataFinished.setHost(logLineDataStarted.getHost());
        logLineDataFinished.setTimestamp(prepareTimestampData());
        idsToPare.add(logLineDataFinished);

    }

    private String prepareHostData(int randomNumber)
    {
        if (randomNumber ==0) {
            return "12345";
        }
        else return "";
    }

    private String prepareTypeData(int randomNumber)
    {
        if (randomNumber ==0) {
        return "Application";
        }
        else return "";
    }

    private String prepareTimestampData()
    {
        int length =3;
        boolean hasLetters = false;
        boolean hasNumbers = true;

        String timestamp = "1491377495" + RandomStringUtils.random(length,hasLetters,hasNumbers);
        return timestamp;
    }
}

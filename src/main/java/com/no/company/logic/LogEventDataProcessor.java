package com.no.company.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogEventDataProcessor {
    
    private Map<String,DataFromFile> startedEventMap = new HashMap<>();
    private Map<String,DataFromFile> finishedEventMap = new HashMap<>();

    public Map<String,DataFromFile> findToLongEvents(List<DataFromFile> dataList)
    {
        for (DataFromFile localData: dataList)
        {
            if ("started".toUpperCase().equals(localData.getState()))
            {
                startedEventMap.put(localData.getId(), localData);
            }
            if ("finished".toUpperCase().equals(localData.getState()))
            {
                finishedEventMap.put(localData.getId(), localData);
            }
        }
        return flagToLongEvents();
    }

    private Map<String,DataFromFile> flagToLongEvents()
    {
        long timeDifference =0;
        long timeStarted=0;
        long timeFinished=0;
        for(Map.Entry<String,DataFromFile> oneEvent :startedEventMap.entrySet())
        {
            timeStarted =Long.parseLong(startedEventMap.get(oneEvent.getKey()).getTimestamp());
            timeFinished = Long.parseLong(finishedEventMap.get(oneEvent.getKey()).getTimestamp());
            timeDifference = timeFinished - timeStarted;
            startedEventMap.get(oneEvent.getKey()).setHowLongEventTook(timeDifference);
            if (timeDifference > 4)
            {
                startedEventMap.get(oneEvent.getKey()).setToLong(true);
            }
            else
            {
                startedEventMap.get(oneEvent.getKey()).setToLong(false);
            }
        }
        return startedEventMap;
    }
}

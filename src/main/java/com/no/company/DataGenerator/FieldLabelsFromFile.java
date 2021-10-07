package com.no.company.DataGenerator;

public enum FieldLabelsFromFile {
    id ("id"),
    state ("state"),
    type ("type"),
    host ("host"),
    timestamp("timestamp");

    private final String name;

    FieldLabelsFromFile (String name)
    {
        this.name = name;
    }

    String getName()
    {
        return name;
    }

}

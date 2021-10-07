package com.no.company.logic;

public enum FieldsFromLog {
    id ("id"),
    state ("state"),
    type ("type"),
    host ("host"),
    timestamp("timestamp");

    private final String name;

    FieldsFromLog (String name)
    {
        this.name = name;
    }

    String getName()
    {
        return name;
    }
}

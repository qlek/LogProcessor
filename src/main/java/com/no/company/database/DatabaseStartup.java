package com.no.company.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseStartup {

    public Connection connectToDb()
    {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:testdb", "SA","");
            return connection;
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
        return null;
    }
}

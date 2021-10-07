package com.no.company.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDDLOperations {

    public void createTable(Connection con )
    {
        if (con == null)
        {
            System.out.println("No connection to db, sorry ");
            return;
        }
        Statement stmt;
        try {
            stmt=con.createStatement();
            stmt.executeUpdate("CREATE TABLE events ( id INT NOT NULL, event_id VARCHAR(50) NOT NULL, event_duration INT NOT NULL, type VARCHAR(50), host VARCHAR(50), alert bit NOT NULL, PRIMARY KEY (id)); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

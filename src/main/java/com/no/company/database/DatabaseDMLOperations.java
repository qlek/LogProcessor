package com.no.company.database;

import com.no.company.logic.DataFromFile;

import java.sql.*;
import java.util.Map;

public class DatabaseDMLOperations {

    private Connection connection;

    public DatabaseDMLOperations(Connection con)
    {
        this.connection = con;
    }

    public int saveData(Map<String, DataFromFile>  eventMap)
    {
        int id=0;
        try {
            Statement stmt = null;
            id=findPrimaryKey();
            String query = "INSERT INTO events VALUES (?, ?, ?, ?, ?, ?)";
            for(Map.Entry<String,DataFromFile> oneEvent :eventMap.entrySet())
            {
                PreparedStatement pstmt = connection.prepareStatement( query );
                pstmt.setInt( 1, id);
                pstmt.setString(2,oneEvent.getKey());
                pstmt.setLong(3, oneEvent.getValue().getHowLongEventTook());
                pstmt.setString(4,oneEvent.getValue().getType());
                pstmt.setString(5,oneEvent.getValue().getHost());
                pstmt.setBoolean(6,oneEvent.getValue().isToLong());

                pstmt.executeUpdate();
                id=id+1;
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int findPrimaryKey()
    {
        ResultSet result = null;
        int lastId=0;
        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeQuery(
                "SELECT COUNT(id) FROM events");
            lastId= result.getRow();
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return lastId;
    }
}

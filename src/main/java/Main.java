import com.no.company.DataGenerator.FileWriter;
import com.no.company.database.DatabaseDDLOperations;
import com.no.company.database.DatabaseStartup;
import com.no.company.logic.ProgramLogic;

import java.sql.Connection;


public class Main {
    public static void main(String args[])
    {
        FileWriter fileWriter = new FileWriter("log.txt");
        fileWriter.writeLogDataToLogFile();

        DatabaseStartup databaseStartup = new DatabaseStartup();
        Connection con =databaseStartup.connectToDb();
        DatabaseDDLOperations databaseDDLOperations = new DatabaseDDLOperations();
        databaseDDLOperations.createTable(con);

        ProgramLogic programLogic = new ProgramLogic(con);
        programLogic.checkGivenFile(args[0]);
    }
}

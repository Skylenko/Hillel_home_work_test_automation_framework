package com.util;

import com.structure.logging.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class DbUtil {

    private static String connectionString = "jdbc:sqlite:testResults.db";

    private DbUtil() {
    }

    public static void connectToDb() throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection(connectionString, "", "");
            Logger.out.debug("Connection with DB has been established!");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Results ('Passed/Failed') VALUES ('PASSED')";
            statement.executeQuery(query);

            String dbData = "SELECT * FROM Results";
            ResultSet resultsSet = statement.executeQuery(dbData);
            System.out.println("-----------BEFORE UPDATE---------------");
            System.out.println("ID: " + resultsSet.getString("Id"));
            System.out.println("Passed/Failed" + resultsSet.getString("Passed/Failed"));

            String updateQuery = "UPDATE Results SET Passed/Failed = UPDATED 'FAILED'";
            ResultSet updateResultSet = statement.executeQuery(updateQuery);
            System.out.println("-----------AFTER UPDATE---------------");
            System.out.println("ID: " + updateResultSet.getString("Id"));
            System.out.println("Passed/Failed" + updateResultSet.getString("Passed/Failed"));


        } catch (SQLException e) {
            Logger.out.error("Something has come up while connecting to DB!", e.getStackTrace());
            throw new IllegalArgumentException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.out.error("Something has come up while connecting to DB!", e.getStackTrace());
            }
        }
    }
}

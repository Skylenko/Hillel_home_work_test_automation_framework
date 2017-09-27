package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    private static String connectionString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=TestResult.mdb;";

    private DbUtil() {
    }

    public static void connectToDb() throws SQLException {
        final Connection connection = DriverManager.getConnection(connectionString, "", "");
        Statement statement = connection.createStatement();
    }
}

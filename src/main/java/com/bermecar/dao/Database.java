package com.svalero.bermecars.dao;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import static com.svalero.bermecars.util.Constants.CONNECTION_STRING;
import static com.svalero.bermecars.util.Constants.USERNAME;
import static com.svalero.bermecars.util.Constants.PASSWORD;

import java.sql.SQLException;

public class Database {

    public static Jdbi jdbi;
    public static Handle db;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        jdbi = Jdbi.create(CONNECTION_STRING, USERNAME, PASSWORD);
        jdbi.installPlugin(new SqlObjectPlugin());
        db = jdbi.open();
    }

    public void close() throws SQLException{
        db.close();
    }
}

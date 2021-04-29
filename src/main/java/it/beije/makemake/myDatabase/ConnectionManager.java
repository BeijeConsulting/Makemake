package it.beije.makemake.myDatabase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

class ConnectionManager {

    private ConnectionManager() {
//        Class.forName("com.mysql.cj.jdbc.Driver");

    }

    private static ConnectionManager instance;
    private int availableConnections = 150;
    private List<Connection> connectionList = new ArrayList<>();

    public static ConnectionManager getConnectionManager() {
        if (instance == null) {
            instance = new ConnectionManager();
        }

        return instance;
    }

    public Connection getConnection() {
        return null;
    }




}

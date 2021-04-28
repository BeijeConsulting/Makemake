package it.beije.makemake.myDatabase;

class ConnectionManager {

    private ConnectionManager() {}

    private static ConnectionManager instance;

    public static ConnectionManager getInstance() {
        if (instance == null) instance = new ConnectionManager();

        return instance;
    }
}

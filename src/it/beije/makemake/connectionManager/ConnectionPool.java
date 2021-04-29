package it.beije.makemake.connectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private int activeConnections = 151;
	private static ConnectionPool pool;
	private List<Connection> connections = new ArrayList<>();

	private ConnectionPool() {
	}

	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	/*
	 *Returns an instance of Connection
	 *if availa
	 * 
	 */

	public Connection getConnection() throws ClassNotFoundException {
		int availableConnection = -1;
		if (activeConnections == 151) {
			for (Connection c : connections) {
				try {
					if (c.isClosed()) {
						availableConnection = connections.indexOf(c);
						break;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				connections.set(availableConnection, ConnectionManager.getInstance());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return connections.get(availableConnection);
		} else {
			try {
				connections.add(ConnectionManager.getInstance());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connections.get(activeConnections);
		}

	}
}

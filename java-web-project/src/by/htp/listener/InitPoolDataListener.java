package by.htp.listener;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.dao.exception.ConnectionPoolException;
import by.htp.dao.impl.connection_pool.ConnectionPool;

public class InitPoolDataListener implements ServletContextListener {

	public static final String PARAM_CON = "connection";

	private ServletContext context = null;

	ConnectionPool connectionPool = ConnectionPool.getInstance();

	public InitPoolDataListener() {

	}

	public void contextInitialized(ServletContextEvent event) {

		context = event.getServletContext();

		try {
			connectionPool.initPool();
			context.setAttribute(PARAM_CON, true);
			System.out.println("Context was initialized");

		} catch (ConnectionPoolException e) {
			context.setAttribute(PARAM_CON, false);
			System.out.println("Context wasn't initialized");
		}

	}

	public void contextDestroyed(ServletContextEvent event) {

		try {
			connectionPool.dispose();
		} catch (SQLException e) {

		}

	}

}

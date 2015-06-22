package persistance.oracle.transaction.connector;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OracleConnector {

	private static OracleConnector instance = new OracleConnector();

    DataSource pool;
	
	public static OracleConnector getInstance(){
		
		if(instance == null){
			/////////throw ex
		}
		return instance;
	}
	
	private OracleConnector(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e){
        	///////////log
        }
        Context env = null;
        try {
            env = (Context) new InitialContext().lookup("java:comp/env");
            pool = (DataSource) env.lookup("jdbc/kattynews");
            if(pool == null) {
            	//////log
            }
        } catch (NamingException e) {
        	///////log
        }
	}

    public Connection getConnection()
    {
        try {
            Connection connection = pool.getConnection();
            return connection;
        }
        catch (SQLException e){
            ////////throw new DAOFatalException("Cannot get connection to the database.", e);
        }
		return null;
    }

    public void closeConnection(Connection connection)
    {
    	try{
	        if(connection != null) {
	        	connection.close();
	        }
    	}
    	catch (SQLException e) {
    		//////// throw
		}
    }
}

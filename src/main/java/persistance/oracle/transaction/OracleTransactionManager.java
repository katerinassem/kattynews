package persistance.oracle.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import persistance.oracle.transaction.connector.OracleConnector;
import persistance.transaction.TransactionManager;

public class OracleTransactionManager implements TransactionManager {
	
	private static OracleTransactionManager instance = new OracleTransactionManager();
	
	private OracleConnector connector = OracleConnector.getInstance();
	private Connection currentConnection;
	
	public static OracleTransactionManager getInstance (){
		
		return instance;
	}
	
	public void startTransaction() {

		if(currentConnection != null){
			//////throw NotClosedConnection
		}
		try{
			currentConnection = connector.getConnection();
			currentConnection.setAutoCommit(false);
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public Connection getCurrentConnection() {

		return currentConnection;
	}

	public void commit() {

		if(currentConnection !=  null){
			try{
				currentConnection.commit();
			}
			catch (SQLException e) {
				// TODO: handle exception
			}
			finally{				
				connector.closeConnection(currentConnection);
				currentConnection = null;
			}
		}
	}

	public void rollback() {

		if(currentConnection !=  null){
			try{
				currentConnection.rollback();
			}
			catch (SQLException e) {
				// TODO: handle exception
			}
			finally{
				connector.closeConnection(currentConnection);
				currentConnection = null;
			}
		}
	}

	private OracleTransactionManager(){
		
	}
}

package util.jdbcbasic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistance.transaction.TransactionManager;
import util.jdbcbasic.exception.JdbcBasicException;

public class jdbcBasic {
	
	private static Logger logger = LoggerFactory.getLogger(jdbcBasic.class);
	
	private TransactionManager transactionManager;
	
	public jdbcBasic(TransactionManager transactionManager){
		
		this.transactionManager = transactionManager;
	}
	
	public int update(String query, Object[] values, int[] types) throws JdbcBasicException {
		
		logger.info("Executing query {}", query);
		
		Connection connection = null;
		PreparedStatement statement = null;
		int affectedRows = 0;
		
		try{
			connection = transactionManager.getCurrentConnection();
			statement = connection.prepareStatement(query);
			
			if(values != null){
				if(types != null){
					if(values.length == types.length){
						for(int i = 0; i < values.length; i++){
							if(values[i] != null){
								statement.setObject(i, values[i], types[i]);
							}
							else{
								statement.setNull(i, types[i]);
							}
						}
					}
					else{
						logger.info("Values and types length differ!");
					}
				}
				else{
					for(int i = 0; i < values.length; i++){
						if(values[i] != null){
							statement.setObject(i, values[i]);
						}
						else{
							throw new JdbcBasicException("Parameter at index" + i + " is null");
						}
					}
				}
			}
			
			affectedRows = statement.executeUpdate();
		}
		catch (SQLException e) {
			throw new JdbcBasicException(e);
		}
		finally{
			if(statement != null){
				try{
					statement.close();
				}
				catch (SQLException e) {
					logger.error("Cannot close the statement!");
				}
			}
		}
		
		return affectedRows;
	}
	
	public int update(String query, Object... values) throws JdbcBasicException {
		
		return update(query, values, null);
	}
	
	public int update(String query) throws JdbcBasicException {
		
		return update(query, null, null);
	}
	
	public <T> T queryForObject(String query, Object[] values, Class<T> clazz) throws JdbcBasicException {
		
		logger.info("Executing query {}", query);
		
		T object = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = transactionManager.getCurrentConnection();
			statement = connection.prepareStatement(query);
			
			if(values != null){
				for(int i = 0; i < values.length; i++){
					statement.setObject(i, values[i]);
				}
			}
			
			ResultSet rs = statement.executeQuery();
			if(rs != null && rs.next()){
				object = rs.getObject(0, clazz);
			}
		}
		catch (SQLException e) {
			throw new JdbcBasicException();
		}
		finally{
			if(statement != null){
				try{
					statement.close();
				}
				catch (SQLException e) {
					logger.error("Cannot close the statement");
				}
			}
		}		
		
		return object;
	}

	public <T> T queryForObject(String query, Class<T> clazz) throws JdbcBasicException {
		
		return queryForObject(query, null, clazz);
	}	

	public <T> T queryForObject(String query, Object[] values, RowMapper<T> rowMapper) throws JdbcBasicException {

		logger.info("Executing query {}", query);
		
		T object = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = transactionManager.getCurrentConnection();
			statement = connection.prepareStatement(query);
			
			if(values != null){
				for(int i = 0; i < values.length; i++){
					statement.setObject(i, values[i]);
				}
			}
			
			ResultSet rs = statement.executeQuery();
			if(rs != null && rs.next()){
				object = rowMapper.mapRow(rs);
			}
		}
		catch (SQLException e) {
			throw new JdbcBasicException();
		}
		finally{
			if(statement != null){
				try{
					statement.close();
				}
				catch (SQLException e) {
					logger.error("Cannot close the statement");
				}
			}
		}		
		
		return object;
	}		

	public <T> T queryForObject(String query, RowMapper<T> rowMapper) throws JdbcBasicException {
		
		return queryForObject(query, null, rowMapper);
	}

	public <T> List<T> query(String query, Object[] values, Class<T> clazz) throws JdbcBasicException {

		logger.info("Executing query {}", query);
		
		List<T> objects = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = transactionManager.getCurrentConnection();
			statement = connection.prepareStatement(query);
			
			if(values != null){
				for(int i = 0; i < values.length; i++){
					statement.setObject(i, values[i]);
				}
			}
			
			ResultSet rs = statement.executeQuery();
			if(rs != null){
				objects = new ArrayList<T>();
				while(rs.next()){
					objects.add(rs.getObject(0, clazz));
				}
			}
		}
		catch (SQLException e) {
			throw new JdbcBasicException();
		}
		finally{
			if(statement != null){
				try{
					statement.close();
				}
				catch (SQLException e) {
					logger.error("Cannot close the statement");
				}
			}
		}		
		
		return objects;
	}

	public <T> List<T> query(String query, Class<T> clazz) throws JdbcBasicException {
		
		return query(query, null, clazz);
	}

	public <T> List<T> query(String query, Object[] values, RowMapper<T> rowMapper) throws JdbcBasicException {

		logger.info("Executing query {}", query);
		
		List<T> objects = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = transactionManager.getCurrentConnection();
			statement = connection.prepareStatement(query);
			
			if(values != null){
				for(int i = 0; i < values.length; i++){
					statement.setObject(i, values[i]);
				}
			}
			
			ResultSet rs = statement.executeQuery();
			if(rs != null){
				objects = new ArrayList<T>();
				while(rs.next()){
					objects.add(rowMapper.mapRow(rs));
				}
			}
		}
		catch (SQLException e) {
			throw new JdbcBasicException();
		}
		finally{
			if(statement != null){
				try{
					statement.close();
				}
				catch (SQLException e) {
					logger.error("Cannot close the statement");
				}
			}
		}		
		
		return objects;
	}

	public <T> List<T> query(String query, RowMapper<T> rowMapper) throws JdbcBasicException {
		
		return query(query, null, rowMapper);
	}

}

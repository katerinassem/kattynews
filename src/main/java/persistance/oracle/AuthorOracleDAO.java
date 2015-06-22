package persistance.oracle;

import java.util.Arrays;
import java.util.List;
import persistance.dao.DAO;
import persistance.dao.exception.DAOException;
import persistance.oracle.transaction.OracleTransactionManager;
import persistance.transaction.TransactionManager;
import util.oracle.OracleQueryBuilder;
import util.sql.exception.QueryBuilderBadArgumentsException;
import entity.Author;


public class AuthorOracleDAO implements DAO<Author> {

	private TransactionManager transactionManager;
	
	private OracleQueryBuilder queryBuilder;
	
	public int create(Author entity) throws DAOException {

		try{
			String query = queryBuilder
				.insert("AUTHORS")
				.set(Arrays.asList("AUTHOR_ID", "AUTHOR_NAME", "EXPIRED")
						, Arrays.asList("?", "?", "?")).getQuery();
			
			///// TODO: execute query using jdbcTEMPLATE
		}
		catch (QueryBuilderBadArgumentsException e) {
			// TODO: handle exception
		}
		return 0;
	}

	public Author read(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Author entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Author> readAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public AuthorOracleDAO( OracleTransactionManager oracleTransactionManager){
		
		this.transactionManager = oracleTransactionManager;
		queryBuilder = new OracleQueryBuilder();
	}

}

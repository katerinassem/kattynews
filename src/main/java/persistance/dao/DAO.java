package persistance.dao;

import java.util.List;
import persistance.dao.exception.DAOException;

public interface DAO <T> {
	
	int create (T entity) throws DAOException;
	T read (int id) throws DAOException;
	boolean update (T entity) throws DAOException;
	boolean delete (int id) throws DAOException;
	List<T> readAll () throws DAOException;
}

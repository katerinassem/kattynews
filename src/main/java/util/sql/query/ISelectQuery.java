package util.sql.query;

import java.util.List;
import util.sql.clause.ISelectedClause;
import util.sql.exception.QueryBuilderBadArgumentsException;

public interface ISelectQuery {

	ISelectedClause all(String tableName) throws QueryBuilderBadArgumentsException;
	ISelectedClause columns(String tableName, List<String> columnNames) throws QueryBuilderBadArgumentsException;
}

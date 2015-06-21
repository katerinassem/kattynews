package util.sql;

import util.sql.clause.IWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IInsertQuery;
import util.sql.query.ISelectQuery;
import util.sql.query.IUpdateQuery;

public interface QueryBuilder {	
	
	IWhereClause delete(String tableName) throws QueryBuilderBadArgumentsException;
	IUpdateQuery update(String tableName) throws QueryBuilderBadArgumentsException;
	IInsertQuery insert(String tableName) throws QueryBuilderBadArgumentsException;
	ISelectQuery select();
}

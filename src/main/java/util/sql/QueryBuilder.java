package util.sql;

import util.sql.clause.IWhereClause;
import util.sql.query.IInsertQuery;
import util.sql.query.ISelectQuery;
import util.sql.query.IUpdateQuery;

public interface QueryBuilder {	
	
	IWhereClause delete(String tableName);
	IUpdateQuery update(String tableName);
	IInsertQuery insert(String tableName);
	ISelectQuery select();
}

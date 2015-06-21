package util.sql.clause;

import util.sql.query.IExecutableQuery;

public interface IConditionClause extends IExecutableQuery {

	IConditionClause or(String columnName, String value);
	IConditionClause and(String columnName, String value);
}

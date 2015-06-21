package util.sql.clause;

import util.sql.ComparisonSignType;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IExecutableQuery;

public interface IConditionClause extends IExecutableQuery {

	IConditionClause or(String columnName, ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException;
	IConditionClause and(String columnName, ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException;
}

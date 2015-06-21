package util.sql.clause;

import util.sql.ComparisonSignType;
import util.sql.exception.QueryBuilderBadArgumentsException;

public interface ISelectedWhereClause extends IConditionClause, IGroupByClause, IOrderByClause {

	ISelectedWhereClause or(String columnName, ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException;
	ISelectedWhereClause and(String columnName, ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException;
}

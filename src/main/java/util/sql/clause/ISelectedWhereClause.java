package util.sql.clause;

import util.sql.ComparisonSignType;

public interface ISelectedWhereClause extends IConditionClause, IGroupByClause, IOrderByClause {

	ISelectedWhereClause or(String columnName, ComparisonSignType comparisonSignType, String value);
	ISelectedWhereClause and(String columnName, ComparisonSignType comparisonSignType, String value);
}

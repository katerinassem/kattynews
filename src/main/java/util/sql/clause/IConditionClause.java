package util.sql.clause;

import util.sql.ComparisonSignType;
import util.sql.query.IExecutableQuery;

public interface IConditionClause extends IExecutableQuery {

	IConditionClause or(String columnName, ComparisonSignType comparisonSignType, String value);
	IConditionClause and(String columnName, ComparisonSignType comparisonSignType, String value);
}

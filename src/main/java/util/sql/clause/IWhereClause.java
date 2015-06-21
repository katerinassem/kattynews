package util.sql.clause;

import util.sql.ComparisonSignType;
import util.sql.query.IExecutableQuery;

public interface IWhereClause extends IExecutableQuery {

	IConditionClause where(String columnName, ComparisonSignType comparisonSignType, String value);
}

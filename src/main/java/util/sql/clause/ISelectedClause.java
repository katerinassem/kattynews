package util.sql.clause;

import util.sql.ComparisonSignType;

public interface ISelectedClause extends IWhereClause, IGroupByClause, IOrderByClause {

	ISelectedWhereClause where(String columnName, ComparisonSignType comparisonSignType, String value);
}

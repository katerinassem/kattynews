package util.sql.clause;

import util.sql.ComparisonSignType;
import util.sql.exception.QueryBuilderBadArgumentsException;

public interface ISelectedClause extends IWhereClause, IGroupByClause, IOrderByClause {

	ISelectedWhereClause where(String columnName, ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException;
}

package util.sql.clause;

import java.util.List;

import util.sql.OrderingType;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IExecutableQuery;

public interface IOrderByClause extends IExecutableQuery {
	
	IExecutableQuery orderBy(List<String> columnNames, List<OrderingType> orderingTypes) throws QueryBuilderBadArgumentsException;
}

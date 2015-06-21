package util.sql.clause;

import java.util.List;

import util.sql.exception.QueryBuilderBadArgumentsException;

public interface IGroupByClause {

	IOrderByClause groupBy(List<String> columnNames) throws QueryBuilderBadArgumentsException;
}

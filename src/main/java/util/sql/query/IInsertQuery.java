package util.sql.query;

import java.util.List;

import util.sql.exception.QueryBuilderBadArgumentsException;

public interface IInsertQuery {

	IExecutableQuery set(List<String> columnNames, List<String> values) throws QueryBuilderBadArgumentsException;
}

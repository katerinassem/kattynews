package util.sql.query;

import java.util.List;
import util.sql.clause.IWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;

public interface IUpdateQuery {

	IWhereClause set(List<String> columnNames, List<String> values) throws QueryBuilderBadArgumentsException;
}

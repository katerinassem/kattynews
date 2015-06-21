package util.sql.query;

import java.util.List;

import util.sql.clause.IWhereClause;

public interface ISelectQuery {

	IWhereClause all(String tableName);
	IWhereClause columns(String tableName, List<String> columnNames);
}

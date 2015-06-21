package util.sql.query;

import java.util.List;
import util.sql.clause.ISelectedClause;

public interface ISelectQuery {

	ISelectedClause all(String tableName);
	ISelectedClause columns(String tableName, List<String> columnNames);
}

package util.sql.clause;

import java.util.List;

public interface IGroupByClause {

	IOrderByClause groupBy(List<String> columnNames);
}

package util.sql.query;

import java.util.List;

public interface IInsertQuery {

	IExecutableQuery set(List<String> columnNames, List<String> values);
}

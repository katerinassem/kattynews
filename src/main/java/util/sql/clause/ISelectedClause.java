package util.sql.clause;

public interface ISelectedClause extends IWhereClause {

	ISelectedClause orderBy(String columnName);
	ISelectedClause groupBy(String columnName);
}

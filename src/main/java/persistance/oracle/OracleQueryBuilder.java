package persistance.oracle;

import persistance.oracle.clause.OracleWhereClause;
import persistance.oracle.query.OracleInsertQuery;
import persistance.oracle.query.OracleSelectQuery;
import persistance.oracle.query.OracleUpdateQuery;
import util.sql.QueryBuilder;
import util.sql.clause.IWhereClause;
import util.sql.query.IInsertQuery;
import util.sql.query.ISelectQuery;
import util.sql.query.IUpdateQuery;

public class OracleQueryBuilder implements QueryBuilder {

	public IWhereClause delete(String tableName) {

		StringBuilder sql = new StringBuilder("DELETE FROM ")
			.append(tableName);
		return new OracleWhereClause(sql);
	}

	public IUpdateQuery update(String tableName) {
		
		StringBuilder sql = new StringBuilder("UPDATE ")
			.append(tableName);
		return new OracleUpdateQuery(sql);
	}

	public IInsertQuery insert(String tableName) {
		
		StringBuilder sql = new StringBuilder("INSERT INTO ")
			.append(tableName);
		return new OracleInsertQuery(sql);
	}

	public ISelectQuery select() {

		return new OracleSelectQuery(new StringBuilder());
	}

}
package persistance.oracle.query;

import util.sql.query.IExecutableQuery;

public class OracleExecutableQuery extends AbstractQuery implements IExecutableQuery {

	public String getQuery() {
		return sql.toString();
	}
	
	public OracleExecutableQuery(StringBuilder sql) {
		super(sql);
	}

}

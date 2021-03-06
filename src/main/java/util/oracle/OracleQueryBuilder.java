package util.oracle;

import org.apache.commons.lang3.StringUtils;
import util.oracle.clause.OracleWhereClause;
import util.oracle.query.OracleInsertQuery;
import util.oracle.query.OracleSelectQuery;
import util.oracle.query.OracleUpdateQuery;
import util.sql.QueryBuilder;
import util.sql.clause.IWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IInsertQuery;
import util.sql.query.ISelectQuery;
import util.sql.query.IUpdateQuery;

public class OracleQueryBuilder implements QueryBuilder {

	public IWhereClause delete(String tableName) throws QueryBuilderBadArgumentsException {
		
		if(StringUtils.isEmpty(tableName)){
			throw new QueryBuilderBadArgumentsException();
		}
		StringBuilder sql = new StringBuilder("DELETE FROM ")
			.append(tableName);
		return new OracleWhereClause(sql);
	}

	public IUpdateQuery update(String tableName) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(tableName)){
			throw new QueryBuilderBadArgumentsException();
		}
		StringBuilder sql = new StringBuilder("UPDATE ")
			.append(tableName);
		return new OracleUpdateQuery(sql);
	}

	public IInsertQuery insert(String tableName) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(tableName)){
			throw new QueryBuilderBadArgumentsException();
		}
		StringBuilder sql = new StringBuilder("INSERT INTO ")
			.append(tableName);
		return new OracleInsertQuery(sql);
	}

	public ISelectQuery select() {

		return new OracleSelectQuery(new StringBuilder());
	}

}

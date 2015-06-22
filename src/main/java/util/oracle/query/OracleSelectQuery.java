package util.oracle.query;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import util.oracle.clause.OracleSelectedClause;
import util.sql.clause.ISelectedClause;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.ISelectQuery;

public class OracleSelectQuery extends AbstractQuery implements ISelectQuery {

	public ISelectedClause all(String tableName) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(tableName)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" SELECT * FROM ").append(tableName);
		return new OracleSelectedClause(this.sql);
	}

	public ISelectedClause columns(String tableName, List<String> columnNames) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(tableName)
				|| CollectionUtils.isEmpty(columnNames)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" SELECT ");
		for(int i = 0; i < columnNames.size(); i++){
			if(i != 0){
				this.sql.append(", ");
			}
			this.sql.append(columnNames.get(i));
		}
		this.sql.append(" FROM ").append(tableName);
		return new OracleSelectedClause(this.sql);
	}

	public OracleSelectQuery(StringBuilder sql) {
		super(sql);
	}
}

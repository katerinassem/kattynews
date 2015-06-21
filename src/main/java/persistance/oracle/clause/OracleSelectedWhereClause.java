package persistance.oracle.clause;

import org.apache.commons.lang3.StringUtils;

import util.sql.ComparisonSignType;
import util.sql.clause.ISelectedWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;

public class OracleSelectedWhereClause extends OracleSelectedClause implements ISelectedWhereClause {

	public OracleSelectedWhereClause(StringBuilder sql) {
		super(sql);
	}

	public ISelectedWhereClause or(String columnName,
			ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(columnName)
				|| StringUtils.isEmpty(value)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" OR ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleSelectedWhereClause(this.sql);
	}

	public ISelectedWhereClause and(String columnName,
			ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(columnName)
				|| StringUtils.isEmpty(value)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" AND ").append(columnName)
			.append(comparisonSignType)	
			.append(value);
		return  new OracleSelectedWhereClause(this.sql);
	}

}

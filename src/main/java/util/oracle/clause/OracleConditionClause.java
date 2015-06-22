package util.oracle.clause;

import org.apache.commons.lang3.StringUtils;

import util.oracle.query.OracleExecutableQuery;
import util.sql.ComparisonSignType;
import util.sql.clause.IConditionClause;
import util.sql.exception.QueryBuilderBadArgumentsException;

public class OracleConditionClause extends OracleExecutableQuery implements IConditionClause {

	public OracleConditionClause(StringBuilder sql) {
		super(sql);
	}

	public IConditionClause or(String columnName,
			ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException {
		
		if(StringUtils.isEmpty(columnName) 
				|| StringUtils.isEmpty(value)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" OR ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleConditionClause(this.sql);
	}

	public IConditionClause and(String columnName,
			ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(columnName) 
				|| StringUtils.isEmpty(value)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" AND ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return  new OracleConditionClause(this.sql);
	}

}

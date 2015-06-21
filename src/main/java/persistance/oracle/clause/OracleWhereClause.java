package persistance.oracle.clause;

import org.apache.commons.lang3.StringUtils;

import persistance.oracle.query.OracleExecutableQuery;
import util.sql.ComparisonSignType;
import util.sql.clause.IConditionClause;
import util.sql.clause.IWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;

public class OracleWhereClause extends OracleExecutableQuery implements IWhereClause {

	public OracleWhereClause(StringBuilder sql) {
		super(sql);
	}

	public IConditionClause where(String columnName,
			ComparisonSignType comparisonSignType, String value) throws QueryBuilderBadArgumentsException {

		if(StringUtils.isEmpty(columnName)
				|| StringUtils.isEmpty(value)){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleConditionClause(this.sql);
	}

	
}

package persistance.oracle.clause;

import persistance.oracle.query.OracleExecutableQuery;
import util.sql.ComparisonSignType;
import util.sql.clause.IConditionClause;

public class OracleConditionClause extends OracleExecutableQuery implements IConditionClause {

	public OracleConditionClause(StringBuilder sql) {
		super(sql);
	}

	public IConditionClause or(String columnName,
			ComparisonSignType comparisonSignType, String value) {
		
		this.sql.append(" OR ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleConditionClause(this.sql);
	}

	public IConditionClause and(String columnName,
			ComparisonSignType comparisonSignType, String value) {
		
		this.sql.append(" AND ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return  new OracleConditionClause(this.sql);
	}

}

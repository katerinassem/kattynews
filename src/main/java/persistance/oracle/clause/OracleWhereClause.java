package persistance.oracle.clause;

import persistance.oracle.query.OracleExecutableQuery;
import util.sql.ComparisonSignType;
import util.sql.clause.IConditionClause;
import util.sql.clause.IWhereClause;

public class OracleWhereClause extends OracleExecutableQuery implements IWhereClause {

	public OracleWhereClause(StringBuilder sql) {
		super(sql);
	}

	public IConditionClause where(String columnName,
			ComparisonSignType comparisonSignType, String value) {

		this.sql.append(" ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleConditionClause(this.sql);
	}

	
}

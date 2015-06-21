package persistance.oracle.clause;

import util.sql.ComparisonSignType;
import util.sql.clause.ISelectedWhereClause;

public class OracleSelectedWhereClause extends OracleSelectedClause implements ISelectedWhereClause {

	public OracleSelectedWhereClause(StringBuilder sql) {
		super(sql);
	}

	public ISelectedWhereClause or(String columnName,
			ComparisonSignType comparisonSignType, String value) {

		this.sql.append(" OR ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleSelectedWhereClause(this.sql);
	}

	public ISelectedWhereClause and(String columnName,
			ComparisonSignType comparisonSignType, String value) {

		this.sql.append(" AND ").append(columnName)
			.append(comparisonSignType)	
			.append(value);
		return  new OracleSelectedWhereClause(this.sql);
	}

}

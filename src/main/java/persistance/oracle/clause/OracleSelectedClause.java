package persistance.oracle.clause;

import java.util.List;

import persistance.oracle.query.OracleExecutableQuery;

import util.sql.ComparisonSignType;
import util.sql.OrderingType;
import util.sql.clause.IOrderByClause;
import util.sql.clause.ISelectedClause;
import util.sql.clause.ISelectedWhereClause;
import util.sql.query.IExecutableQuery;

public class OracleSelectedClause extends OracleWhereClause implements ISelectedClause {

	public ISelectedWhereClause where(String columnName,
			ComparisonSignType comparisonSignType, String value) {

		this.sql.append(" ").append(columnName)
			.append(comparisonSignType)
			.append(value);
		return new OracleSelectedWhereClause(this.sql);
	}

	public IOrderByClause groupBy(List<String> columnNames) {
		
		if(columnNames != null && columnNames.size() > 0){
			this.sql.append(" GROUP BY ");
			for(int i = 0; i < columnNames.size(); i++){
				if(i != 0){
					this.sql.append(", ");
				}
				this.sql.append(columnNames.get(i));
			}
		}
		return new OracleOrderByClause(this.sql);
	}

	public IExecutableQuery orderBy(List<String> columnNames,
			List<OrderingType> orderingTypes) {

//TODO: BAAAAAAAAAAAAAAAAAAD!!!
		
		if(columnNames != null && columnNames.size() > 0){
			this.sql.append(" ORDER BY ");
			for(int i = 0; i < columnNames.size(); i++){
				if(i != 0){
					this.sql.append(", ");
				}
				this.sql.append(columnNames.get(i))
					.append(" ").append(orderingTypes.get(i));
			}
		}
		return new OracleExecutableQuery(this.sql);
	}

	public OracleSelectedClause(StringBuilder sql) {
		super(sql);
	}

}

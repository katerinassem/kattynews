package persistance.oracle.clause;

import java.util.List;

import persistance.oracle.query.OracleExecutableQuery;
import util.sql.OrderingType;
import util.sql.clause.IOrderByClause;
import util.sql.query.IExecutableQuery;

public class OracleOrderByClause extends OracleExecutableQuery implements IOrderByClause {

	public OracleOrderByClause(StringBuilder sql) {
		super(sql);
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

}

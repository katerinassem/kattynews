package persistance.oracle.query;

import java.util.List;

import persistance.oracle.clause.OracleWhereClause;
import util.sql.clause.IWhereClause;
import util.sql.query.IUpdateQuery;

public class OracleUpdateQuery extends AbstractQuery implements IUpdateQuery {
	
	public IWhereClause set(List<String> columnNames, List<String> values) {
///////		
		this.sql.append(" SET ");
		for(int i = 0; i < columnNames.size(); i++){
			if(i != 0){
				this.sql.append(", ");
			}
			this.sql.append(columnNames.get(i))
				.append("=").append(values.get(i));
		}		
		return new OracleWhereClause(this.sql);
	}
	
	public OracleUpdateQuery(StringBuilder sql) {
		super(sql);
	}
}

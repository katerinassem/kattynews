package persistance.oracle.query;

import java.util.List;
import persistance.oracle.clause.OracleSelectedClause;
import util.sql.clause.ISelectedClause;
import util.sql.query.ISelectQuery;

public class OracleSelectQuery extends AbstractQuery implements ISelectQuery {

	public ISelectedClause all(String tableName) {

		this.sql.append(" SELECT * FROM ").append(tableName);
		return new OracleSelectedClause(this.sql);
	}

	public ISelectedClause columns(String tableName, List<String> columnNames) {
///////////////////////////		
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

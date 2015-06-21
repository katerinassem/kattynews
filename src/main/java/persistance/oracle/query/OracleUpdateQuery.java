package persistance.oracle.query;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import persistance.oracle.clause.OracleWhereClause;
import util.sql.clause.IWhereClause;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IUpdateQuery;

public class OracleUpdateQuery extends AbstractQuery implements IUpdateQuery {
	
	public IWhereClause set(List<String> columnNames, List<String> values) throws QueryBuilderBadArgumentsException {

		if(CollectionUtils.isEmpty(columnNames) 
				|| CollectionUtils.isEmpty(values)
				|| columnNames.size() != values.size()){
			throw new QueryBuilderBadArgumentsException();
		}
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

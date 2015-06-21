package persistance.oracle.query;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import persistance.oracle.clause.OracleWhereClause;

import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IExecutableQuery;
import util.sql.query.ISimpleInsertQuery;

public class OracleInsertQuery extends AbstractQuery implements ISimpleInsertQuery {

	public IExecutableQuery set(List<String> columnNames, List<String> values) throws QueryBuilderBadArgumentsException {
		
		if(CollectionUtils.isEmpty(columnNames)
				|| CollectionUtils.isEmpty(values)
				|| columnNames.size() != values.size()){
			throw new QueryBuilderBadArgumentsException();
		}
		this.sql.append(" (");
		for(int i = 0; i < columnNames.size(); i++){
			if(i != 0){
				this.sql.append(", ");
			}
			this.sql.append(columnNames.get(i));
		}		
		this.sql.append(") VALUES (");
		for(int i = 0; i < values.size(); i++){
			if(i != 0){
				this.sql.append(", ");
			}
			this.sql.append(values.get(i));
		}		
		this.sql.append(") ");
		return new OracleWhereClause(this.sql);
	}

	public OracleInsertQuery(StringBuilder sql) {
		super(sql);
	}

}

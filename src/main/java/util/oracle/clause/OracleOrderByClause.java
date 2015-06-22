package util.oracle.clause;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import util.oracle.query.OracleExecutableQuery;
import util.sql.OrderingType;
import util.sql.clause.IOrderByClause;
import util.sql.exception.QueryBuilderBadArgumentsException;
import util.sql.query.IExecutableQuery;

public class OracleOrderByClause extends OracleExecutableQuery implements IOrderByClause {

	public OracleOrderByClause(StringBuilder sql) {
		super(sql);
	}

	public IExecutableQuery orderBy(List<String> columnNames,
			List<OrderingType> orderingTypes) throws QueryBuilderBadArgumentsException {
		
//TODO: BAAAAAAAAAAAAAAAAAAD!!!
		
		if(CollectionUtils.isEmpty(columnNames)
				|| CollectionUtils.isEmpty(orderingTypes)
				|| columnNames.size() != orderingTypes.size()){
			throw new QueryBuilderBadArgumentsException();
		}
		
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

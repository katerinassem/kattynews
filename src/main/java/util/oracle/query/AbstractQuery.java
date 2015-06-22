package util.oracle.query;

public abstract class AbstractQuery {
	
	protected StringBuilder sql;
	
	public AbstractQuery(StringBuilder sql){
		this.sql = sql;
	}
}

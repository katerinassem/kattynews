package util.sql;

public enum ComparisonSignType {

	EQUALS,
	NOT_EQUALS,
	GREATER,
	LESS,
	GREATER_OR_EQUALS,
	LESS_OR_EQUALS;

	@Override
	public String toString() {
		switch (this) {
		 
			default:
			case EQUALS:
				return "=";
			case NOT_EQUALS:
				return "!=";
			case GREATER:
				return ">";
			case LESS:
				return "<";
			case GREATER_OR_EQUALS:
				return ">=";
			case LESS_OR_EQUALS:
				return "<=";
		}
	}	
	
}

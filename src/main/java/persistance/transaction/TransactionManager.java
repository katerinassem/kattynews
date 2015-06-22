package persistance.transaction;

import java.sql.Connection;

public interface TransactionManager {

	void startTransaction ();
	Connection getCurrentConnection ();
	void commit ();
	void rollback ();
}

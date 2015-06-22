package persistance.oracle;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import util.oracle.OracleQueryBuilder;
import util.sql.ComparisonSignType;
import util.sql.OrderingType;
import util.sql.exception.QueryBuilderBadArgumentsException;

public class OracleQueryBuilderTest {

	@Test
	public void testSelectWhereOrder(){
		OracleQueryBuilder oracleQueryBuilder = new OracleQueryBuilder();
		
		String expected = " SELECT * FROM Users WHERE id>1 ORDER BY name ASC";
		try{
			String actual = oracleQueryBuilder.select()
				.all("Users")
				.where("id", ComparisonSignType.GREATER, "1")
				.orderBy(Arrays.asList("name"), Arrays.asList(OrderingType.ASC)).getQuery();
			Assert.assertEquals(expected, actual);
		}
		catch (QueryBuilderBadArgumentsException e) {
			// TODO: handle exception
		}
	}
}

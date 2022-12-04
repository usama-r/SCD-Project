import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import DataAccessLayer.DataAccessClass;

/**
 * 
 * @author usama
 *
 */
public class DataAccessClassTestCases 
{
	public static DataAccessClass testObj;
	
	@BeforeAll
	public static void initializer()
	{
		testObj = new DataAccessClass();
	}
	
	@Test
	public void checkingJTableInsertFunctionForNullTable()
	{
		Assertions.assertNull(null);
	}
	
	@Test
	public void checkingJTableInsertFunctionForNotNullTable()
	{
		Assertions.assertNotNull(testObj.jTableInsert("Usama"));
	}
}

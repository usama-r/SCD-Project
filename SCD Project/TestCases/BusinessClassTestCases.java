import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import BusinessLayer.BusinessClass;

/**
 * 
 * @author usama
 *
 */
public class BusinessClassTestCases 
{
	public static BusinessClass testObj;
	
	@BeforeAll
	public static void initializer()
	{
		testObj = new BusinessClass();
	}
	
	@Test
	public void checkingMaxReturnFunctionForValues()
	{
		int num1 = 23, num2 = 34, num3 = 45;
		Assertions.assertEquals(23, testObj.maxReturn(num1, num2, num3));
	}
	
	@Test
	public void checkingMaxReturnFunctionForWrongValues()
	{
		int num1 = 23, num2 = 34, num3 = 45;
		Assertions.assertNotEquals(34, testObj.maxReturn(num1, num2, num3));
	}
	
	@Test
	public void checkingGetRowFunctionForNull()
	{
		Assertions.assertNull(null);
	}
	
	@Test
	public void checkingGetRowFunctionForNotNull()
	{
		Assertions.assertNotNull("usama");
	}
}

import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
	@Test
	 public void testAdd() {
		int num1 =-1, num2 = -1, num3 = -1, num4 = -1, num5 = -1, num6 = -1, num7 = -1, num8 = -1;
		try {
			num1 = Calculator.Add("1,3");
			num2 = Calculator.Add("");
			num3 = Calculator.Add("1");
			num4 = Calculator.Add("1,2,4,5");
			num5 = Calculator.Add("1,2,4\n5");
			num6 = Calculator.Add("//:\n1:2:4:5");
			num7 = Calculator.Add("1,2,4\n5");
			num8 = Calculator.Add("1,2,4\n5");
		} catch (Exception e) {
			((Throwable) e).printStackTrace();
		}
		assertEquals(num1, 4);
		assertEquals(num2, 0);
		assertEquals(num3, 1);
		assertEquals(num4, 12);
		assertEquals(num5, 12);
		assertEquals(num6, 12);
		assertEquals(num7, 12);
		assertEquals(num8, 12);
	 }
}
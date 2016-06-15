package hr.fer.zemris.java.custom.scripting.exec;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for {@code ValueWrapper} class.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see ValueWrapper
 */
@SuppressWarnings("javadoc")
public class ValueWrapperTest {

	@Test
	public void testConstructor() {
		new ValueWrapper(null);
		new ValueWrapper(new Integer(5));
		new ValueWrapper(new Double(4.2) );
		new ValueWrapper(new Float(3.21f));
		new ValueWrapper("dasdadasd da");
	}

/********************* increment(Object) tests ****************************************/
	
	
	// String increment tests
	
	@Test
	public void testIncrementStringString_DoubleDouble() {
		String num1 = "31.14";
		String num2 = "8923.20";
		
		ValueWrapper expected = new ValueWrapper(new Double(31.14 + 8923.20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementStringString_IntegerInteger() {
		String num1 = "5";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Integer(5 - 35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementStringString_DoubleInteger() {
		String num1 = "5.75";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Double(5.75 - 35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementStringNull_DoubleNull() {
		String num1 = "5.9218";
		String num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(5.9218));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementNullString_NullInteger() {
		String num1 = null;
		String num2 = "2323423";
		
		ValueWrapper expected = new ValueWrapper(new Integer(2323423));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	// Double increment tests
	
	@Test
	public void testIncrementDoubleDouble() {
		Double num1 = new Double(3.14);
		Double num2 = new Double(-7.32);
		
		ValueWrapper expected = new ValueWrapper(new Double(3.14 - 7.32));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementDoubleNull() {
		Double num1 = new Double(-902.34);
		Double num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(-902.34));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementNullDouble() {
		Double num1 = null;
		Double num2 = new Double(32132.32132);
		
		ValueWrapper expected = new ValueWrapper(new Double(32132.32132));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	// Integer increment tests
	
	@Test
	public void testIncrementIntegerInteger() {
		Integer num1 = new Integer(2);
		Integer num2 = new Integer(-9);
		
		ValueWrapper expected = new ValueWrapper(new Integer(-7));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementNullInteger() {
		Integer num1 = null;
		Integer num2 = new Integer(-20);
		
		ValueWrapper expected = new ValueWrapper(new Integer(-20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIncrementIntegerNull() {
		Integer num1 = new Integer(56);
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(56));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	// null increment tests
	
	@Test
	public void testIncrementNullNull() {
		Integer num1 = null;
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 + 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}

/********************* decrement(Object) tests ****************************************/

	// String decrement tests

	@Test
	public void testDecrementStringString_DoubleDouble() {
		String num1 = "31.1";
		String num2 = "89.20";
		
		ValueWrapper expected = new ValueWrapper(new Double(31.1 - 89.20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementStringString_IntegerInteger() {
		String num1 = "5";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Integer(5 + 35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementStringString_DoubleInteger() {
		String num1 = "5.75";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Double(5.75 + 35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementStringNull_DoubleNull() {
		String num1 = "5.9218";
		String num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(5.9218));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementNullString_NullInteger() {
		String num1 = null;
		String num2 = "2323423";
		
		ValueWrapper expected = new ValueWrapper(new Integer(-2323423));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	// Double decrement tests
	
	@Test
	public void testDecrementDoubleDouble() {
		Double num1 = new Double(3.14);
		Double num2 = new Double(-7.32);
		
		ValueWrapper expected = new ValueWrapper(new Double(3.14 + 7.32));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementDoubleNull() {
		Double num1 = new Double(-902.34);
		Double num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(-902.34));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementNullDouble() {
		Double num1 = null;
		Double num2 = new Double(32132.32132);
		
		ValueWrapper expected = new ValueWrapper(new Double(-32132.32132));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	// Integer decrement tests
	
	@Test
	public void testDecrementIntegerInteger() {
		Integer num1 = new Integer(2);
		Integer num2 = new Integer(-9);
		
		ValueWrapper expected = new ValueWrapper(new Integer(2 + 9));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementNullInteger() {
		Integer num1 = null;
		Integer num2 = new Integer(-20);
		
		ValueWrapper expected = new ValueWrapper(new Integer(20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDecrementIntegerNull() {
		Integer num1 = new Integer(56);
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(56));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}
	
	// null decrement tests
	
	@Test
	public void testDecrementNullNull() {
		Integer num1 = null;
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 - 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.decrement(num2);
		
		assertEquals(expected, actual);
	}

/********************* multiply(Object) tests *****************************************/

	// String multiply tests

	@Test
	public void testMultiplyStringString_DoubleDouble() {
		String num1 = "31.1";
		String num2 = "89.20";
		
		ValueWrapper expected = new ValueWrapper(new Double(31.1 * 89.20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyStringString_IntegerInteger() {
		String num1 = "5";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Integer(5 * -35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyStringString_DoubleInteger() {
		String num1 = "5.75";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Double(5.75 * -35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyStringNull_DoubleNull() {
		String num1 = "5.9218";
		String num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(5.9218 * 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyNullString_NullInteger() {
		String num1 = null;
		String num2 = "2323423";
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 * 2323423));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	// Double multiply tests
	
	@Test
	public void testMultiplyDoubleDouble() {
		Double num1 = new Double(3.14);
		Double num2 = new Double(-7.32);
		
		ValueWrapper expected = new ValueWrapper(new Double(3.14 * -7.32));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyDoubleNull() {
		Double num1 = new Double(-902.34);
		Double num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(-902.34 * 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyNullDouble() {
		Double num1 = null;
		Double num2 = new Double(32132.32132);
		
		ValueWrapper expected = new ValueWrapper(new Double(0 * 32132.32132));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	// Integer multiply tests
	
	@Test
	public void testMultiplyIntegerInteger() {
		Integer num1 = new Integer(2);
		Integer num2 = new Integer(-9);
		
		ValueWrapper expected = new ValueWrapper(new Integer(2 * -9));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyNullInteger() {
		Integer num1 = null;
		Integer num2 = new Integer(-20);
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 * -20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyIntegerNull() {
		Integer num1 = new Integer(56);
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(56 * 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
	// null multiply tests
	
	@Test
	public void testMultiplyNullNull() {
		Integer num1 = null;
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 * 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.multiply(num2);
		
		assertEquals(expected, actual);
	}
	
/********************* divide(Object) tests ******************************************/

	// String divide tests

	@Test
	public void testDivideStringString_DoubleDouble() {
		String num1 = "31.1";
		String num2 = "89.20";
		
		ValueWrapper expected = new ValueWrapper(new Double(31.1 / 89.20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideStringString_IntegerInteger() {
		String num1 = "5";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Integer(5 / -35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideStringString_DoubleInteger() {
		String num1 = "5.75";
		String num2 = "-35";
		
		ValueWrapper expected = new ValueWrapper(new Double(5.75 / -35));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideStringNull_DoubleNull() {
		String num1 = "5.9218";
		String num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(5.9218 / 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideNullString_NullInteger() {
		String num1 = null;
		String num2 = "2323423";
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 / 2323423));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	// Double divide tests
	
	@Test
	public void testDivideDoubleDouble() {
		Double num1 = new Double(3.14);
		Double num2 = new Double(-7.32);
		
		ValueWrapper expected = new ValueWrapper(new Double(3.14 / -7.32));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideDoubleNull() {
		Double num1 = new Double(-902.34);
		Double num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Double(-902.34 / 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideNullDouble() {
		Double num1 = null;
		Double num2 = new Double(32132.32132);
		
		ValueWrapper expected = new ValueWrapper(new Double(0 / 32132.32132));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	// Integer divide tests
	
	@Test
	public void testDivideIntegerInteger() {
		Integer num1 = new Integer(2);
		Integer num2 = new Integer(-9);
		
		ValueWrapper expected = new ValueWrapper(new Integer(2 / -9));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideNullInteger() {
		Integer num1 = null;
		Integer num2 = new Integer(-20);
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 / -20));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivideIntegerNull() {
		Integer num1 = new Integer(56);
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(56 / 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.divide(num2);
		
		assertEquals(expected, actual);
	}
	
	// null divide tests
	
	@Test(expected = ArithmeticException.class)
	public void testDivideNullNull() {
		Integer num1 = null;
		Integer num2 = null;
		
		ValueWrapper expected = new ValueWrapper(new Integer(0 / 0));
		ValueWrapper actual = new ValueWrapper(num1);
		
		new ValueWrapper(num1).divide(num2);
		
		assertEquals(expected, actual);
	}
	
/********************* string fail tests *********************************************/
	
	@Test(expected = RuntimeException.class)
	public void testIncrementStringString_FailDouble() {
		String num1 = "fail";
		String num2 = "8923.20";

		new ValueWrapper(num1).increment(num2);
	}
	
	@Test(expected = RuntimeException.class)
	public void testDecrementStringString_IntegerFail() {
		String num1 = "32";
		String num2 = "asc";

		new ValueWrapper(num1).decrement(num2);
	}
	
/********************* other objects fail tests *************************************/
	
	@Test(expected = RuntimeException.class)
	public void testIncrementStringFloat() {
		String num1 = "32";
		Float num2 = new Float(32.321f);
		
		ValueWrapper expected = new ValueWrapper(new Float(32 + 32.321f));
		ValueWrapper actual = new ValueWrapper(num1);
		
		actual.increment(num2);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = RuntimeException.class)
	public void testMultiplyByteInteger() {
		Byte num1 = new Byte((byte) 120);
		Integer num2 = new Integer(3);
		
		new ValueWrapper(num1).multiply(num2);

	}
	
/********************* numCompare(Object) tests ***************************************/	
	
	@Test
	public void testNumCompare_IntegerInteger() {
		ValueWrapper num = new ValueWrapper(new Integer(5));
		
		Integer same = new Integer(5);
		Integer small = new Integer(-4);
		Integer large = new Integer(19);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_DoubleDouble() {
		ValueWrapper num = new ValueWrapper(new Double(2.44442));
		
		Double same = new Double(2.44442);
		Double small = new Double(-402.213);
		Double large = new Double(192.21);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_StringString() {
		ValueWrapper num = new ValueWrapper("88.312");
		
		String same = "88.312";
		String small = "-3123";
		String large = "1000.0001";
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}

	@Test
	public void testNumCompare_IntegerDouble() {
		ValueWrapper num = new ValueWrapper(new Integer(45));
		
		Double same = new Double(45);
		Double small = new Double(-42.213);
		Double large = new Double(1922.21);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_DoubleInteger() {
		ValueWrapper num = new ValueWrapper(new Double(432.0));
		
		Integer same = new Integer(432);
		Integer small = new Integer(-432);
		Integer large = new Integer(19123);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_DoubleString() {
		ValueWrapper num = new ValueWrapper(new Double(43232.0));
		
		String same = "43232";
		String small = "-0";
		String large = "99320023.23324";
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_StringDouble() {
		ValueWrapper num = new ValueWrapper("-543.32");
		
		Double same = new Double(-543.32);
		Double small = new Double(-32543.32);
		Double large = new Double(19.21323432);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_StringInteger() {
		ValueWrapper num = new ValueWrapper("2");
		
		Integer same = new Integer(2);
		Integer small = new Integer(-43);
		Integer large = new Integer(192);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test
	public void testNumCompare_IntegerString() {
		ValueWrapper num = new ValueWrapper(new Integer(505));
		
		String same = "505";
		String small = "1";
		String large = "905";
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
/********************* numCompare(Object) fail tests **********************************/
	
	@Test(expected = RuntimeException.class)
	public void testNumCompareFail_IntegerString() {
		ValueWrapper num = new ValueWrapper(new Integer(505));
		
		String same = "505das";
		String small = "123";
		String large = "90512d";
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test(expected = RuntimeException.class)
	public void testNumCompareFail_StringDouble() {
		ValueWrapper num = new ValueWrapper("-321da");
		
		Double same = new Double(-543.32);
		Double small = new Double(-32543.32);
		Double large = new Double(19.21323432);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
	
	@Test(expected = RuntimeException.class)
	public void testNumCompareFail_StringByte() {
		ValueWrapper num = new ValueWrapper("-321");
		
		Byte same = new Byte((byte) -321);
		Byte small = new Byte((byte) -543.32);
		Byte large = new Byte((byte) 9553.32);
		
		assertEquals(0, num.numCompare(same));
		assertEquals(1, num.numCompare(small));
		assertEquals(-1, num.numCompare(large));
	}
}



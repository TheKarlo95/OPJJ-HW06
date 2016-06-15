package hr.fer.zemris.java.custom.scripting.exec;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for {@code ObjectMultistack} class.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see ObjectMultistack
 */
@SuppressWarnings("javadoc")
public class ObjectMultistackTest {

	// Constructor tests
	
	@Test
	public void testConstructor() {
		new ObjectMultistack();
		new ObjectMultistack(0);
		new ObjectMultistack(12);
		new ObjectMultistack(12, 0.6f);
	}
	
	// Constructor fail tests
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidSize() {
		new ObjectMultistack(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidLoadFactor() {
		new ObjectMultistack(32, 0);
	}
	
	// Methods tests
	
	@Test
	public void testPushPop() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.push("1", new ValueWrapper("prvi"));
		oms.push("1", new ValueWrapper("drugi"));
		oms.push("3", new ValueWrapper("treci"));
		oms.push("2", new ValueWrapper("cetvrti"));

		assertEquals(new ValueWrapper("drugi"), oms.pop("1"));
		assertEquals(new ValueWrapper("prvi"), oms.pop("1"));
		
		assertEquals(new ValueWrapper("cetvrti"), oms.pop("2"));

		assertEquals(new ValueWrapper("treci"), oms.pop("3"));
	}
	
	@Test
	public void testPushPeek() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.push("1", new ValueWrapper("prvi"));
		oms.push("1", new ValueWrapper("drugi"));
		oms.push("3", new ValueWrapper("treci"));
		oms.push("2", new ValueWrapper("cetvrti"));

		assertEquals(new ValueWrapper("drugi"), oms.peek("1"));
		assertEquals(new ValueWrapper("drugi"), oms.peek("1"));
		
		assertEquals(new ValueWrapper("cetvrti"), oms.peek("2"));

		assertEquals(new ValueWrapper("treci"), oms.peek("3"));
	}
	
	// Methods fail tests
	
	@Test(expected = IllegalArgumentException.class)
	public void testPushFailNullName() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.push(null, new ValueWrapper("blablabla"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPushFailNullValueWrapper() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.push("blabla", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPopFailNullName() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.pop(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPeekFailNullName() {
		ObjectMultistack oms = new ObjectMultistack();
		
		oms.peek(null);
	}
}
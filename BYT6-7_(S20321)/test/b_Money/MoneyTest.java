package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

//checking amount of money added correct
	@Test
	public void testGetAmount() {
		//fail("Write test case here");
		assertEquals("SEK100", Integer.valueOf(10000), SEK100.getAmount());
		assertEquals("EUR10", Integer.valueOf(1000), EUR10.getAmount());
		assertEquals("SEK200", Integer.valueOf(20000), SEK200.getAmount());
		assertEquals("EUR20", Integer.valueOf(2000), EUR20.getAmount());
		assertEquals("SEK0", Integer.valueOf(0), SEK0.getAmount());
		assertEquals("EUR0", Integer.valueOf(0), EUR0.getAmount());
		assertEquals("SEKn100", Integer.valueOf(-10000), SEKn100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		//fail("Write test case here");
		assertEquals("SEK100", SEK, SEK100.getCurrency());
		assertEquals("EUR0",EUR,EUR0.getCurrency());
	}

	@Test
	public void testToString() {
		//fail("Write test case here");
		assertEquals("100.0 SEK", SEK100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		
	}

	@Test
	public void testGlobalValue() {
		//fail("Write test case here");
		assertEquals(Integer.valueOf(0),SEK0.universalValue());
		
	}

	@Test
	public void testEqualsMoney() {
		//fail("Write test case here");
		assertTrue("SEK0 = EUR0 ", SEK0.equals(EUR0));
		assertTrue("SEK100 =  EUR10 ", SEK100.equals(EUR10));
		assertFalse("SEK100 != EUR20 ", SEK100.equals(EUR20));
		assertFalse("SEKn100 != EUR0", SEKn100.equals(EUR0));
	}

	@Test
	public void testAdd() {
		//fail("Write test case here");
		assertEquals("EUR20 + SEK100", Integer.valueOf(3000), EUR20.add(SEK100).getAmount());
		
	}

	@Test
	public void testSub() {
		//fail("Write test case here");
		assertEquals("SEK100 - EUR20", Integer.valueOf(-10000), SEK100.sub(EUR20).getAmount());
		assertEquals("EUR10 - SEK0", Integer.valueOf(1000), EUR10.sub(SEK0).getAmount());
		assertEquals("SEK200 - EUR10",Integer.valueOf(10000),SEK200.sub(EUR10).getAmount());

	}

	@Test
	public void testIsZero() {
		//fail("Write test case here");
		assertFalse("SEK100", SEK100.isZero());
		assertFalse("EUR20",EUR20.isZero());
		assertTrue("SEK0", SEK0.isZero());
		assertTrue("EUR0", EUR0.isZero());
	}

	@Test
	public void testNegate() {
		//fail("Write test case here");
		assertEquals("EUR0", Integer.valueOf(-0), EUR0.negate().getAmount());
		assertEquals("SEK0", Integer.valueOf(-0), SEK0.negate().getAmount());
		assertEquals("SEKn100", Integer.valueOf(10000), SEKn100.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		//fail("Write test case here");
		assertEquals("SEK100=EUR10", 0, SEK100.compareTo(EUR10));
		assertEquals("EUR10=SEK200", -1, EUR10.compareTo(SEK200));
	}
}

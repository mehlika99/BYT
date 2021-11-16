package b_Money;

import static org.junit.Assert.*;

import com.sun.jdi.IntegerValue;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	//COMPARE NAME WITH REAL NAME
	@Test
	public void testGetName() {
		//fail("Write test case here");
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}

	//COMPARE RATES AND RETURN ONE OF THEM
	@Test
	public void testGetRate() {
		//fail("Write test case here");
		assertEquals("SEK", 0.15, SEK.getRate(), 0.001);
		assertEquals("DKK", 0.20, DKK.getRate(), 0.001);
		assertEquals("EUR", 1.5, EUR.getRate(), 0.001);
	}

	//FIRST CHANGE YHE RATE AND CHECK IF IT IS CHANGED
	@Test
	public void testSetRate() {
		//fail("Write test case here");
		SEK.setRate(0.45);
		DKK.setRate(0.20);
		EUR.setRate(2.8);
		assertEquals("SEK", 0.45, SEK.getRate(), 0.001);
		assertEquals("DKK", 0.20, DKK.getRate(), 0.001);
		assertEquals("EUR", 2.8, EUR.getRate(), 0.001);
	}

	//CONVERT MONEY IN A GIVEN CURRENCY
	@Test
	public void testGlobalValue() {
		assertEquals("SEK", Integer.valueOf(15), SEK.universalValue(100));
		assertEquals("DKK", Integer.valueOf(20), DKK.universalValue(100));
		assertEquals("EUR", Integer.valueOf(150), EUR.universalValue(100));
	}

	
	@Test
	public void testValueInThisCurrency() {
		//fail("Write test case here");
		//assertEquals(Integer.valueOf(750),DKK.valueInThisCurrency(100,EUR));   
	}
	

}

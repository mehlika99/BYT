package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	//setUp method was throwing nullpointer exception
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

//failed because gives us account doesnt exist exception
		SweBank.deposit("Alice", new Money(1000000, SEK));
	}


	@Test
	public void testAddRemoveTimedPayment() {
		//fail("Write test case here");
		testAccount.addTimedPayment("firstTest",10,10,new Money(100,SEK),SweBank,"Alice");
		assertTrue("Test: timedPayment already exist",testAccount.timedPaymentExists("firstTest"));

		testAccount.removeTimedPayment("firstTest");
		assertFalse("Test: removed payment does not exist",testAccount.timedPaymentExists("firstTest"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());

		testAccount.addTimedPayment("test1", 2, 2, new Money(100, SEK), SweBank, "Alice");
		/*
		 * performing timed payment n times
		 * */
		for (int i = 0; i < 10; i++) {
			testAccount.tick();
		}
		assertEquals(Integer.valueOf(9999700), testAccount.getBalance().getAmount());

	}

	@Test
	public void testAddWithdraw() {

		//fail("Write test case here");
		testAccount.withdraw(new Money(100,SEK));
		assertEquals("Test: withdraw Hans",Integer.valueOf(9999900), testAccount.getBalance().getAmount());
		
	}

	@Test
	public void testGetBalance() {

		//fail("Write test case here");
		assertEquals("Test: Get account balance",Integer.valueOf(10000000), testAccount.getBalance().getAmount());
	}
}

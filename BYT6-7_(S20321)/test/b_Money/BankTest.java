package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {

		//fail("Write test case here");
		assertEquals(" Bank names as expected","Nordea",Nordea.getName());
		assertEquals(" Bank names as expected","DanskeBank",DanskeBank.getName());
		assertEquals(" Bank names as expected","SweBank",SweBank.getName());

	}

	@Test
	public void testGetCurrency() {

		//fail("Write test case here");
		assertEquals("Currency of bank as expected",SEK,SweBank.getCurrency());
		assertEquals("Currency of bank as expected",DKK,DanskeBank.getCurrency());
		assertEquals("Currency of bank as expected",SEK,Nordea.getCurrency());
	}

	//when we try to open acc with same id it wont  be thrown an exception
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		//fail("Write test case here");
			SweBank.openAccount("Grunewald");
	

	}

	//previously AccountDoesNotExistException was throwing even we have the acc
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		//fail("Write test case here");
		assertEquals("Ulrika prevoius", Integer.valueOf(0), SweBank.getBalance("Ulrika"));
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		assertEquals("Ulrika after", Integer.valueOf(10000), SweBank.getBalance("Ulrika"));
	}

	//error was in bank class in method withdraw
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		//fail("Write test case here");
		assertEquals("Ulrika prevoius", Integer.valueOf(0), SweBank.getBalance("Ulrika"));
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		assertEquals("Ulrika after deposit", Integer.valueOf(10000),  SweBank.getBalance("Ulrika"));
		SweBank.withdraw("Ulrika", new Money(5000, SEK));
		assertEquals("Ulrika after withdraw", Integer.valueOf(5000),  SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		//fail("Write test case here");
		SweBank.deposit("Ulrika",new Money(1000 , SEK));


		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(0),DanskeBank.getBalance("Gertrud"));
		assertEquals(Integer.valueOf(0),Nordea.getBalance("Bob"));
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		//fail("Write test case here");
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		SweBank.transfer("Ulrika", Nordea, "Bob", new Money(5000, SEK));
		assertEquals("Ulrika", Integer.valueOf(5000), SweBank.getBalance("Ulrika"));
		assertEquals("Bob", Integer.valueOf(5000), Nordea.getBalance("Bob"));


	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		//fail("Write test case here");
		SweBank.addTimedPayment("Bob", "test1", 5, 5, new Money(1000, SEK), DanskeBank, "Gertrud");
		for (int i = 0; i < 20; i++) {
			SweBank.tick();
		}
		assertEquals(Integer.valueOf(-3000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2250), DanskeBank.getBalance("Gertrud"));

		SweBank.removeTimedPayment("Bob","test1");
		SweBank.tick();
		assertEquals(Integer.valueOf(-3000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2250), DanskeBank.getBalance("Gertrud"));
	}
}

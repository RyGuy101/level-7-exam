import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.sun.javafx.css.CalculatedValue;

public class BankTest {

	public static final double MILLIS_PER_YEAR = 3.15569E10;
	public static final double MILLIS_BETWEEN_JAN_AND_JUNE = 1.296E10;
	Bank bank = new Bank();

	@Test
	public void testUpdateBalances() {
		BankAccount account = new BankAccount(new Date(0), 1000);
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(account);
		bank.updateBalances(accounts);
		assertEquals(2143, account.getBalance(), 0.01);
	}

	@Test
	public void testUpdateBalancesWhenCurrentMonthIsEarlierThanMonthOpened() {
		BankAccount account = new BankAccount(new Date(
				(long) (MILLIS_PER_YEAR - 1)), 1000);
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(account);
		bank.updateBalances(accounts);
		assertEquals(2117.6, account.getBalance(), 0.01);
	}

	@Test
	public void testUpdateBalancesWhenCurrentDateIsEarlierThanDateOpenedButInTheSameMonth() {
		BankAccount account = new BankAccount(new Date(
				(long) (MILLIS_BETWEEN_JAN_AND_JUNE - 1)), 1000);
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(account);
		bank.updateBalances(accounts);
		assertEquals(2117.6, account.getBalance(), 0.01);
	}
}

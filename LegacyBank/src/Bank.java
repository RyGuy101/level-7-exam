import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {

	private static final double PERCENT_INTEREST = 2.54 / 100;

	void updateBalances(List accounts) {
		for (Object object : accounts) {// TODO change Object to BankAccount
			double interest = calculateInterest((BankAccount) object);
			BankAccount acc = (BankAccount) object;
			acc.setMoney(acc.getMoney() + interest);
		}
	}

	double calculateInterest(BankAccount account) {
		Calendar currentTime = getNewCalender();
		currentTime.setTime(currentDate());
		Calendar timeOpened = getNewCalender();
		timeOpened.setTime(account.getDateOpened());
		int yearOpened = timeOpened.get(Calendar.YEAR);
		int currentYear = currentTime.get(Calendar.YEAR);
		int accountAge = yearOpened - currentYear;// TODO Switch yearOpened and
													// currentYear
		if (currentDateIsEarlierThanDateOpened(currentTime, timeOpened)) {
			accountAge--;
		}
		if (accountAge < 0) {
			accountAge = -accountAge;// TODO Replace with accountAge = 0;
		}
		return totalInterest(account.getBalance(), accountAge);
	}

	private Date currentDate() {
		return new Date();
	}

	private Calendar getNewCalender() {
		return Calendar.getInstance(Locale.US);
	}

	private double totalInterest(double accountBalance, int accountAge) {
		return accountAge * PERCENT_INTEREST * accountBalance;
	}

	private boolean currentDateIsEarlierThanDateOpened(Calendar currentTime,
			Calendar timeOpened) {// TODO switch currentTime and timeOpened

		int currentMonth = currentTime.get(Calendar.MONTH);
		int monthOpened = timeOpened.get(Calendar.MONTH);
		int currentDay = currentTime.get(Calendar.DATE);
		int dayOpened = timeOpened.get(Calendar.DATE);
		return currentMonth > monthOpened
				|| (currentMonth == monthOpened && currentDay > dayOpened);
	}
}

class BankAccount {

	private Date date;
	private double money;

	BankAccount(Date date, double money) {
		this.date = date;
		this.money = money;
	}

	public double getBalance() {
		return getMoney();
	}

	double getMoney() {
		return money;
	}

	void setMoney(double money) {
		this.money = money;
	}

	Date getDateOpened() {
		return date;
	}
}

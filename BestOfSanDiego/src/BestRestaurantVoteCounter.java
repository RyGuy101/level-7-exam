import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BestRestaurantVoteCounter {

	int votesForSangDeuan = 0, votesForOceanaCoastalKitchen = 0,
			votesForWerewolf = 0, votesForHomeAndAway = 0, votesForCLevel = 0;

	public int getVotesForSangDeuan() {
		return votesForSangDeuan;
	}

	public int getVotesForOceanaCoastalKitchen() {
		return votesForOceanaCoastalKitchen;
	}

	public int getVotesForWerewolf() {
		return votesForWerewolf;
	}

	public int getVotesForHomeAndAway() {
		return votesForHomeAndAway;
	}

	public int getVotesForCLevel() {
		return votesForCLevel;
	}

	ArrayList<String> votes = new ArrayList<String>();

	public ArrayList<String> getVotes() {
		return votes;
	}

	public static void main(String[] args) throws IOException {
		new BestRestaurantVoteCounter().getGoing();
	}

	void getGoing() throws IOException {
		URL fileWithVotes = getClass().getResource("sample-votes.txt");

		Scanner scanner = new Scanner(fileWithVotes.openStream());

		while (scanner.hasNextLine()) {
			votes.add(scanner.nextLine());
		}
		scanner.close();

		for (String vote : votes) {
			if (matchesSangDeuan(vote))
				votesForSangDeuan++;
			if (matchesOceanaCoastalKitchen(vote))
				votesForOceanaCoastalKitchen++;
			if (matchesWerewolf(vote))
				votesForWerewolf++;
			if (matchesHomeAndAway(vote))
				votesForHomeAndAway++;
			if (matchesCLevel(vote))
				votesForCLevel++;
		}

		String winningRestaurant = calculateWinner(votesForSangDeuan,
				votesForOceanaCoastalKitchen, votesForWerewolf,
				votesForHomeAndAway, votesForCLevel);
		System.out.println("Reader's favorite restaurant is: "
				+ winningRestaurant);
		// TODO: Tweet the result.
	}

	String calculateWinner(int votesForSangDeuan,
			int votesForOceanaCoastalKitchen, int votesForWerewolf,
			int votesForHomeAndAway, int votesForCLevel) {
		int mostVotes = 0;
		String winningRestaurant = null;
		if (votesForSangDeuan > mostVotes) {
			mostVotes = votesForSangDeuan;
			winningRestaurant = "Sang Deuan";
		}
		if (votesForOceanaCoastalKitchen > mostVotes) {
			mostVotes = votesForOceanaCoastalKitchen;
			winningRestaurant = "Oceana Coastal Kitchen";
		}
		if (votesForWerewolf > mostVotes) {
			mostVotes = votesForWerewolf;
			winningRestaurant = "Werewolf";
		}
		if (votesForHomeAndAway > mostVotes) {
			mostVotes = votesForHomeAndAway;
			winningRestaurant = "Home & Away";
		}
		if (votesForCLevel > mostVotes) {
			mostVotes = votesForCLevel;
			winningRestaurant = "C Level";
		}
		return winningRestaurant;
	}

	boolean matchesSangDeuan(String possibleMatch) {
		if (possibleMatch.toLowerCase().contains("sang deuan")
				|| possibleMatch.toLowerCase().contains("sang duan"))
			return true;
		else
			return false;
	}

	boolean matchesOceanaCoastalKitchen(String possibleMatch) {
		if (possibleMatch.toLowerCase().contains("oceana coastal kitchen")
				|| possibleMatch.toLowerCase().contains("ocean coastal"))
			return true;
		else
			return false;
	}

	boolean matchesWerewolf(String possibleMatch) {
		if (possibleMatch.toLowerCase().contains("wherewolf")
				|| possibleMatch.toLowerCase().contains("werewolf"))
			return true;
		else
			return false;
	}

	boolean matchesHomeAndAway(String possibleMatch) {
		if (possibleMatch.toLowerCase().contains("homeandaway")
				|| possibleMatch.toLowerCase().contains("home and away")
				|| possibleMatch.toLowerCase().contains("home & away"))
			return true;
		else
			return false;
	}

	boolean matchesCLevel(String possibleMatch) {
		if (possibleMatch.toLowerCase().contains("c level")
				|| possibleMatch.toLowerCase().contains("c-level")
				|| possibleMatch.toLowerCase().contains("c level lounge"))
			return true;
		else
			return false;
	}

}

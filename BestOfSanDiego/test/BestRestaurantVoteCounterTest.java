import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BestRestaurantVoteCounterTest {

	@Test
	public void testVotes() throws IOException {
		BestRestaurantVoteCounter bestRestaurantVoteCounter = new BestRestaurantVoteCounter();
		bestRestaurantVoteCounter.getGoing();
		assertEquals(6, bestRestaurantVoteCounter.getVotesForCLevel());
		assertEquals(2, bestRestaurantVoteCounter.getVotesForHomeAndAway());
		assertEquals(3,
				bestRestaurantVoteCounter.getVotesForOceanaCoastalKitchen());
		assertEquals(3, bestRestaurantVoteCounter.getVotesForSangDeuan());
		assertEquals(4, bestRestaurantVoteCounter.getVotesForWerewolf());
	}
}

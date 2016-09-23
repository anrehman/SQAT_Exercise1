import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowling {

	BowlingGame oneGame = new BowlingGame();

	@Before
	public void initializeGame() throws BowlingException {
		Frame oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
	}

	@Test(expected = BowlingException.class)
	public void testBowling_testFrameSize() throws BowlingException {
		Frame oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
	}

	@Test
	public void testBowling_singleFrameSum() {
		Frame oneFrame = new Frame(2, 3);
		assertEquals("Single Frame Score Test: ", oneFrame.score(), 5);
	}

	@Test
	public void testBowling_gameScoreCheck() {

	}

}

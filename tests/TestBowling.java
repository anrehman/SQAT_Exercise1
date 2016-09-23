import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowling {

	BowlingGame oneGame = new BowlingGame();
	BowlingGame secondGame = new BowlingGame();

	@Before
	public void initializeGame() throws BowlingException {
		Frame oneFrame = new Frame(1, 5);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		oneGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
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
		assertEquals("Single Frame Score Test: ", 5, oneFrame.score());
	}

	@Test
	public void testBowling_gameScoreCheck() throws BowlingException {
		assertEquals("Game Score Test: ", 81, oneGame.score());
	}

	@Test
	public void testBowling_isStrike() {
		Frame oneFrame = new Frame(10, 0);
		assertTrue(oneFrame.isStrike());
	}

	@Test
	public void testBowling_strikeScoreGame() throws BowlingException {
		Frame oneFrame = new Frame(10, 0);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
		secondGame.addFrame(oneFrame);
		assertEquals("One Strike Game Score Test: ", 94, secondGame.score());
	}

	@Test
	public void testBowling_isSpareCheck() {
		Frame oneFrame = new Frame(4, 6);
		assertTrue(oneFrame.isSpare());
	}

	@Test
	public void testBowling_spareGameScore() throws BowlingException {
		Frame oneFrame = new Frame(1, 9);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
		secondGame.addFrame(oneFrame);
		assertEquals("One Spare Game Score Test: ", secondGame.score(), 88);
	}

	@Test(expected = BowlingException.class)
	public void testBowling_gameWithLessFrames() throws BowlingException {
		Frame oneFrame = new Frame(10, 0);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		secondGame.score();
	}

	@Test
	public void testBowling_strikeSpareGameScoreCheck() throws BowlingException {
		Frame oneFrame = new Frame(10, 0);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
		secondGame.addFrame(oneFrame);
		assertEquals("Strike Spare Game Score Test: ", secondGame.score(), 103);
	}

	@Test
	public void testBowling_twoStrikeGameScore() throws BowlingException {
		Frame oneFrame = new Frame(10, 0);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(10, 0);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
		secondGame.addFrame(oneFrame);
		assertEquals("Two Strike Game Score Test: ", 112, secondGame.score());
	}

	@Test
	public void testBowling_twoSpareGameScore() throws BowlingException {
		Frame oneFrame = new Frame(8, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(7, 2);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 6);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 4);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(5, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(3, 3);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(4, 5);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(8, 1);
		secondGame.addFrame(oneFrame);
		oneFrame = new Frame(2, 6);
		secondGame.addFrame(oneFrame);
		assertEquals("Two Spare Game Score Test: ", 98, secondGame.score());
	}
}

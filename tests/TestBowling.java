import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	BowlingGame oneGame = new BowlingGame();
	
	@Test  (expected = BowlingException.class)
	public void testBowling_testFrameSize() throws BowlingException{
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
		oneFrame = new Frame(1, 2);
		oneGame.addFrame(oneFrame);
	}
	
}

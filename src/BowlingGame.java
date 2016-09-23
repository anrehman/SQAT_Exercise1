import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	// a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private static final int STRIKE_SCORE = 10;

	public BowlingGame() {
	}

	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException {
		if (frames.size() < 10 && frame.getFirstThrow() >= 0 && frame.getSecondThrow() >= 0)
			frames.add(frame);
		else
			throw new BowlingException();
	}

	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		bonus = new Frame(firstThrow, secondThrow);
	}

	// Returns the game score
	public int score() throws BowlingException {
		int sum = 0;
		if (frames.size() == 10) {
			for (int loop = 0; loop < frames.size(); loop++) {
				if (frames.get(loop).isStrike()) {
					sum = strikeScore(loop, sum);
				} else if (frames.get(loop).isSpare()) {
					sum = spareScore(loop, sum);
				} else {
					sum = sum + frames.get(loop).score();
				}
			}
		} else
			throw new BowlingException();

		return sum;
	}

	public int strikeScore(int loop, int sum) throws BowlingException {
		if (loop == (frames.size() - 1)) {
			if (bonus != null)
				sum = sum + STRIKE_SCORE + bonus.score();
			else
				throw new BowlingException();
		} else {
			if (frames.get(loop + 1).isStrike()) {
				if (loop + 2 < frames.size())
					sum = sum + STRIKE_SCORE + STRIKE_SCORE + frames.get(loop + 2).getFirstThrow();
				else {
					if (bonus != null)
						sum = sum + STRIKE_SCORE + STRIKE_SCORE + bonus.getFirstThrow();
					else
						throw new BowlingException();
				}
			} else {
				sum = sum + STRIKE_SCORE + frames.get(loop + 1).score();
			}
		}
		return sum;
	}

	public int spareScore(int loop, int sum) throws BowlingException {
		if (loop == (frames.size() - 1)) {
			if (bonus != null)
				sum = sum + STRIKE_SCORE + bonus.getFirstThrow();
			else
				throw new BowlingException();
		} else
			sum = sum + STRIKE_SCORE + frames.get(loop + 1).getFirstThrow();

		return sum;
	}
}

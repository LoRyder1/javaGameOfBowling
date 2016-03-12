
public class BowlingGame {

    private int total;
    private int rolls[] = new int[21];
    private int currentRoll = 0;
    private int frameIndex = 0;
    private InterpretFrame frame;

    public void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    public int score() {
        for(int frame = 0; frame < 10; frame++) {
            scoreFrame();
        }
        return total;
    }

    private void scoreFrame() {
        frame = new InterpretFrame(rolls, frameIndex);
        if (frame.isStrike()) {
            addStrikeToTotal();
        }
        else if (frame.isSpare()) {
            addSpareToTotal();
        } else {
            addFrameToTotal();
        }
    }

    private void addFrameToTotal() {
        total += frame.sumAllPinsInFrame();
        frameIndex += 2;
    }

    private void addSpareToTotal() {
        total += 10 + frame.spareBonus();
        frameIndex += 2;
    }

    private void addStrikeToTotal() {
        total += 10 + frame.strikeBonus();
        frameIndex++;
    }
}

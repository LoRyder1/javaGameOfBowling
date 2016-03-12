
public class BowlingGame {

    private int total;
    private int rolls[] = new int[21];
    private int currentRoll = 0;
    private int frameIndex = 0;

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
        InterpretFrame frame = new InterpretFrame(rolls, frameIndex);
        if (frame.isStrike()) {
            total += 10 + strikeBonus();
            frameIndex++;
        }
        else if (frame.isSpare()) {
            total += 10 + spareBonus();
            frameIndex += 2;
        } else {
            total += sumAllPinsInFrame();
            frameIndex += 2;
        }
    }

    private int sumAllPinsInFrame() {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus() {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus() {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }



}

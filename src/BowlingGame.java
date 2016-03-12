
public class BowlingGame {

    private int total;
    private int rolls[] = new int[21];
    private int currentRoll = 0;
    private int frameIndex = 0;

    public void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    public int score() {
//        InterpretFrame frame = new InterpretFrame();
        for(int frame = 0; frame < 10; frame++) {
            scoreFrame();
        }
        return total;
    }

    private void scoreFrame() {
        if (isStrike()) {
            total += 10 + strikeBonus();
            frameIndex++;
        }
        else if (isSpare()) {
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

    private boolean isSpare() {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike() {
        return rolls[frameIndex] == 10;
    }

}

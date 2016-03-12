
public class BowlingGame {

    private int total;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    public int score() {
        currentRoll = 0;
        for(int frame = 0; frame < 10; frame++) {
            if (isStrike()) {
                total += 10 + strikeBonus();
                currentRoll++;
            }
            else if (isSpare()) {
                total += 10 + spareBonus();
                currentRoll += 2;
            } else {
                total += sumAllPinsInFrame();
                currentRoll += 2;
            }
        }
        return total;
    }

    private int sumAllPinsInFrame() {
        return rolls[currentRoll] + rolls[currentRoll + 1];
    }

    private int spareBonus() {
        return rolls[currentRoll + 2];
    }

    private int strikeBonus() {
        return rolls[currentRoll + 1] + rolls[currentRoll + 2];
    }

    private boolean isSpare() {
        return rolls[currentRoll] + rolls[currentRoll + 1] == 10;
    }

    private boolean isStrike() {
        return rolls[currentRoll] == 10;
    }

}

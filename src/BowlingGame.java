
public class BowlingGame {

    private int total;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    public int score() {
        for(int frame = 0; frame < 10; frame++) {
            if (rolls[currentRoll] + rolls[currentRoll + 1] == 10) {
                total += 10 + rolls[currentRoll + 2];
                currentRoll += 2;
            } else {
                total += rolls[currentRoll] + rolls[currentRoll + 1];
                currentRoll += 2;
            }
        }
        return total;
    }

}

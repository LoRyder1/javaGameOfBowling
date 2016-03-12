public class InterpretFrame {

    private final int[] rolls;
    private final int frameIndex;

    public InterpretFrame(int[] rolls, int frameIndex) {
        this.rolls = rolls;
        this.frameIndex = frameIndex;
    }

    public boolean isSpare() {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    public boolean isStrike() {
        return rolls[frameIndex] == 10;
    }

    public int sumAllPinsInFrame() {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    public int spareBonus() {
        return rolls[frameIndex + 2];
    }

    public int strikeBonus() {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

}

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;

    private void rollMany(int pins, int num) {
        for(int i = 0; i < num; i++) {
            game.roll(pins);
        }
    }

    @Before
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void testGutterGame() {
        rollMany(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnesGame() {
        rollMany(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);
        assertEquals(16, game.score());
    }
}

package groupprojectdominate;

import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * This is a test case for the ColorConquerer class, which models the
 * ColorConquerer game.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */

public class ColorConquererTest
    extends student.TestCase
{
    private ColorConquerer       game;
    private static final Color[] COLORS = { Color.yellow, Color.blue,
        Color.pink, Color.green, Color.red }; ;


    /**
     * Called before each test case to prepare each test case.
     */
    public void setUp()
    {
        game = new ColorConquerer(COLORS, 5, 5);

        game.setColorAt(new Location(0, 0), Color.red);
        game.setColorAt(new Location(0, 1), Color.blue);
        game.setColorAt(new Location(0, 2), Color.blue);
        game.setColorAt(new Location(0, 3), Color.green);
        game.setColorAt(new Location(0, 4), Color.yellow);

        game.setColorAt(new Location(1, 0), Color.green);
        game.setColorAt(new Location(1, 1), Color.pink);
        game.setColorAt(new Location(1, 2), Color.blue);
        game.setColorAt(new Location(1, 3), Color.blue);
        game.setColorAt(new Location(1, 4), Color.green);

        game.setColorAt(new Location(2, 0), Color.red);
        game.setColorAt(new Location(2, 1), Color.green);
        game.setColorAt(new Location(2, 2), Color.blue);
        game.setColorAt(new Location(2, 3), Color.green);
        game.setColorAt(new Location(2, 4), Color.red);

        game.setColorAt(new Location(3, 0), Color.red);
        game.setColorAt(new Location(3, 1), Color.green);
        game.setColorAt(new Location(3, 2), Color.red);
        game.setColorAt(new Location(3, 3), Color.green);
        game.setColorAt(new Location(3, 4), Color.red);

        game.setColorAt(new Location(4, 0), Color.blue);
        game.setColorAt(new Location(4, 1), Color.blue);
        game.setColorAt(new Location(4, 2), Color.blue);
        game.setColorAt(new Location(4, 3), Color.red);
        game.setColorAt(new Location(4, 4), Color.red);
    }


    /**
     * This method tests the constructor for ColorConquerer.
     */
    public void testConstructor()
    {
        assertEquals(5, game.getSize());
        assertEquals(5, game.getTurns());
        assertEquals(Color.red, game.getColorAt(new Location(0, 0)));
        assertEquals(Color.red, game.getCurrentColor());
    }


    /**
     * This method tests the isInbounds method for boundary checking.
     */
    public void testIsInbounds()
    {
        assertFalse(game.isInbounds(new Location(-1, -1)));
        assertFalse(game.isInbounds(new Location(-1, 0)));
        assertFalse(game.isInbounds(new Location(0, -1)));
        assertFalse(game.isInbounds(new Location(5, 5)));
        assertFalse(game.isInbounds(new Location(5, 4)));
        assertFalse(game.isInbounds(new Location(4, 5)));

        assertTrue(game.isInbounds(new Location(0, 0)));
        assertTrue(game.isInbounds(new Location(4, 4)));
    }


    /**
     * This method tests the updateColors() method which expands the currently
     * conquered tiles to include the new color passed to the method.
     */
    public void testUpdateColors()
    {
        // Test that update colors does nothing if the newColor is the same as
        // the currentColor.
        game.updateColors(Color.red);
        assertEquals(5, game.getTurns());
        assertEquals(Color.red, game.getCurrentColor());
        assertEquals(Color.red, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.blue);
        assertEquals(4, game.getTurns());
        assertEquals(Color.blue, game.getCurrentColor());
        assertEquals(Color.blue, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.green);
        assertEquals(3, game.getTurns());
        assertEquals(Color.green, game.getCurrentColor());
        assertEquals(Color.green, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.red);
        assertEquals(2, game.getTurns());
        assertEquals(Color.red, game.getCurrentColor());
        assertEquals(Color.red, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.blue);
        assertEquals(1, game.getTurns());
        assertEquals(Color.blue, game.getCurrentColor());
        assertEquals(Color.blue, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.yellow);
        assertEquals(0, game.getTurns());
        assertEquals(Color.yellow, game.getCurrentColor());
        assertEquals(Color.yellow, game.getColorAt(new Location(0, 0)));

        game.updateColors(Color.pink);
        assertEquals(0, game.getTurns());
        assertEquals(Color.pink, game.getCurrentColor());
        assertEquals(Color.pink, game.getColorAt(new Location(0, 0)));

        assertTrue(game.outOfTurns());

        assertTrue(game.isVictory());
    }

    // TODO test every method in ColorConquerer
}

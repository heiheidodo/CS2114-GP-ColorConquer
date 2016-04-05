package groupprojectdominate;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Yong Kim (yak22)
 * @author Alex Gomes (afgomes6)
 * @version 2013. 3. 7.
 */
public class Tiles
    extends RectangleShape
{

    // ----------------------------------------------------------
    /**
     * Create a new CoverTile object.
     *
     * @param l float left
     * @param t float top
     * @param r float right
     * @param b float bottom
     */
    public Tiles(float l, float t, float r, float b)
    {
        super(l, t, r, b);
        setFilled(true);
    }
}

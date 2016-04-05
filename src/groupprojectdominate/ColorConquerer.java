package groupprojectdominate;

import sofia.graphics.Color;

// TODO List:
// 1) Write tests for the game.

// -------------------------------------------------------------------------
/**
 * The ColorConquerer class is the model for the Color Conquerer game. The
 * objective of the Color Conquerer class is to 'conquer' the game grid by
 * changing all tiles to the same color. Frequently in the Javadoc references to
 * the 'blob', 'flooded tiles', 'conquered tiles', all refer to tiles that have
 * been successfully conquered.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */
public class ColorConquerer
{
    // A list of available colors in the game.
    private static Color[] colors;

    // tiles represents the actual game grid.
    private Color[][]      colorGrid;

    // Width/length of the game grid. No setter for this field.
    private int            size;

    // The current color of the blob of conquered tiles.
    private Color          currentColor;

    // The turns left. decrements each time a new color is chosen.
    private int            turnsRemaining;

    // Used for efficiency in the switchColors method. See Javadoc for
    // switchColors for more info.
    private boolean[][]    wasChecked;


    // ----------------------------------------------------------
    /**
     * Create a new ColorConquerer object with a given size and turn limit.
     *
     * @param gameColors
     *            - an array of possible colors for the game.
     * @param gridSize
     *            - the width/height of the game grid.
     * @param maxTurns
     *            - the maximum amount of turns.
     */
    public ColorConquerer(Color[] gameColors, int gridSize, int maxTurns)
    {
        colors = gameColors;

        size = gridSize;

        turnsRemaining = maxTurns;

        createColorGrid();

        currentColor = colorGrid[0][0];

        resetCheckedTiles();
    }


    /**
     * Create a grid of Colors. The color at each coordinate in the game grid
     * are randomly selected from values in the colors[].
     */
    private void createColorGrid()
    {
        colorGrid = new Color[size][size];

        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                colorGrid[x][y] = getRandomColor();
            }
        }
    }


    /**
     * Returns a random color from colors[].
     *
     * @return a random Color from the array of Colors
     */
    private Color getRandomColor()
    {
        int randomIdx = (int)Math.floor(Math.random() * colors.length);

        return colors[randomIdx];
    }


    /**
     * Sets all the values in wasChecked to false, meaning no tiles have been
     * checked yet.
     */
    private void resetCheckedTiles()
    {
        wasChecked = new boolean[size][size];

        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                wasChecked[x][y] = false;
            }
        }
    }


    /**
     * This method calls the private method switchColors(Location, Color) which
     * recursively checks all tiles in the current 'blob'. When all tiles have
     * been changed, boolean values in wasChecked are reset to false, turns
     * remaining is decremented by one, and the current color of the blob is set
     * to the new color. This method does nothing if the newColor is the same as
     * the currentColor. (0, 0) is always the first location to call
     * switchColors().
     *
     * @preconditions newColor is a Color from colors[].
     * @param newColor
     *            - The new color of the blob.
     */
    public void updateColors(Color newColor)
    {
        if (newColor != currentColor)
        {
            switchColors(new Location(0, 0), newColor);

            resetCheckedTiles();

            currentColor = newColor;

            if (turnsRemaining > 0)
            {
                turnsRemaining--;
            }
        }
    }


    /**
     * A recursive algorithm to fill all flooded tiles to the chosen new color.
     * Takes an initial location to change, and the new color to change to.
     * Changes the color of all tiles in the current blob. This method keeps
     * track of previously checked tiles by updating a 2D array of boolean
     * values corresponding to the location in the game grid. If a location has
     * been checked already then it will be skipped for efficiency.
     *
     * @param loc
     *            - the location of the tile being changed
     * @param newColor
     *            - the new color selected to change.
     */
    private void switchColors(Location loc, Color newColor)
    {
        int x = loc.x();
        int y = loc.y();

        // If the tile is not inbounds, the tile was already checked, or it is
        // not the currentColor then we have reached a base case, and can exit
        // by returning nothing.
        if (!isInbounds(loc) || wasChecked[x][y]
            || colorGrid[x][y] != currentColor)
        {
            return;
        }

        // Change current tile to the new color
        colorGrid[x][y] = newColor;

        // This tile has been checked and changed, so set its location to
        // true in wasChecked[][]
        wasChecked[x][y] = true;

        // Now check the surrounding tiles in the following order: east,
        // south, west, north.
        switchColors(new Location(x + 1, y), newColor);

        switchColors(new Location(x, y + 1), newColor);

        switchColors(new Location(x - 1, y), newColor);

        switchColors(new Location(x, y - 1), newColor);
    }


    /**
     * Checks for bounds. If the given location is out of bounds, then false is
     * returned.
     *
     * @param loc
     *            - the Location to check
     * @return True if the given Location is within the bounds of the game
     *         tiles, false otherwise.
     */
    public boolean isInbounds(Location loc)
    {
        int x = loc.x();
        int y = loc.y();

        if (x < 0 || y < 0 || x >= size || y >= size)
        {
            return false;
        }

        return true;
    }


    /**
     * Sets the color value at a location in the tiles. The new color MUST be a
     * a valid Color from colors[]. The location must be within the bounds of
     * the tiles or the change will be ignored.
     *
     * @param loc
     *            - the location of the value to change
     * @param newColor
     *            - the new color value.
     */
    public void setColorAt(Location loc, Color newColor)
    {
        // Do nothing if newColor is not within the bounds of the game grid.
        if (isInbounds(loc))
        {
            colorGrid[loc.x()][loc.y()] = newColor;
            currentColor = colorGrid[0][0];
        }
    }


    /**
     * Get the color at the location in the tiles. Assumes the location given is
     * within the bounds of the tiles.
     *
     * @param loc
     *            - the location of the value to get
     * @return The color at the given location
     */
    public Color getColorAt(Location loc)
    {
        if (isInbounds(loc))
        {
            return colorGrid[loc.x()][loc.y()];
        }

        return null;
    }


    /**
     * Return the current game grid.
     *
     * @return The current state of the game grid.
     */
    public Color[][] getGameGrid()
    {
        return colorGrid;
    }


    /**
     * Returns the number of turns remaining for this ColorConquerer game.
     *
     * @return The remaining turns for this game.
     */
    public int getTurns()
    {
        return turnsRemaining;
    }

    public void setTurns(int turn)
    {
        turnsRemaining = turn;
    }


    /**
     * Checks for victory conditions (i.e. all tiles are the same color). This
     * method does not care about turn limit. Losing conditions are checked in
     * outOfTurns().
     *
     * @return True if is a victory, false if not.
     */
    public boolean isVictory()
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                if (colorGrid[x][y] != currentColor)
                {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * Checks if the player is out of turns (turns remaining has reached 0).
     * Used to determine defeat conditions (if you're out of turns and the grid
     * isn't completely changed, you lose). Note that this method ONLY checks if
     * out of turns. isVictory() should be called to check for winning
     * conditions.
     *
     * @return True if the turn limit has been reached. False if more turns
     *         remaining.
     */
    public boolean outOfTurns()
    {
        return turnsRemaining <= 0;
    }


    /**
     * This method returns the array of Colors used in the game.
     *
     * @return The Colors that are used in the game.
     */
    public Color[] getColors()
    {
        return colors;
    }


    /**
     * Returns the width/height of the game grid.
     *
     * @return The size of the game.
     */
    public int getSize()
    {
        return size;
    }


    /**
     * Returns the current Color of the blob in the game.
     *
     * @return The current color of all flooded tiles in the game.
     */
    public Color getCurrentColor()
    {
        return currentColor;
    }
}

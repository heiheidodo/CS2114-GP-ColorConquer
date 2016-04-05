package groupprojectdominate;



// -------------------------------------------------------------------------
/**
 *  Manipulate the location of the Maze.
 *
 *  @author Yong Kim (yak22)
 *  @version 2013. 2. 21.
 */
public class Location
{

    private int x;
    private int y;

    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     * @param theX x
     * @param theY y
     */
    public Location(int theX, int theY)
    {
        x = theX;
        y = theY;
    }

    /**
     * Returns a position of location on the east.
     * @return newLoc new location.
     */
    public Location east()
    {
        Location newLoc = new Location(x + 1, y);
        return newLoc;
    }

    /**
     * Returns a position of location on the north.
     * @return newLoc new location.
     */
    public Location north()
    {
        Location newLoc = new Location(x, y - 1);
        return newLoc;
    }

    /**
     * Returns a position of location on the south.
     * @return newLoc new location.
     */
    public Location south()
    {
        Location newLoc = new Location(x, y + 1);
        return newLoc;
    }

    /**
     * Returns a position of location on the west.
     * @return newLoc new location.
     */
    public Location west()
    {
        Location newLoc = new Location(x - 1, y);
        return newLoc;
    }

    /**
     * Returns position of x.
     * @return x value.
     */
    public int x()
    {
        return x;
    }

    /**
     * Returns position of y.
     * @return y value.
     */
    public int y()
    {
        return y;
    }

    /**
     * Returns true if two locations are same
     * otherwise false.
     * @return true of false depending on the condition.
     * @param loc comparing location
     */
    public boolean equals(Object loc)
    {
        if (loc != null && loc instanceof Location)
        {
            Location newLoc = (Location) loc;
            return (newLoc.x() == x() && newLoc.y() == y());
        }
        else
        {
            return false;
        }
//        if (!(loc instanceof Location))
//        {
//            return false;
//        }

//        Location newLoc = (Location) loc;
//        return (newLoc.x() == x() && newLoc.y() == y());
    }

    /**
     * Overrides toString to have (x, y) format.
     * @return formated coordinates.
     */
    public String toString()
    {
        return "(" + x() + ", " + y() + ")";
    }
}

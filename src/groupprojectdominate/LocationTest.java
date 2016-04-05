package groupprojectdominate;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for Location class.
 *
 *  @author Yong
 *  @version 2013. 2. 22.
 */
public class LocationTest extends TestCase
{
    Location loc = new Location(5, 5);
    Location east = new Location(6, 5);
    Location west = new Location(4, 5);
    Location south = new Location(5, 6);
    Location north = new Location(5, 4);

    /**
     * Supposedly sets up for testing.
     */
    public void setUp()
    {
        //
    }

    // ----------------------------------------------------------
    /**
     * Tests east method.
     */
    public void testEast()
    {
        assertEquals(6, loc.east().x());
        assertEquals(5, loc.east().y());
        assertTrue(loc.east().equals(east));
    }

    // ----------------------------------------------------------
    /**
     * Tests north method.
     */
    public void testNorth()
    {
        assertEquals(5, loc.north().x());
        assertEquals(4, loc.north().y());
        assertTrue(loc.north().equals(north));
    }

    // ----------------------------------------------------------
    /**
     * Tests south method.
     */
    public void testSouth()
    {
        assertEquals(5, loc.south().x());
        assertEquals(6, loc.south().y());
        assertTrue(loc.south().equals(south));
    }

    // ----------------------------------------------------------
    /**
     * Tests west method.
     */
    public void testWest()
    {
        assertEquals(4, loc.west().x());
        assertEquals(5, loc.west().y());
        assertTrue(loc.west().equals(west));
    }


    // ----------------------------------------------------------
    /**
     * Tests x method.
     */
    public void testX()
    {
        assertEquals(5, loc.x());
    }

    // ----------------------------------------------------------
    /**
     * Tests y method.
     */
    public void testY()
    {
        assertEquals(5, loc.y());
    }

    // ----------------------------------------------------------
    /**
     * Tests equals method.
     */
    public void testEquals()
    {
        Location empty = new Location(0, 0);
        Location hmm = new Location(1, 1);
        empty = null;
        boolean temp = false;
        boolean temp1 = true;
        Object obj = new Object();
        Location loc1 = new Location(5, 5);
        temp1 = loc.equals(empty);
        assertFalse(temp1);
        assertFalse(loc.equals(obj));
        temp = loc.equals(loc1);
        assertTrue(temp);
        assertEquals(false, hmm == null);
    }

    // ----------------------------------------------------------
    /**
     * Tests toString method.
     */
    public void testToString()
    {
        assertEquals("(5, 5)", loc.toString());
    }
}

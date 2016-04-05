package groupprojectdominate;

import android.content.Intent;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  This is the testCase for DiffScreen class.
 *
 *  @author Sheng Zhou
 *  @version May 5, 2013
 */
public class DiffScreenTest extends student.AndroidTestCase<DiffScreen>
{
    private Button easy;
    private Button medium;
    private Button hard;
    private Button back;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */

    public DiffScreenTest()
    {
        super(DiffScreen.class);
    }

    /**
     * Initialize the test.
     */
    public void setUp()
    {
        // Set up the test.
    }

    // ----------------------------------------------------------
    /**
     * Test easyClicked().
     */
    public void easyClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(easy);
    }

    // ----------------------------------------------------------
    /**
     * Test mediumClicked().
     */
    public void mediumClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(medium);
    }

    // ----------------------------------------------------------
    /**
     * Test hardClicked().
     */
    public void hardClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(hard);
    }

    // ----------------------------------------------------------
    /**
     * Test backClicked().
     */
    public void backClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(back);
    }
}

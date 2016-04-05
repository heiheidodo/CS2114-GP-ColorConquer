package groupprojectdominate;

import android.content.Intent;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 * This is the test Case for MainScreen class.
 *
 * @author Sheng Zhou
 * @version May 5, 2013
 */
public class MainScreenTest
    extends student.AndroidTestCase<MainScreen>
{
    private Button help;
    private Button credit;
    private Button start;
    private Button difficulty;


    // ----------------------------------------------------------
    /**
     * Create a new MainScreenTest object.
     */
    public MainScreenTest()
    {
        super(MainScreen.class);
    }


    /**
     * Initialize the test.
     */
    public void setUp()
    {
        // set up test
    }


    // ----------------------------------------------------------
    /**
     * The method is to test helpClicked().
     */
    public void helpClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(help);
    }


    // ----------------------------------------------------------
    /**
     * The method is to test creditClicked().
     */
    public void creditClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(credit);
    }


    // ----------------------------------------------------------
    /**
     * The method is to test startClicked().
     */
    public void startClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(start);
    }


    // ----------------------------------------------------------
    /**
     * The method is to test difficultyClicked().
     */
    public void difficultyClickedTest()
    {
        prepareForUpcomingActivity(Intent.ACTION_VIEW);
        click(difficulty);
    }

}

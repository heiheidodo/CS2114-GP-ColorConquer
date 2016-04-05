package groupprojectdominate;

import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * The class is a main screen before the gaming parts.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */
public class MainScreen
    extends Screen
{
    // ----------------------------------------------------------

    private boolean startB;
    private boolean helpB;
    private boolean difficultyB;
    private boolean creditB;


    /**
     * Initialize the screen.
     */
    public void initialize()
    {
        // setBackgroundColor(Color.rgb(193, 232, 239));
        startB = false;
        helpB = false;
        difficultyB = false;
        creditB = false;
        setAllStuff();
    }


    // ----------------------------------------------------------
    /**
     * The method is to get help dialogue when help is clicked.
     */
    public void helpClicked()
    {
        // introduce a new help dialogue
        startB = false;
        helpB = true;
        difficultyB = false;
        creditB = false;
        setAllStuff();
    }


    // ----------------------------------------------------------
    /**
     * The method is to change difficulty when setting button is clicked.
     */
    public void difficultyClicked()
    {
        // change settings
        startB = false;
        helpB = false;
        difficultyB = true;
        creditB = false;
        setAllStuff();
    }


    // ----------------------------------------------------------
    /**
     * The method is to check if start button is clicked.
     */
    public void startClicked()
    {
        // transfer to game screen
        startB = true;
        helpB = false;
        difficultyB = false;
        creditB = false;
        setAllStuff();
    }


    // ----------------------------------------------------------
    /**
     * The method is to see credit when credit button is clicked.
     */
    public void creditClicked()
    {
        // appear credit dialogue
        startB = false;
        helpB = false;
        difficultyB = false;
        creditB = true;
        setAllStuff();
    }


    // ----------------------------------------------------------
    /**
     * The method is to set all stuff work.
     */
    public void setAllStuff()
    {
        String titleH = "Help";
        String msgH =
            "The game is a color conquerer. You should touch the "
                + "color to change the top left one to swallow all the "
                + "connecting cells which have the same color. " +  '\n'
                + "The winning requirement is to make the color palette into "
                + "one color.";
        String titleC = "Credit";
        String msgC =
            "CS 2114 goup of 3: " + '\n' + "Michael Harvey" +  '\n' + "Yong kim"
                +  '\n' + "Sheng Zhou";

        if (helpB)
        {
            showAlertDialog(titleH, msgH);
        }
        if (creditB)
        {
            showAlertDialog(titleC, msgC);
        }
        if (difficultyB)
        {
            presentScreen(DiffScreen.class);
        }
        if (startB)
        {
            presentScreen(DiffScreen.class);
        }
    }

}

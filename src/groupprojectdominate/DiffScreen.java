package groupprojectdominate;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 *  The method is to show the screen which uses to change the difficulty.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */
public class DiffScreen extends Screen
{
    // ----------------------------------------------------------
    /**
     * Create a new Another object.
     */
    public DiffScreen()
    {
        // nothing
    }

    // ----------------------------------------------------------
    /**
     * When easy button is clicked, change the game mode to be easy.
     */
    public void easyClicked()
    {
        presentScreen(MainGameScreen.class, 8, 15);
    }

    // ----------------------------------------------------------
    /**
     * When medium button is clicked, change the game mode to be medium.
     */
    public void mediumClicked()
    {
        presentScreen(MainGameScreen.class, 12, 22);
    }

    // ----------------------------------------------------------
    /**
     * When hard button is clicked, change the game mode to be hard.
     */
    public void hardClicked()
    {
        presentScreen(MainGameScreen.class, 16, 30);
    }

    // ----------------------------------------------------------
    /**
     * When back button clicked, the game will return to main menu.
     */
    public void backClicked()
    {
        finish();
    }
}
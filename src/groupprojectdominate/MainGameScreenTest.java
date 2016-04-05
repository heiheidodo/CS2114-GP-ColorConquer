package groupprojectdominate;

import sofia.graphics.Color;
import android.widget.Button;


// -------------------------------------------------------------------------
/**
 *  Test class for MainGameScreen class.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */
public class MainGameScreenTest
    extends student.AndroidTestCase<MainGameScreen>
{


    MainGameScreen mainGame;
    ColorConquerer cc;

    private Button yellow;
    private Button green;
    private Button red;
    private Button pink;
    private Button navy;
    private Button blue;

    // ----------------------------------------------------------
    /**
     * Create a new MainGameScreenTest object.
     */
    public MainGameScreenTest()
    {
        super(MainGameScreen.class);
    }



    public void setUp()
    {
        mainGame = new MainGameScreen();
        mainGame.initialize(5, 5);
    }

    public void testButtons()
    {
        click(yellow);

    }

    public void testWinOrLose()
    {
        //cc.
    }
//    public void winOrLose()
//    {
//        if (cc.isVictory())
//        {
//            String win = "Congratulations!";
//            String msgn = "You win!";
//            showAlertDialog(win, msgn);
//        }
//        else if (cc.outOfTurns())
//        {
//            String lose = "Sorry";
//            String msgL = "You lose!";
//            showConfirmationDialog(lose, msgL);
//        }
//    }
}

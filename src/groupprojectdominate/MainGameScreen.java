package groupprojectdominate;

import android.widget.Button;
import java.util.Random;
import sofia.graphics.Color;
import android.widget.TextView;
import sofia.graphics.ShapeView;
import sofia.app.ShapeScreen;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

// -------------------------------------------------------------------------
/**
 * This is a Main game screen class that displays the actual game board
 * and allows the user to interact with the board to play game as described
 * on how to play.
 *
 * @author Michael Harvey (harveymg), Yong Kim (yak22), Sheng Zhou (zsheng2)
 * @version 2013.05.05
 */
public class MainGameScreen
    extends ShapeScreen
{
    ShapeView              shapeView;
    private float          tileHeight;
    private float          tileWidth;
    private float          left;
    private float          top;
    private float          right;
    private float          bottom;
    private float          min;
    private Tiles[][]      tile;
    private static Color[] colors   = { Color.yellow, Color.blue, Color.pink,
        Color.navy, Color.green, Color.red };
    ColorConquerer         cc;
    private TextView step;
    private int diff;
    private int steps;
    private Button yellow;
    private Button green;
    private Button red;
    private Button pink;
    private Button navy;
    private Button blue;


    // ----------------------------------------------------------
    /**
     * Initialize the maze.
     * @param size of board.
     * @param turn maximum.
     */
    public void initialize(int size, int turn)
    {
        yellow.setEnabled(true);
        red.setEnabled(true);
        green.setEnabled(true);
        pink.setEnabled(true);
        blue.setEnabled(true);
        navy.setEnabled(true);
        cc = new ColorConquerer(colors, size, turn);
        step.setText(cc.getTurns() + "/" + turn);
        steps = turn;
        diff = size;
        tile = new Tiles[size][size];
        tileHeight = (shapeView.getHeight() / size);
        tileWidth = (shapeView.getWidth() / size);

        min = Math.min(tileHeight, tileWidth);

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                left = min * i;
                top = min * j;
                right = left + min;
                bottom = top + min;
                tile[j][i] = new Tiles(left, top, right, bottom);

                Location loc = new Location(j, i);
                tile[j][i].setColor(cc.getColorAt(loc));
                add(tile[j][i]);
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Change colors of blocks to yellow.
     */
    public void yellowClicked()
    {
        cc.updateColors(Color.yellow);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }

    // ----------------------------------------------------------
    /**
     * Change colors of blocks to green.
     */
    public void greenClicked()
    {
        cc.updateColors(Color.green);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }

    // ----------------------------------------------------------
    /**
     * Change colors of blocks to pink.
     */
    public void pinkClicked()
    {
        cc.updateColors(Color.pink);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }


    // ----------------------------------------------------------
    /**
     * Change colors of blocks to navy.
     */
    public void navyClicked()
    {
        cc.updateColors(Color.navy);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }


    // ----------------------------------------------------------
    /**
     * Change colors of blocks to red.
     */
    public void redClicked()
    {
        cc.updateColors(Color.red);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }


    // ----------------------------------------------------------
    /**
     * Change colors of blocks to blue.
     */
    public void blueClicked()
    {
        cc.updateColors(Color.blue);
        updateTiles();
        step.setText(cc.getTurns() + "/" + steps);
        winOrLose();
    }

    // ----------------------------------------------------------
    /**
     * Updates the colors of the squares when matching color button is clicked.
     */
    public void updateTiles()
    {
        for (int i = 0; i < diff; i++)
        {
            for (int j = 0; j < diff; j++)
            {
                Location loc = new Location(j, i);
                tile[j][i].setColor(cc.getColorAt(loc));
                add(tile[j][i]);
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * When won or lost, buttons are disabled, and shows related message.
     */
    public void winOrLose()
    {
        if (cc.isVictory())
        {
            yellow.setEnabled(false);
            red.setEnabled(false);
            green.setEnabled(false);
            pink.setEnabled(false);
            blue.setEnabled(false);
            navy.setEnabled(false);

            String win = "Congratulations!";
            String msgn = "You win!";
            showAlertDialog(win, msgn);
        }
        else if (cc.outOfTurns())
        {
            yellow.setEnabled(false);
            red.setEnabled(false);
            green.setEnabled(false);
            pink.setEnabled(false);
            blue.setEnabled(false);
            navy.setEnabled(false);

            String lose = "Sorry";
            String msgL = "You lose!";
            showAlertDialog(lose, msgL);
        }
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

/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 3
 */

package se.hig.oodp.lab.model.simplefigure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.figure.Movable;
import se.hig.oodp.lab.model.figure.Scalable;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date    Oct 1, 2015
 */
public abstract class SimpleFigure implements Movable
{
    protected Vertex2D position;

    public SimpleFigure(Vertex2D position)
    {
        this.position = position;
    }

    /**
     * Move (translate) the SimpleFigure by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        position = position.moveBy(dx, dy);
    }

    /**
     * Calculates and returns the center point of this SimpleFigure.
     * @return      the center point of this SimpleFigure
     */
    public Vertex2D getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return "Position: (" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}

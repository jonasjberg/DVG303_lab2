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
import se.hig.oodp.lab.model.figure.Constants;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Point extends SimpleFigure
{
    /**
     * Creates a new instance of 'Point'.
     * @param position  position of the Point
     */
    public Point(Vertex2D position)
    {
        super(position);
    }

    /**
     * Returns the object data in a somewhat more "human readable" format.
     * @return      object data as a string
     */
    @Override
    public String toString()
    {
        final String NEWLINE = Constants.NEWLINE;
        StringBuilder str = new StringBuilder();

        /* Anropa först superklassens 'toString()'-metod. */
        // str.append(super.toString());

        /* Utöka sedan med 'Point'-objektets data. */
        str.append("Point:  " + this.hashCode() + NEWLINE);
        str.append("  pos: (" + getPosition().getX() + ", " + getPosition().getY()
                   + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}

/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 3
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.utility.DebugLogger;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 1, 2015
 */
public class Square extends Figure
{
    private Vertex2D v0, v1, v2, v3;
    private double sideLength;

    /**
     * Creates a new instance of a 'Square' with a position point,
     * with the sides at the specified length.
     * @param position     position point of the square
     * @param sideLength length of this squares sides
     */
    public Square(Vertex2D position, double sideLength)
    {
        super(position);

        this.sideLength = sideLength;

        calculateVerticesFromCenter();
        addVerticesToList(v0, v1, v2, v3);
    }

    /**
     * Calculates positions for vertices v0, v1, v2 and v3 from a position point
     * and a sideLength. The vertices are then moved to these new positions.
     */
    private void calculateVerticesFromCenter()
    {
        /*        |
         *   v3 o~~~~~~~o v2
         *      | |     |
         * -----|-+-----|-----
         *      | |     |
         *   v0 o~~~~~~~o v1
         *        |
         */

        double halfSideLength = sideLength / 2;
        double xCenter = position.getX();
        double yCenter = position.getY();
        v0 = new Vertex2D(xCenter - halfSideLength, yCenter - halfSideLength);
        v1 = new Vertex2D(xCenter + halfSideLength, yCenter - halfSideLength);
        v2 = new Vertex2D(xCenter + halfSideLength, yCenter + halfSideLength);
        v3 = new Vertex2D(xCenter - halfSideLength, yCenter + halfSideLength);
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
        str.append(super.toString());

        /* Utöka sedan med 'Point'-objektets data. */
        str.append("Square:  " + this.hashCode() + NEWLINE);
        str.append("    v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("    v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append("    v2: (" + v2.getX() + ", " + v2.getY() + ")" + NEWLINE);
        str.append("    v3: (" + v3.getX() + ", " + v3.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }

    /**
     *
     * Calculate the position point of this Square using the bounding box
     * method outlined in the lab instructions (oodp_instruktioner_ht15v4.pdf, page 5)
     */
    @Override
    public void updateCenterPoint(double xFactor, double yFactor)
    {
        position = position.scale(getPosition(), xFactor, yFactor);
    }
}

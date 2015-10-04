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
 * @date	Sep 27, 2015
 */
public class Line extends Figure
{
    private Vertex2D v0, v1;

    /**
     * Creates a new instance of 'Line' consisting of vertices 'v0' and 'v1'.
     * @param v0    first point of this Line    ("start")
     * @param v1    second point of this Line   ("end")
     */
    public Line(Vertex2D v0, Vertex2D v1)
    {
        super();
        this.v0 = v0;
        this.v1 = v1;

        addVerticesToList(v0, v1);
        updateCenterPoint(0, 0);
    }

    /**
     * Calculate the position point of this Line using the "distance formula".
     */
    public void updateCenterPoint(double xFactor, double yFactor)
    {
        double v0X, v0Y, v1X, v1Y;
        v0X = getVertex(0).getX();
        v0Y = getVertex(0).getY();
        v1X = getVertex(1).getX();
        v1Y = getVertex(1).getY();

        double xMid = v0X + ((v1X - v0X) / 2);
        double yMid = v0Y + ((v1Y - v0Y) / 2);

        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid + ")");

        if (position == null) {
            position = new Vertex2D(DEFAULT_X_COORD, DEFAULT_Y_COORD);
            DebugLogger.log.fine("Created new 'position' (was null) ..");
        }

        position = position.moveTo(xMid, yMid);
    }

    @Override
    public String toString()
    {
        final String NEWLINE = Constants.NEWLINE;
        StringBuilder str = new StringBuilder();

        /* Anropa först superklassens 'toString()'-metod. */
        str.append(super.toString());

        /* Utöka sedan med 'Point'-objektets data. */
        str.append("Line:  " + this.hashCode() + NEWLINE);
        str.append("position: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("    v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("    v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}

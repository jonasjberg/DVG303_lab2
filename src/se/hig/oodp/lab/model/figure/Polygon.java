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
 * @date	Oct 4, 2015
 */
public class Polygon extends Figure implements Movable, Rotatable, Scalable
{
    /**
     * Creates a new instance of a 'Polygon' consisting of an arbitrary number
     * of vertices.
     * @param position  center position of this polygon
     * @param vertices  vertices that makes up this polygon
     */
    public Polygon(Vertex2D position, Vertex2D... vertices)
    {
        this.position = position;

        for (Vertex2D v : vertices) {
            if (v == null)
                continue;
            this.vertices.add(v);
        }

        calculateCenterPoint();
    }

    /**
     * Calculate the position point of this Rectangle using the bounding box
     * method outlined in the lab instructions (oodp_instruktioner_ht15v4.pdf, page 5)
     */
    public void calculateCenterPoint()
    {
        double xMin, yMin, xMax, yMax;
        xMin = yMin = xMax = yMax = Double.MIN_VALUE;

        if (position == null) {
            position = new Vertex2D(DEFAULT_X_COORD, DEFAULT_Y_COORD);
            DebugLogger.log.fine("Created new 'position' (was null) ..");
        }

        for (Vertex2D v : vertices) {
            xMin = Math.min(xMin, v.getX());
            yMin = Math.min(yMin, v.getY());
            xMax = Math.max(xMax, v.getX());
            yMax = Math.max(yMax, v.getY());
        }

        double xMid = (xMin + xMax) / 2;
        double yMid = (yMin + yMax) / 2;
        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid + ")");
        position = position.moveTo(xMid, yMid);
    }

    @Override
    public void updateCenterPoint(double xFactor, double yFactor)
    {
        calculateCenterPoint();
    }
}

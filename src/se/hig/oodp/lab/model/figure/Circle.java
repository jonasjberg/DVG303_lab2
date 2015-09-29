/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.utility.DebugLogger;
import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Circle extends Figure
{
    private Vertex2D center;
    private double   radius;

    /**
     * Creates a new instance of a 'Circle'.
     * @param center    center point
     */
    public Circle(Vertex2D center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Move (translate) the Circle by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        center = center.moveBy(dx, dy);
    }

    /**
     * Scale the Circle by 'factor' from a reference point.
     * @param factor    scaling factor
     */
    public void scale(double factor)
    {
        if (factor == 0) {
            DebugLogger.log.warning("Scaling factor is 0");
        }
        radius = radius * factor;
    }

    /**
     * Calculates and returns the center point of this Circle.
     * @return      the center point of this Circle
     */
    public Vertex2D getCenter()
    {
        return center;
    }

    /**
     * Get vertex number 'n' from the vertices list.
     * @param n     vertex to return
     * @return      vertex at index 'n'
     */
    public Vertex2D getVertex(int n)
    {
        if (n != 0) {
            DebugLogger.log.warning("Circle only has one Vertex2D, center.");
        }
        return center;
    }

    /**
     * Return the radius of this Circle
     * @return      radius of the circle
     */
    public double getRadius()
    {
        return radius;
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
        str.append("Circle:  " + this.hashCode() + NEWLINE);
        str.append("center: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("radius:  " + getRadius() + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}

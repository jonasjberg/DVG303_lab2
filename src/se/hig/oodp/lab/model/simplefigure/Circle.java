/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 3
 */

package se.hig.oodp.lab.model.simplefigure;

import se.hig.oodp.lab.model.figure.Constants;
import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.utility.DebugLogger;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Circle extends SimpleFigure
{
    private double radius;

    /**
     * Creates a new instance of a 'Circle'.
     * @param position  center point of the circle
     * @param radius    radius of the circle
     */
    public Circle(Vertex2D position, double radius)
    {
        super(position);

        this.radius = radius;
    }

    /**
     * scale the circle by 'factor' from a reference point.
     * @param factor    scaling factor
     */
    public void scale(double factor)
    {
        if (factor == 0) {
            DebugLogger.log.warning("scaling factor is 0");
        }
        radius = radius * factor;
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
        str.append("center: (" + getPosition().getX() + ", " + getPosition().getY() + ")" + NEWLINE);
        str.append("radius:  " + getRadius() + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}

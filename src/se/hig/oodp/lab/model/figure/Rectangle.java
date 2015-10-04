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
public class Rectangle extends Figure
{
    private Vertex2D v0, v1, v2, v3;
    private double   width, height;

    /**
     * Creates a new instance of a 'Rectangle' with a position point,
     * with the specified width and height.
     * @param position    position point of Rectangle
     * @param width     width of the Rectangle
     * @param height    height of the Rectangle
     */
    public Rectangle(Vertex2D position, double width, double height)
    {
        super(position);

        this.width = width;
        this.height = height;

        calculateVerticesFromCenter();
        addVerticesToList(v0, v1, v2, v3);
    }

    /**
     * Creates a new instance of a 'Rectangle' from 4 vertices (points).
     * @param v0    lower left corner of the rectangle
     * @param v1    lower right corner of the rectangle
     * @param v2    upper right corner of the rectangle
     * @param v3    upper left corner of the rectangle
     */
    public Rectangle(Vertex2D v0, Vertex2D v1, Vertex2D v2, Vertex2D v3)
    {
        super();

        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;

        addVerticesToList(v0, v1, v2, v3);
        calculateWidth();
        calculateHeight();
    }

    /**
     * Calculates positions for vertices v0, v1, v2 and v3 from a position point,
     * a width and a height. The vertices are then moved to these new positions.
     */
    private void calculateVerticesFromCenter()
    {
        /*        |
         *   v3 o~~~~~~~~~~~o v2
         *      | |         |
         * -----|-+---------|-----
         *   v0 o~~~~~~~~~~~o v1
         *        |
         */

        double halfHeight = height / 2;
        double halfWidth = width / 2;
        double xCenter = position.getX();
        double yCenter = position.getY();
        v0 = new Vertex2D(xCenter - halfWidth, yCenter - halfHeight);
        v1 = new Vertex2D(xCenter + halfWidth, yCenter - halfHeight);
        v2 = new Vertex2D(xCenter + halfWidth, yCenter + halfHeight);
        v3 = new Vertex2D(xCenter - halfWidth, yCenter + halfHeight);
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
        str.append("Rectangle:  " + this.hashCode() + NEWLINE);
        str.append("   position: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("       v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("       v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append("       v2: (" + v2.getX() + ", " + v2.getY() + ")" + NEWLINE);
        str.append("       v3: (" + v3.getX() + ", " + v3.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }

    /**
     * Calculate the position point of this Rectangle using the bounding box
     * method outlined in the lab instructions (oodp_instruktioner_ht15v4.pdf, page 5)
     */
    @Override
    public void updateCenterPoint(double xFactor, double yFactor)
    {
//        double xMin, yMin, xMax, yMax;
//        xMin = yMin = xMax = yMax = Double.MIN_VALUE;
//
//        for (Vertex2D v : vertices) {
//            xMin = Math.min(xMin, v.getX());
//            yMin = Math.min(yMin, v.getY());
//            xMax = Math.max(xMax, v.getX());
//            yMax = Math.max(yMax, v.getY());
//        }
//
//        double xMid = xMin + xMax / 2;
//        double yMid = yMin + yMax / 2;
//        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid + ")");
//
//        position = new Vertex2D(xMid, yMid);
        position = position.scale(getPosition(), xFactor, yFactor);
    }

    /**
     * Calculate the width from the vertex positions.
     */
    private void calculateWidth()
    {
        /* Subtract upper right corner X from upper left corner Y. */
        width = v1.getX() - v0.getX();

        /* "Belt and suspenders" checking. Most probably not necessary.. */
        double checkWidth = v3.getX() - v2.getX();
        if (width != checkWidth) {
            DebugLogger.log.warning("WARNING: Width calculation is acting up ..");
        }
    }

    /**
     * Calculate the height from the vertex positions.
     */
    private void calculateHeight()
    {
        /* Subtract upper left corner Y from lower left corner Y. */
        height = v2.getY() - v0.getY();

        /* "Belt and suspenders" checking. Most probably not necessary.. */
        double checkHeight = v3.getY() - v1.getY();
        if (height != checkHeight) {
            DebugLogger.log.warning("WARNING: Height calculation is acting up ..");
        }
    }
}

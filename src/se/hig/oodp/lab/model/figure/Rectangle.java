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

import java.util.ArrayList;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Rectangle extends Figure
{
    private Vertex2D            v0, v1, v2, v3, center;
    private ArrayList<Vertex2D> vertices = new ArrayList<Vertex2D>();
    private double              width, height;

    /**
     * Creates a new instance of a 'Rectangle'.
     * @param center    center point of Rectangle
     * @param width     width of the Rectangle
     * @param height    height of the Rectangle
     */
    public Rectangle(Vertex2D center, double width, double height)
    {
        this.center = center;
        this.width = width;
        this.height = height;
        calculateVerticesFromCenter();
        addVerticesToList(v0, v1, v2, v3);
    }

    /**
     * Calculates the position of vertices v0, v1, v2, v3.
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
        double xCenter = center.getX();
        double yCenter = center.getY();
        v0 = new Vertex2D(xCenter - halfWidth, yCenter - halfHeight);
        v1 = new Vertex2D(xCenter + halfWidth, yCenter - halfHeight);
        v2 = new Vertex2D(xCenter + halfWidth, yCenter + halfHeight);
        v3 = new Vertex2D(xCenter - halfWidth, yCenter + halfHeight);
    }

    /**
     * Rotate the Rectangle by 'angle' degrees clockwise from a reference point.
     * @param angle         rotate clockwise by this angle in degrees
     */
    public void rotate(double angle)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == null) {
                DebugLogger.log.warning("Got null value!");
                continue;
            }

            Vertex2D temp = getVertex(i).rotate(center, angle);
            vertices.set(i, temp);
        }
    }

    /**
     * Scale the Rectangle by 'xFactor' and 'yFactor' from a reference point.
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    public void scale(double xFactor, double yFactor)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == null) {
                DebugLogger.log.warning("Got null value!");
                continue;
            }

            Vertex2D temp = getVertex(i).scale(center, xFactor, yFactor);
            vertices.set(i, temp);
            updateCenterPoint();
        }
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
        str.append("   center: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("       v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("       v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append("       v2: (" + v2.getX() + ", " + v2.getY() + ")" + NEWLINE);
        str.append("       v3: (" + v3.getX() + ", " + v3.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }

    /**
     * Calculate the center point of this Rectangle using the bounding box
     * method outlined in the lab instructions (oodp_instruktioner_ht15v4.pdf, page 5)
     */
    private void updateCenterPoint()
    {
        double xMin, yMin, xMax, yMax;
        xMin = yMin = xMax = yMax = Double.MIN_VALUE;

        for (Vertex2D v : vertices) {
            xMin = Math.min(xMin, v.getX());
            yMin = Math.min(yMin, v.getY());
            xMax = Math.max(xMax, v.getX());
            yMax = Math.max(yMax, v.getY());
        }

        double xMid = xMin + xMax / 2;
        double yMid = yMin + yMax / 2;
        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid + ")");

        center = new Vertex2D(xMid, yMid);
    }

    /**
     * Convenience-method for adding a bunch of vertices to list 'vertices'.
     * @param vertices      Vertex2D vertices to add to the list 'vertices'
     */
    private void addVerticesToList(Vertex2D... newVertices)
    {
        for (int i = 0; i < newVertices.length; i++) {
            if (newVertices[i] == null)
                continue;

            vertices.add(newVertices[i]);
            DebugLogger.log.finer("Added to list: "
                                  + newVertices[i].toString());
        }
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

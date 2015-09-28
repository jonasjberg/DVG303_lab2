/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.utility.DebugLogger;

import java.util.ArrayList;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 29, 2015
 */
public class Square
{
    private Vertex2D            v0, v1, v2, v3, center;
    private ArrayList<Vertex2D> vertices = new ArrayList<Vertex2D>();
    private double side;

    /**
     * Creates a new instance of a 'Rectangle'.
     * @param center    center point of Rectangle
     * @param side      length of the Rectangle sides
     */
    public Square(Vertex2D center, double side)
    {
        this.center = center;
        this.side = side;

        calculateVerticesFromCenter();
        addVerticesToList(v0, v1, v2);
    }

    /**
     * Calculates the position of vertices v0, v1, v2, v3.
     */
    private void calculateVerticesFromCenter()
    {
        /*        |
         *   v3 o~~~~~o v2
         *      | |   |
         * -----|-+---|-----
         *   v0 o~~~~~o v1
         *        |
         */

        double halfSide = side / 2;
        double xCenter = center.getX();
        double yCenter = center.getY();
        v0 = new Vertex2D(xCenter - halfSide, yCenter - halfSide);
        v1 = new Vertex2D(xCenter + halfSide, yCenter - halfSide);
        v2 = new Vertex2D(xCenter + halfSide, yCenter + halfSide);
        v3 = new Vertex2D(xCenter - halfSide, yCenter + halfSide);
    }

    /**
     * Move (translate) the Square by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == null) {
                DebugLogger.log.warning("Got null value!");
                continue;
            }

            Vertex2D temp = getVertex(i).moveBy(dx, dy);
            vertices.set(i, temp);
        }

        center = center.moveBy(dx, dy);
    }

    /**
     * Rotate the Square by 'angle' degrees clockwise from a reference point.
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
        str.append("Square:  " + this.hashCode() + NEWLINE);
        str.append("center: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("    v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("    v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append("    v2: (" + v2.getX() + ", " + v2.getY() + ")" + NEWLINE);
        str.append("    v3: (" + v3.getX() + ", " + v3.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
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
        // vertices.add(v);
        // System.out.println("Added to list: " + v.toString());
        // DebugLogger.log.fine("Added to list: " + v.toString());

    }

    /**
     * Get vertex number 'n' from the vertices list.
     * @param n     vertex to return
     * @return      vertex at index 'n'
     */
    public Vertex2D getVertex(int n)
    {
        if (n < 0 || n > vertices.size()) {
            DebugLogger.log.warning("Index out of bounds!");
            return null;
        }

        return vertices.get(n);
    }

    /**
     * Calculates and returns the center point of this Rectangle.
     * @return      the center point of this Rectangle
     */
    public Vertex2D getCenter()
    {
        return center;
    }
}

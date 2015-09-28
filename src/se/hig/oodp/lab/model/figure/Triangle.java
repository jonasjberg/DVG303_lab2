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
 * @date	Sep 27, 2015
 */
public class Triangle
{
    private static final int    DEFAULT_X_COORD = Constants.DEFAULT_X_COORD;
    private static final int    DEFAULT_Y_COORD = Constants.DEFAULT_Y_COORD;
    private Vertex2D            v0, v1, v2, center;
    private ArrayList<Vertex2D> vertices        = new ArrayList<Vertex2D>();

    /**
     * Creates a new instance of a 'Triangle'.
     * @param center    center point
     */
    public Triangle(Vertex2D v0, Vertex2D v1, Vertex2D v2)
    {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;

        addVerticesToList(v0, v1, v2);
        updateCenterPoint();
    }

    /**
     * Calculate the center point of this Rectangle using the bounding box
     * method outlined in the lab instructions (oodp_instruktioner_ht15v4.pdf, page 5)
     */
    private void updateCenterPoint()
    {
        double xMin, yMin, xMax, yMax;
        xMin = yMin = xMax = yMax = Double.MIN_VALUE;

        if (center == null) {
            center = new Vertex2D(DEFAULT_X_COORD, DEFAULT_Y_COORD);
            DebugLogger.log.fine("Created new 'center' (was null) ..");
        }

        for (Vertex2D v : vertices) {
            xMin = Math.min(xMin, v.getX());
            yMin = Math.min(yMin, v.getY());
            xMax = Math.max(xMax, v.getX());
            yMax = Math.max(yMax, v.getY());
        }

        double xMid = (xMin + xMax) / 2;
        double yMid = (yMin + yMax) / 2;
        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid
                              + ")");
        // System.out.println("calculated midpoint (" + xMid + ", " + yMid + ")");
        center = center.moveTo(xMid, yMid);
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
     * Move (translate) the Triangle by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        System.out.println("triangle pre-move: " + center.toString());
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == null) {
                DebugLogger.log.warning("Got null value!");
                continue;
            }

            Vertex2D temp = getVertex(i).moveBy(dx, dy);
            vertices.set(i, temp);
        }

        center = center.moveBy(dx, dy);
        System.out.println("triangle post-move: " + center.toString());
    }

    /**
     * Rotate the Triangle by 'angle' degrees clockwise from a reference point.
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
     * Scale the Triangle by 'xFactor' and 'yFactor' from a reference point.
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
        // updateCenterPoint();
        return center;
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
        str.append("Triangle:  " + this.hashCode() + NEWLINE);
        str.append("  center: (" + getCenter().getX() + ", " + getCenter().getY() + ")" + NEWLINE);
        str.append("      v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("      v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append("      v2: (" + v2.getX() + ", " + v2.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}

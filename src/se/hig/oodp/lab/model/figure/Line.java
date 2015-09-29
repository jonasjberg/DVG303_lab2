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
public class Line
{
    private static final int    DEFAULT_X_COORD = Constants.DEFAULT_X_COORD;
    private static final int    DEFAULT_Y_COORD = Constants.DEFAULT_Y_COORD;
    private Vertex2D            v0, v1, center;
    private ArrayList<Vertex2D> vertices        = new ArrayList<Vertex2D>();

    /**
     * Creates a new instance of 'Line' consisting of vertices 'v0' and 'v1'.
     * @param v0    first point of this Line    ("start")
     * @param v1    second point of this Line   ("end")
     */
    public Line(Vertex2D v0, Vertex2D v1)
    {
        this.v0 = v0;
        this.v1 = v1;

        addVerticesToList(v0, v1);
        updateCenterPoint();
    }

    /**
     * Move (translate) the Line by [dx, dy] from its current position.
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
        // v0 = v0.moveBy(dx, dy);
        // v1 = v1.moveBy(dx, dy);
        updateCenterPoint();
    }

    /**
     * Rotate the Line by 'angle' degrees clockwise from a reference point.
     * @param angle
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
        //        v0 = v0.rotate(center, angle);
        //        v1 = v1.rotate(center, angle);
    }

    /**
     * Scale the Line by 'xFactor' and 'yFactor' from a reference point.
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
        }
        //        v0 = v0.scale(center, xFactor, yFactor);
        //        v1 = v1.scale(center, xFactor, yFactor);
    }

    /**
     * Calculates and returns the center point of this Line.
     * @return      the Line center point
     */
    public Vertex2D getCenter()
    {
        //        updateCenterPoint();
        return center;
    }

    /**
     * Calculate the center point of this Line using the "distance formula".
     */
    private void updateCenterPoint()
    {
        double v0X, v0Y, v1X, v1Y;
        v0X = getVertex(0).getX();
        v0Y = getVertex(0).getY();
        v1X = getVertex(1).getX();
        v1Y = getVertex(1).getY();

        double xMid = v0X + ((v1X - v0X) / 2);
        double yMid = v0Y + ((v1Y - v0Y) / 2);

        DebugLogger.log.finer("calculated midpoint (" + xMid + ", " + yMid
                              + ")");

        if (center == null) {
            center = new Vertex2D(DEFAULT_X_COORD, DEFAULT_Y_COORD);
            DebugLogger.log.fine("Created new 'center' (was null) ..");
        }
        // center = new Vertex2D(xMid, yMid);
        center = center.moveTo(xMid, yMid);
    }

    @Override
    public String toString()
    {
        final String NEWLINE = Constants.NEWLINE;
        StringBuilder str = new StringBuilder();

        /* Anropa först superklassens 'toString()'-metod. */
        // str.append(super.toString());

        /* Utöka sedan med 'Point'-objektets data. */
        str.append("Line:  " + this.hashCode() + NEWLINE);
        str.append("center: (" + getCenter().getX() + ", " + getCenter().getY()
                   + ")" + NEWLINE);
        str.append("    v0: (" + v0.getX() + ", " + v0.getY() + ")" + NEWLINE);
        str.append("    v1: (" + v1.getX() + ", " + v1.getY() + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }

    /**
     * Convenience-method for adding a bunch of vertices to list 'vertices'.
     * @param vertices      Vertex2D vertices to add to the list 'vertices'
     */
    private void addVerticesToList(Vertex2D... newVertices)
    {
        for (Vertex2D v : newVertices) {
            if (v == null)
                continue;
            vertices.add(v);
            DebugLogger.log.fine("Added Vertex2D: " + v.toString());
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
}

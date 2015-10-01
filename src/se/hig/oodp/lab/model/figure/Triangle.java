/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.utility.DebugLogger;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Triangle extends Figure
{
    private Vertex2D v0, v1, v2;
    private double   width, height;

    /**
     * Creates a new instance of a 'Triangle' from a center point,
     * width and height.
     * @param v0    triangle point 0
     * @param v1    triangle point 1
     * @param v2    triangle point 2
     */
    public Triangle(Vertex2D center, double width , double height)
    {
        super(center);

        this.width = width;
        this.height = height;

        calculateVerticesFromCenter();
        addVerticesToList(v0, v1, v2);
    }

    /**
     * Creates a new instance of a 'Triangle' from three Vertex2D points.
     * @param v0    triangle point 0
     * @param v1    triangle point 1
     * @param v2    triangle point 2
     */
    public Triangle(Vertex2D v0, Vertex2D v1, Vertex2D v2)
    {
        super();

        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;

        addVerticesToList(v0, v1, v2);
        updateCenterPoint();
    }

    private void calculateVerticesFromCenter()
    {
        /*            |
         *            |   o v2         'width' is X distance between v0 and v1
         *            |  / \          'height' is Y distance from the base to v2
         *            | /   \
         * -----------+/-----\-----
         *            /       \
         *           /|        \
         *       v0 o~~~~~~~~~~~o v1
         *            |
         */

        double x = center.getX();
        double y = center.getY();
        v0 = new Vertex2D(x - width, y - height);
        v1 = new Vertex2D(x + width, y - height);
        v2 = new Vertex2D(x, y + height);
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

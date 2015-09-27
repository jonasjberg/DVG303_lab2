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

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Line
{
    private Vertex2D v0, v1, center;

    /**
     * Creates a new instance of 'Line' consisting of vertices 'v0' and 'v1'.
     * @param v0    first point of this Line    ("start")
     * @param v1    second point of this Line   ("end")
     */
    public Line(Vertex2D v0, Vertex2D v1)
    {
        this.v0 = v0;
        this.v1 = v1;
        calculateCenter();
    }

    /**
     * Move (translate) the Line by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        v0 = v0.moveBy(dx, dy);
        v1 = v1.moveBy(dx, dy);
        calculateCenter();
    }

    /**
     * Rotate the Line by 'angle' degrees clockwise from a reference point.
     * @param reference
     * @param angle
     */
    public void rotate(Vertex2D reference, double angle)
    {
        if (reference == null) return;
        v0 = v0.rotate(reference, angle);
        v1 = v1.rotate(reference, angle);
    }

    /**
     * Scale the Line by 'xFactor' and 'yFactor' from a reference point.
     * @param reference     reference point
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    public void scale(Vertex2D reference, double xFactor, double yFactor)
    {
        v0 = v0.scale(center, xFactor, yFactor);
        v1 = v1.scale(center, xFactor, yFactor);
    }

    /**
     * Calculates and returns the center point of this Line.
     * @return      the Line center point
     */
    public Vertex2D getCenter()
    {
        calculateCenter();
        return center;
    }

    /**
     * Calculate the center point of this Line using the "distance formula".
     */
    private void calculateCenter()
    {
        double xMid = v0.getX() + ((v1.getX() - v0.getX()) / 2);
        double yMid = v0.getY() + ((v1.getY() - v0.getY()) / 2);
        center = center.moveTo(xMid, yMid);
    }
}

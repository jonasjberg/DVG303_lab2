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

import java.util.ArrayList;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Rectangle
{
    private Vertex2D v0, v1, v2, v3, center;
    private ArrayList<Vertex2D> vertices = new ArrayList<Vertex2D>();
    private double width, height;

    /**
     * Creates a new instance of a 'Rectangle'.
     * @param v0    upper left corner
     * @param v1    upper right corner
     * @param v2    lower left corner
     * @param v3    lower right corner
     */
    public Rectangle(Vertex2D v0, Vertex2D v1, Vertex2D v2, Vertex2D v3)
    {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;

        addVerticesToList(v0, v1, v2, v3);

        calculateCenter();
        calculateWidth();
        calculateHeight();
    }

    private void calculateWidth()
    {
        /* Subtract upper right corner X from upper left corner Y. */
        width = v1.getX() - v0.getX();

        /* "Belt and suspenders" checking. Most probably not necessary.. */
        double checkWidth = v3.getX() - v2.getX();
        if (width != checkWidth) {
            System.out.println("WARNING: Width calculation is acting up ..");
        }
    }

    private void calculateHeight()
    {
        /* Subtract upper left corner Y from lower left corner Y. */
        height = v2.getY() - v0.getY();

        /* "Belt and suspenders" checking. Most probably not necessary.. */
        double checkHeight = v3.getY() - v1.getY();
        if (height != checkHeight) {
            System.out.println("WARNING: Height calculation is acting up ..");
        }
    }

    /**
     * Creates a new instance of a 'Rectangle'
     * @param v0        upper left corner
     * @param width     the width of this Rectangle
     * @param height    the height of this Rectangle
     */
    public Rectangle(Vertex2D v0, double width, double height)
    {
        this.v0 = v0;
        v1 = new Vertex2D(v0.getX() + width, v0.getY());
        v2 = new Vertex2D(v0.getX(), v0.getY() - height);
        v3 = new Vertex2D(v0.getX() + width, v0.getY() - height);
    }

    /**
     * Move (translate) the Rectangle by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        for (Vertex2D v : vertices) {
            if (v == null)
                continue;
            v = v.moveBy(dx, dy);
        }
    }

    /**
     * Rotate the Rectangle by 'angle' degrees clockwise from a reference point.
     * @param angle         rotate clockwise by this angle in degrees
     */
    public void rotate(double angle)
    {
        for (Vertex2D v : vertices) {
            if (v == null)
                continue;
            v.rotate(center, angle);
        }
    }

    /**
     * Scale the Rectangle by 'xFactor' and 'yFactor' from a reference point.
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    public void scale(double xFactor, double yFactor)
    {
        for (Vertex2D v : vertices) {
            if (v == null) {
                continue;
            }
            v.scale(center, xFactor, yFactor);
        }
    }

    @Override
    public String toString()
    {
        /* TODO: */
        return null;
    }

    /**
     * Calculate the center point of this Rectangle using the "distance formula".
     */
    private void calculateCenter()
    {
        /* TODO: Look into using width and/or height instead.. */
        double xMid = v0.getX() + ((v0.getX() + v1.getX()) / 2);
        double yMid = v0.getY() + ((v2.getY() - v0.getY()) / 2);
        center = center.moveTo(xMid, yMid);
    }

    /**
     * Convenience-method for adding a bunch of vertices to list 'vertices'.
     * @param vertices      Vertex2D vertices to add to the list 'vertices'
     */
    private void addVerticesToList(Vertex2D... vertices)
    {
        for (Vertex2D v : vertices) {
            if (v == null)
                continue;
            this.vertices.add(v);
        }
    }
}


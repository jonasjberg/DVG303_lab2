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

import java.util.ArrayList;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public abstract class Figure implements Movable, Rotatable, Scalable
{
    public    static final double DEFAULT_X_COORD = 0;
    public    static final double DEFAULT_Y_COORD = 0;
    protected Vertex2D            center;
    protected ArrayList<Vertex2D> vertices;

    /**
     * Constructor for a abstract 'Figure'
     * @param center    center position of this figure
     */
    public Figure(Vertex2D center)
    {
        this.center = center;
        vertices = new ArrayList<Vertex2D>();
    }

    /**
     * Constructor for a abstract 'Figure' with a "default" center position.
     */
    public Figure()
    {
        this(new Vertex2D(DEFAULT_X_COORD, DEFAULT_Y_COORD));
    }

    /**
     * Move (translate) the Figure by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    @Override
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
     * Rotate the Figure by 'angle' degrees clockwise from a reference point.
     * @param angle         rotate clockwise by this angle in degrees
     */
    @Override
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
     * Calculates and returns the center point of this Figure.
     * @return      the center point of this Figure
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
        if (n < 0 || n > vertices.size()) {
            DebugLogger.log.warning("Index out of bounds!");
            return null;
        }

        return vertices.get(n);
    }

    /**
     * Convenience-method for adding a bunch of vertices to list 'vertices'.
     * @param vertices      Vertex2D vertices to add to the list 'vertices'
     */
    public void addVerticesToList(Vertex2D... newVertices)
    {
        for (int i = 0; i < newVertices.length; i++) {
            if (newVertices[i] == null)
                continue;

            vertices.add(newVertices[i]);
            DebugLogger.log.finer("Added to list: " + newVertices[i].toString());
        }
    }

//    public abstract void scale(double xFactor, double yFactor);

    @Override
    public String toString()
    {
        return "center: (" + getCenter().getX() + ", " + getCenter().getY() + ")";
    }

    /**
     * Scale by 'xFactor' and 'yFactor'.
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    @Override
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

        center = center.scale(center, xFactor, yFactor);
    }
}

/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 2
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
public abstract class Figure
{
    private Vertex2D            center;
    private ArrayList<Vertex2D> vertices = new ArrayList<Vertex2D>();

    public Figure(Vertex2D center)
    {
        this.center = center;
    }

    /**
     * Move (translate) the Figure by [dx, dy] from its current position.
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
     * Calculates and returns the center point of this Figure.
     * @return      the center point of this Rectangle
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
    private void addVerticesToList(Vertex2D... newVertices)
    {
        for (int i = 0; i < newVertices.length; i++) {
            if (newVertices[i] == null)
                continue;

            vertices.add(newVertices[i]);
            DebugLogger.log.finer("Added to list: " + newVertices[i].toString());
        }
    }
}

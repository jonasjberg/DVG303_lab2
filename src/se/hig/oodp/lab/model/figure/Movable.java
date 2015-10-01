/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 3
 */

package se.hig.oodp.lab.model.figure;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 1, 2015
 */
public interface Movable
{
    /**
     * Move (translate) by [dx, dy] from the current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    void moveBy(double dx, double dy);
}

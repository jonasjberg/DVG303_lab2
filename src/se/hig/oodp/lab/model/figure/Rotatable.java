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
public interface Rotatable
{
    /**
     * Rotate by 'angle' degrees clockwise.
     * @param angle         rotate clockwise by this angle in degrees
     */
    void rotate(double angle);
}


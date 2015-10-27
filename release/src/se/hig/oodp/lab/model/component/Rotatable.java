/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.model.component;

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


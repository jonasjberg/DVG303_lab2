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
public interface Scalable
{
    /**
     * Scale by 'xFactor' and 'yFactor'.
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    void scale(double xFactor, double yFactor);
}


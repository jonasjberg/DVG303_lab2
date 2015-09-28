/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.model.figure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 28, 2015
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
                        PointTest.class,
                        LineTest.class,
                        RectangleTest.class,
                        TriangleTest.class,
                        CircleTest.class
                    })

public class AllTests { }

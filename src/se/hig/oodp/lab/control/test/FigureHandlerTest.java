/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.test;

import se.hig.oodp.lab.control.implementation.FigureHandlerImpl;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 8, 2015
 */
public class FigureHandlerTest
{
    private static final int[] XCOORDS = { -2, -1, 0, 1, 2 };
    private static final int[] YCOORDS = { 2, 1, 0, -1, -2 };
    private static final int   RADIUS  = 2;

    public static void main(String[] args)
    {
        FigureHandlerImpl figureHandlerImpl = new FigureHandlerImpl();
        figureHandlerImpl.createPoint(XCOORDS[0], YCOORDS[0]);
        figureHandlerImpl.createLine(XCOORDS[0], YCOORDS[0], XCOORDS[1],
                                     YCOORDS[1]);
        figureHandlerImpl.createRectangle(XCOORDS[0], YCOORDS[0], XCOORDS[1],
                                          YCOORDS[1]);
        figureHandlerImpl.createSquare(XCOORDS[0], YCOORDS[0], XCOORDS[1],
                                       YCOORDS[1]);
        figureHandlerImpl.createTriangle(XCOORDS[0], YCOORDS[0], XCOORDS[1],
                                         YCOORDS[1], XCOORDS[2], YCOORDS[2]);
        figureHandlerImpl.createCircle(XCOORDS[0], YCOORDS[0], RADIUS);
        figureHandlerImpl.createEllipse(XCOORDS[0], YCOORDS[0], 10, 5);
    }
}

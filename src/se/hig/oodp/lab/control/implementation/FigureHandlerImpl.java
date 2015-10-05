/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.implementation;

import se.hig.oodp.lab.control.FigureHandler;
import se.hig.oodp.lab.model.component.Movable;
import se.hig.oodp.lab.model.component.Rotatable;
import se.hig.oodp.lab.model.component.Scalable;
import se.hig.oodp.lab.model.figure.Figure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 5, 2015
 */
public class FigureHandlerImpl implements FigureHandler
{
    private List<Figure>    allFigures;
    private List<Movable>   movableFigures;
    private List<Rotatable> rotatableFigures;
    private List<Scalable>  scalableFigures;

    public FigureHandlerImpl()
    {
        allFigures       = new ArrayList<>();
        movableFigures   = new ArrayList<>();
        rotatableFigures = new ArrayList<>();
        scalableFigures  = new ArrayList<>();
    }

    @Override
    public void createCircle(double x, double y, double r)
    {

    }

    @Override
    public void createEllipse(double x, double y, double a, double b)
    {

    }

    @Override
    public void createLine(double x0, double y0, double x1, double y1)
    {

    }

    @Override
    public void createPoint(double x, double y)
    {

    }

    @Override

    public void createRectangle(double x, double y, double a, double b)
    {

    }

    @Override
    public void createSquare(double x, double y, double a, double b)
    {

    }

    @Override
    public void createTriangle(double vx0, double vy0, double vx1, double vy1,
                               double vx2, double vy2)
    {

    }

    @Override
    public void removeAll()
    {

    }
}

/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.implementation;

import se.hig.oodp.lab.control.FigureHandler;
import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.component.Movable;
import se.hig.oodp.lab.model.component.Rotatable;
import se.hig.oodp.lab.model.component.Scalable;
import se.hig.oodp.lab.model.figure.Line;
import se.hig.oodp.lab.model.figure.Rectangle;
import se.hig.oodp.lab.model.figure.Square;
import se.hig.oodp.lab.model.figure.Triangle;
import se.hig.oodp.lab.model.simplefigure.Circle;
import se.hig.oodp.lab.model.simplefigure.Ellipse;
import se.hig.oodp.lab.model.simplefigure.Point;
import se.hig.oodp.lab.model.simplefigure.SimpleFigure;
import se.hig.oodp.lab.utility.DebugLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 5, 2015
 */
public class FigureHandlerImpl implements FigureHandler
{
    private List<SimpleFigure> allFigures;
    private List<Movable>      movableFigures;
    private List<Rotatable>    rotatableFigures;
    private List<Scalable>     scalableFigures;

    public FigureHandlerImpl()
    {
        allFigures = new ArrayList<>();
        movableFigures = new ArrayList<>();
        rotatableFigures = new ArrayList<>();
        scalableFigures = new ArrayList<>();
    }

    @Override
    public void createCircle(double x, double y, double r)
    {
        Circle c = new Circle(new Vertex2D(x, y), r);

        allFigures.add(c);
        movableFigures.add(c);
        scalableFigures.add(c);

        DebugLogger.log.info("Created a new \"Circle\"");
    }

    @Override
    public void createEllipse(double x, double y, double a, double b)
    {
        Ellipse e = new Ellipse(new Vertex2D(x, y), a, b);

        allFigures.add(e);
        movableFigures.add(e);
        rotatableFigures.add(e);
        scalableFigures.add(e);

        DebugLogger.log.info("Created a new \"Ellipse\"");
    }

    @Override
    public void createLine(double x0, double y0, double x1, double y1)
    {
        Line l = new Line(new Vertex2D(x0, y0), new Vertex2D(x1, y1));

        allFigures.add(l);
        movableFigures.add(l);
        rotatableFigures.add(l);
        scalableFigures.add(l);

        DebugLogger.log.info("Created a new \"Line\"");
    }

    @Override
    public void createPoint(double x, double y)
    {
        Point p = new Point(new Vertex2D(x, y));

        allFigures.add(p);
        movableFigures.add(p);

        DebugLogger.log.info("Created a new \"Point\"");
    }

    @Override
    public void createRectangle(double x, double y, double a, double b)
    {
        Rectangle r = new Rectangle(new Vertex2D(x, y), a, b);

        allFigures.add(r);
        movableFigures.add(r);
        rotatableFigures.add(r);
        scalableFigures.add(r);

        DebugLogger.log.info("Created a new \"Rectangle\"");
    }

    @Override
    public void createSquare(double x, double y, double a, double b)
    {
        double side = (a > b) ? a : b;
        Square s = new Square(new Vertex2D(x, y), side);

        allFigures.add(s);
        movableFigures.add(s);
        rotatableFigures.add(s);
        scalableFigures.add(s);

        DebugLogger.log.info("Created a new \"Square\"");
    }

    @Override
    public void createTriangle(double vx0, double vy0, double vx1, double vy1,
                               double vx2, double vy2)
    {
        Triangle t = new Triangle(new Vertex2D(vx0, vy0),
                                  new Vertex2D(vx1, vy1),
                                  new Vertex2D(vx2, vy2));

        allFigures.add(t);
        movableFigures.add(t);
        rotatableFigures.add(t);
        scalableFigures.add(t);

        DebugLogger.log.info("Created a new \"Triangle\"");
    }

    @Override
    public void removeAll()
    {
        allFigures.clear();
        movableFigures.clear();
        rotatableFigures.clear();
        scalableFigures.clear();
        DebugLogger.log.info("Cleared all lists");
    }
}

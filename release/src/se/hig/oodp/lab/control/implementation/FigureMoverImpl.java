/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.implementation;

import java.util.ArrayList;
import java.util.List;

import se.hig.oodp.lab.control.FigureMover;
import se.hig.oodp.lab.model.component.Movable;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date    Oct 5, 2015
 */
public class FigureMoverImpl implements FigureMover
{
    private List<Movable> movableFigures;

    public FigureMoverImpl()
    {
        movableFigures = new ArrayList<>();
    }

    public FigureMoverImpl(ArrayList<Movable> movableFigures)
    {
        this.movableFigures = movableFigures;
    }

    @Override public void moveAll(double dx, double dy)
    {
        for (Movable f : movableFigures) {
            if (f == null)
                continue;

            f.moveBy(dx, dy);
        }

    }
}

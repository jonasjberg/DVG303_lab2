/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.implementation;

import se.hig.oodp.lab.control.FigureScalor;
import se.hig.oodp.lab.model.component.Scalable;

import java.util.ArrayList;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 5, 2015
 */
public class FigureScalorImpl implements FigureScalor
{
    private ArrayList<Scalable> scalableFigures;

    public FigureScalorImpl()
    {
        scalableFigures = new ArrayList<>();
    }

    public FigureScalorImpl(ArrayList<Scalable> scalableFigures)
    {
        this.scalableFigures = scalableFigures;
    }

    @Override
    public void scaleAll(double factor_x, double factor_y)
    {
        for (Scalable f : scalableFigures) {
            if (f == null)
                continue;

            f.scale(factor_x, factor_y);
        }

    }
}

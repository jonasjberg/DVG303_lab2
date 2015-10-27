/**
 * DVG303 :: Objektorienterad design och programmering
 * Laboration #2
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.control.implementation;

import se.hig.oodp.lab.control.FigureRotor;
import se.hig.oodp.lab.model.component.Rotatable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 5, 2015
 */
public class FigureRotorImpl implements FigureRotor
{
    private List<Rotatable> rotatableFigures;

    public FigureRotorImpl()
    {
        rotatableFigures = new ArrayList<>();
    }

    public FigureRotorImpl(ArrayList<Rotatable> rotatableFigures)
    {
        this.rotatableFigures = rotatableFigures;
    }

    @Override
    public void rotateAll(double angle)
    {
        for (Rotatable f : rotatableFigures) {
            if (f == null)
                continue;

            f.rotate(angle);
        }

    }
}

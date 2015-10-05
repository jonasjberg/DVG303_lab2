package se.hig.oodp.lab.control.implementation;

import se.hig.oodp.lab.control.FigurePrinter;
import se.hig.oodp.lab.model.figure.Figure;

import java.util.List;

class FigurePrinterImpl implements FigurePrinter
{
    List<Figure> figures;

    public FigurePrinterImpl(List<Figure> figures)
    {
        this.figures = figures;
    }

    @Override
    public void printAll()
    {
        for (Figure f : figures)
            System.out.println(f);
    }
}

package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EnveloppeBuilder {

    private List<Double> xVals;
    private List<Double> yVals;

    public EnveloppeBuilder() {
        xVals = new ArrayList<>();
        yVals = new ArrayList<>();
    }

    public void insert(Coordinate coordinate) {
        if (coordinate != null) {
            xVals.add(coordinate.getX());
            yVals.add(coordinate.getY());
        }
    }

    public Enveloppe build() {
        double xmin = Collections.min(xVals);
        double xmax = Collections.max(xVals);
        double ymin = Collections.min(yVals);
        double ymax = Collections.max(yVals);

        Coordinate bottomLeft = new Coordinate(xmin, ymin);
        Coordinate topRight = new Coordinate(xmax, ymax);

        return new Enveloppe(bottomLeft, topRight);
    }
}

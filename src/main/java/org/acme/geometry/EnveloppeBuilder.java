package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EnveloppeBuilder implements GeometryVisitor<Void>{

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

    @Override
    public Void visit(Point point) {
        if (!point.isEmpty()) {
            insert(point.getCoordinate());
        }
        return null;
    }

    @Override
    public Void visit(LineString lineString) {
        if (!lineString.isEmpty()) {
            for (int i = 0; i<lineString.getNumPoints();i++) {
                visit(lineString.getPointN(i));
            }
        }
        return null;
    }

    @Override
    public Void visit(GeometryCollection geometryCollection) {
        if (!geometryCollection.isEmpty()){
            for (int i =0; i < geometryCollection.getNumGeometries(); i++) {
                geometryCollection.getGeometryN(i).getEnvelope();
            }
        }
        return null;
    }
  
}

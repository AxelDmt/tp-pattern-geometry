package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{

    private PrintStream out;

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }

    public void visit(Point point) {
        if (point.isEmpty()) {
            out.print("Je suis un point vide.\n");
        } else {
            out.print("Je suis un point avec x = " + point.getCoordinate().getX() + 
                " et y = " + point.getCoordinate().getY() + ".\n");
        }
    }

    public void visit(LineString lineString) {
        int numPoints = lineString.getNumPoints();
        if (lineString.isEmpty()) {
            out.print("Je suis une polyligne vide.\n");
        } else {
            out.print("Je suis une polyligne définie par " + numPoints + " point(s).\n");
        }
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        int numGeom = geometryCollection.getNumGeometries();
        if (geometryCollection.isEmpty()) {
            out.print("Je suis une polyligne vide.\n");
        } else {
            out.print("Je suis une collection de géométrie définie par " + numGeom + " géométrie(s).\n");
        }
    }
}

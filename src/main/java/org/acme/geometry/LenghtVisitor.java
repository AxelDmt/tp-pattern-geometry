package org.acme.geometry;

public class LenghtVisitor implements GeometryVisitor<Double> {

    @Override
    public Double visit(Point point) {
        return 0.0; 
    }

    @Override
    public Double visit(LineString lineString) {
        double length = 0.0;
        for (int i = 1; i < lineString.getNumPoints(); i++) {
            length += calculateDistance(lineString.getPointN(i-1), lineString.getPointN(i));
        }
        return length;
    }

    private double calculateDistance(Point p1, Point p2) {
        double x1 = p1.getCoordinate().getX();
        double y1 = p1.getCoordinate().getY();
        double x2 = p2.getCoordinate().getX();
        double y2 = p2.getCoordinate().getY();

        double deltaX = x2 - x1;
        double deltaY = y2 - y1;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public Double visit(GeometryCollection geometryCollection) {
        Double length = 0.0;
        for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
            length += geometryCollection.getGeometryN(i).accept(this);
        }
        return length;
    }
}
package org.acme.geometry;

import org.acme.geometry.Coordinate;

// Classe Point implémentant l'interface Geometry
public class Point extends AbstractGeometry{

    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        this.coordinate = (coordinate != null) ? coordinate : new Coordinate();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void translate(double x, double y) {
        Coordinate newCoordinate = new Coordinate(coordinate.getX() + x, coordinate.getY() + y);
        this.coordinate = newCoordinate;
    }

    @Override
    public boolean isEmpty() {
        return coordinate.isEmpty();
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public Point clone() {
        return new Point(coordinate);
    }

    @Override
    public Enveloppe getEnvelope() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        builder.insert(coordinate);
        return builder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}

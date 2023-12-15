package org.acme.geometry;

import org.acme.geometry.Coordinate;

// Classe Point implémentant l'interface Geometry
public class Point implements Geometry {

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
    public Geometry clone() {
        return new Point(new Coordinate(this.coordinate.getX(), this.coordinate.getY()));
    }
}

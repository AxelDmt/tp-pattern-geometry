package org.acme.geometry;

public class Point extends Geometry{

    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate){
        this.coordinate = (coordinate != null) ? coordinate : new Coordinate();
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }
}
